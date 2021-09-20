package conta;
import java.io.IOException;

import classes_acoes_arquivos.AdicionarRegistroBaseDados;

public class CriarConta {
    private int id_cliente;
    private int id_usuario;
    private float saldo_inicial;
    private String nome_arquivo = System.getProperty("user.dir")+"/arquivos_txt/contas.txt";

    public CriarConta(int id_cliente, int id_usuario, float saldo_inicial){

        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
        this.saldo_inicial = saldo_inicial >= 0 ?  saldo_inicial : 0 ;
    }
    public int criar()throws IOException{

        String[] dados_adicionar = {
            Integer.toString(this.id_cliente), 
            Integer.toString(this.id_usuario), 
            Float.toString(this.saldo_inicial)
        };
        AdicionarRegistroBaseDados obj_adicionar = new AdicionarRegistroBaseDados(dados_adicionar, this.nome_arquivo);

        int id_registro = obj_adicionar.adicionar();

        return id_registro;

    }
}    
