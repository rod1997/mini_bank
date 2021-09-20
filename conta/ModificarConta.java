package conta;
import java.io.IOException;

import classes_acoes_arquivos.ModificarRegistrosBaseDados;

public class ModificarConta {

    private boolean mod_id_cliente = false; 
    private boolean mod_id_usuario = false;

    private int id_modificar;
    private int id_cliente;
    private int id_usuario;

    private String nome_arquivo = System.getProperty("user.dir")+"/arquivos_txt/contas.txt";

    public ModificarConta(int id_modificar, int id_cliente, int id_usuario){

        if(id_cliente >= 0){
            this.id_cliente = id_cliente;
            this.mod_id_cliente = true;
        }    

        if(id_usuario >= 0){
            this.id_usuario = id_usuario;
            this.mod_id_usuario = true;
        }    
    }
    public int modificar()throws IOException{

        String[] dados_modificar = {};
        int[] colunas_modificar = {};

        if(this.mod_id_cliente){
            dados_modificar[0] = Integer.toString(this.id_cliente);
            colunas_modificar[0] = 1;
        }

        if(this.mod_id_usuario){
            dados_modificar[1] = Integer.toString(this.id_usuario);
            colunas_modificar[1] = 2;
        }    

        ModificarRegistrosBaseDados obj_modificar = new ModificarRegistrosBaseDados(this.id_modificar,colunas_modificar, dados_modificar,this.nome_arquivo);

        int id_registro = obj_modificar.modificar();

        return id_registro;

    }
}    