package usuario;
import java.io.IOException;

import classes_acoes_arquivos.AdicionarRegistroBaseDados;

public class CriarUsuario {

    private String user;
    private String senha;
    private String nome_arquivo = "/home/rodrigo/aprendendo_java/arquivosTxt/usuarios.txt";

    public CriarUsuario(String user, String senha){

        this.user = user;
        this.senha = senha;
    }
    public int criar()throws IOException{

        String[] dados_adicionar = { this.user, this.senha };

        AdicionarRegistroBaseDados obj_adicionar = new AdicionarRegistroBaseDados(dados_adicionar, this.nome_arquivo);

        int id_registro = obj_adicionar.adicionar();

        return id_registro;

    }
}    
