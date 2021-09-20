package cliente;
import java.io.IOException;

import classes_acoes_arquivos.ModificarRegistrosBaseDados;

public class ModificarCliente {

    private int id_modificar;
    private String nome;
    private String nome_arquivo = System.getProperty("user.dir")+"/arquivos_txt/clientes.txt";

    public ModificarCliente(String nome){

        this.nome = nome;
       
    }
    public int modificar()throws IOException{

        String[] dados_modificar = {this.nome};
        int[] colunas_modificar = {1};
  
        ModificarRegistrosBaseDados obj_modificar = new ModificarRegistrosBaseDados(this.id_modificar,colunas_modificar, dados_modificar,this.nome_arquivo);

        int id_registro = obj_modificar.modificar();

        return id_registro;

    }
}    