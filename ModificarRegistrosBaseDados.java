import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModificarRegistrosBaseDados {

    private int id_modificar;
    private int id_modificado;

    private String nome_arquivo;

    // o primerio indice de "colunas_modificar" corresponde a modificacao para o valor do primeiro de "dados_modificacao ""
    private int[] colunas_modificar;
    private String[] dados_modificacao;

    private String todos_dados;
    private Boolean falha = true;

    ModificarRegistrosBaseDados(String nome_arquivo ,int[] colunas_modificar ,String[] dados_modificacao ,int id_modificar){

        this.nome_arquivo   = nome_arquivo;
        this.colunas_modificar = colunas_modificar;
        this.dados_modificacao = dados_modificacao;
        this.id_modificar  = id_modificar;

    }
    public int modificar()throws IOException{

        modificarRegistro();

        if(!this.falha ) {
            salvarAlteracoes();
            return id_modificado;
        }
        return 0;

    }
    private void modificarRegistro()throws IOException{

        BufferedReader BufferLeitura = new BufferedReader(new FileReader(this.nome_arquivo));
        String linha = "";

        while(linha != null){

            linha = BufferLeitura.readLine();
            String[] dadoslinha = linha.split("__");

            int numeroDeModificacao = this.dados_modificacao.length;
            int numeroDeColunasModificacao = this.dados_modificacao.length;
            int numeroDeColunasTabela = dadoslinha.length - 1;

            if(numeroDeColunasModificacao > numeroDeColunasTabela || numeroDeModificacao > numeroDeColunasTabela || numeroDeColunasModificacao != numeroDeModificacao){
                this.falha = true;
                break;
            }
           
            int id = Integer.parseInt(dadoslinha[0]);

            int id_modificar = this.id_modificar;

            if(id == id_modificar){

                String textoDeinsercao = "";
    
                for(int c = 1  ; c < numeroDeColunasTabela ; c++ ){

                    if( c == this.colunas_modificar[c]){
                        textoDeinsercao += "__" + dados_modificacao[c];
                    }
                    textoDeinsercao += "__" + dadoslinha[c];
                }

                this.todos_dados +=  dadoslinha[0] +  textoDeinsercao + "\n";
                this.id_modificado = Integer.parseInt(dadoslinha[0]);
                this.falha = false;
            }else{
                this.todos_dados +=  linha + "\n";
            }	
        }
        BufferLeitura.close();
    }
    private void salvarAlteracoes() throws IOException {

        if(!this.falha){
            BufferedWriter BufferEscrita = new BufferedWriter(new FileWriter(this.nome_arquivo,false));
            
            BufferEscrita.write(this.todos_dados);
            BufferEscrita.flush();
            BufferEscrita.close();
        }    
	
	}
}
