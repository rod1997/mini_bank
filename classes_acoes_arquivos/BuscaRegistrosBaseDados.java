package classes_acoes_arquivos;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class BuscaRegistrosBaseDados {
    
    private int coluna_busca;
    private String busca;
    private String[][] retorno_busca;
    private String nome_arquivo;

    public BuscaRegistrosBaseDados(int coluna_busca,String busca,String arquivo)throws IOException{

        this.coluna_busca = coluna_busca;
        this.busca = busca;
        this.nome_arquivo = arquivo;
        this.buscarResgistros();
    }
    public String[][] getResultados(){

        return this.retorno_busca;
    }
    private void buscarResgistros()throws IOException{

        BufferedReader BufferLeitura = new BufferedReader(new FileReader(this.nome_arquivo));
        String dados_busca = "";

        while(true){
            String linha = BufferLeitura.readLine();
            if( linha == null){
                break;

            }
            String[] linhaArray = linha.split("__");

            if( linhaArray[this.coluna_busca].contains(this.busca)){

                dados_busca += linha + ";";

            }    
        }	
        String[] arrayLinha =  dados_busca.split(";");
        String[] arrarDadosLinha = arrayLinha[0].split("__");

        String[][] h_dados = new String[arrayLinha.length][arrarDadosLinha.length];

        for(int c=0 ; c < arrayLinha.length ; c++ ){

            String[] dadosLinha = arrayLinha[c].split("__");
            for(int d=0; d< arrarDadosLinha.length; d++){
                h_dados[c][d] = dadosLinha[d];
            }	
        }
        this.retorno_busca = h_dados;

        BufferLeitura.close();
    }    
}
