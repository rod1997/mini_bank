package cliente;
import java.io.IOException;

import classes_acoes_arquivos.AdicionarRegistroBaseDados;

public class CriarCliente {

    private String nome;
    private String nome_arquivo = "/home/rodrigo/aprendendo_java/arquivosTxt/clientes.txt";

    public CriarCliente(String nome){

      this.nome = nome;
    }
    public int criar()throws IOException{

        String[] dados_adicionar = {this.nome};
        AdicionarRegistroBaseDados obj_adicionar = new AdicionarRegistroBaseDados(dados_adicionar, this.nome_arquivo);

        int id_registro = obj_adicionar.adicionar();

        return id_registro;

    }
}    
