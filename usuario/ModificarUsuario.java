package usuario;
import java.io.IOException;

import classes_acoes_arquivos.ModificarRegistrosBaseDados;

public class ModificarUsuario {

    private boolean mod_user = false; 
    private boolean mod_senha = false;
    
    private int id_modificar;
    private String user;
    private String senha;

    private String nome_arquivo = "/home/rodrigo/aprendendo_java/arquivosTxt/contas.txt";

    public ModificarUsuario(int id_modificar, String user, String senha){

        if(!user.equals("")){
            this.user = user;
            this.mod_user = true;
        }

        if(!senha.equals("")){
            this.senha = senha;
            this.mod_senha = true;
        }    
        this.id_modificar = id_modificar;

    }
    public int modificar()throws IOException{

        String[] dados_modificar = {};
        int[] colunas_modificar = {};

        if(this.mod_user){
            dados_modificar[0] = this.user;

            if(!senha.equals(""))
            colunas_modificar[0] = 1;
        }

        if(this.mod_senha){
            dados_modificar[1] = this.senha;
            colunas_modificar[1] = 2;
        }    

        ModificarRegistrosBaseDados obj_modificar = new ModificarRegistrosBaseDados(this.id_modificar,colunas_modificar, dados_modificar,this.nome_arquivo);

        int id_registro = obj_modificar.modificar();

        return id_registro;

    }
}    