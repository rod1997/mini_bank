package classes_acoes_arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ModificarRegistrosBaseDados extends SalvarAlteracoes{

    private int id_modificar;
    private int id_modificado;

    // o primerio indice de "colunas_modificar" corresponde a modificacao para o valor do primeiro de "dados_modificacao ""
    private int[] colunas_modificar;
    private String[] dados_modificacao;


    public ModificarRegistrosBaseDados(int id_modificar, int[] colunas_modificar ,String[] dados_modificacao ,String nome_arquivo){

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
        return -1;

    }
    private void modificarRegistro()throws IOException{

        BufferedReader BufferLeitura = new BufferedReader(new FileReader(this.nome_arquivo));
        String linha = "";

        while(true){

            linha = BufferLeitura.readLine();
            if(linha == null)
                break;

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

                for(int c = 1  ; c <= numeroDeColunasTabela ; c++ ){

                    boolean coluna_achada = false;

                    for( int indice_coluna :  this.colunas_modificar){
                        int contador = 0;

                        if(indice_coluna == c ){
                            textoDeinsercao += "__" + dados_modificacao[contador];
                            coluna_achada = true;
                            break;
                        }    
                        contador++;    
                    }
                    if(!coluna_achada)
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
}
