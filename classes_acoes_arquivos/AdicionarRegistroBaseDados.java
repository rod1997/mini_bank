package classes_acoes_arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdicionarRegistroBaseDados extends SalvarAlteracoes{

    private String[] dados_insercao;
    private int ultimo_id_cadastrado;
    

    public AdicionarRegistroBaseDados(String nome_arquivo ,String[] dados_insercao ){

        this.nome_arquivo   = nome_arquivo;
        this.dados_insercao = dados_insercao;
        this.falha = true;

    }
    public int adicionar()throws IOException{

        adicionarRegistro();

        if(!this.falha ) {
            salvarAlteracoes();
            return this.ultimo_id_cadastrado;
        }
        return 0;

    }
    private void adicionarRegistro()throws IOException{

        try{
            BufferedReader BufferLeitura = new BufferedReader(new FileReader(this.nome_arquivo));
            String linha = "";

            while(true){

                linha = BufferLeitura.readLine();

                if(linha == null || linha.equals("")) {
                    break;

                }else{
                    String[] dadoslinha = linha.split("__");

                    this.ultimo_id_cadastrado = Integer.parseInt(dadoslinha[0]) + 1;
                    this.todos_dados +=  linha + "\n";	
                }
            }    

            int numeroDeParamentros = this.dados_insercao.length;
            String textoDeinsercao = "";

            for(int c =0 ; c < numeroDeParamentros ; c++ ){
                textoDeinsercao += "__" + dados_insercao[c];
            }
            this.todos_dados += Integer.toString(this.ultimo_id_cadastrado) + textoDeinsercao;

            BufferLeitura.close();

            this.falha = false;

        }catch(Exception | Error  e){
            this.falha = true;
        }    
    }
}
