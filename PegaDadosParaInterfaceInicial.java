import java.io.IOException;
import classes_acoes_arquivos.BuscaRegistrosBaseDados;

public class PegaDadosParaInterfaceInicial {
    
    private String id_usuario;
    private String nome_arquivo_contas = System.getProperty("user.dir")+"/arquivos_txt/contas.txt";
    private String nome_arquivo_clientes = System.getProperty("user.dir")+"/arquivos_txt/clientes.txt";

    
    public PegaDadosParaInterfaceInicial(String id_usuario){

        this.id_usuario = id_usuario;

    }
    public TodosDados retornaTodosDados()throws IOException{

        BuscaRegistrosBaseDados obj_busca = new BuscaRegistrosBaseDados(1,this.id_usuario, this.nome_arquivo_contas);

        String[] dados_conta = obj_busca.getResultados()[0];

        String id_cliente = dados_conta[2];

        BuscaRegistrosBaseDados obj_busca2 = new BuscaRegistrosBaseDados(0,id_cliente, this.nome_arquivo_clientes);

        String[] dados_cliente = obj_busca2.getResultados()[0];

        TodosDados objDados = new TodosDados(Integer.parseInt(dados_conta[0]), Integer.parseInt(dados_conta[1]), Integer.parseInt(id_cliente), dados_cliente[1], Float.parseFloat(dados_conta[3]));

        return objDados;
    }

}
