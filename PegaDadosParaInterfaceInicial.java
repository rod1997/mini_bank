import java.io.IOException;

public class PegaDadosParaInterfaceInicial {
    
    private String id_usuario;
    private String[] dados_retorno;
    
    public PegaDadosParaInterfaceInicial(String id_usuario)throws IOException{

        this.id_usuario = id_usuario;
        this.getDadosParaInterface();

    }
    public String[] getDadosInterface(){
        return this.dados_retorno;
    }
    private void getDadosParaInterface()throws IOException{

        String[] dadosConta = new ContaCrud("",this.id_usuario,"","").dadosContaIdUsuario();

        String id_cliente = dadosConta[2];
        String[] dadosCliente = new ClienteCrud(id_cliente,"").lerDadosCliente();

        String saldo = dadosConta[3];
        String nome_cliente = dadosCliente[1];
        String id_conta = dadosConta[0];

        String[] dados = {
            id_conta,
            id_cliente,
            nome_cliente,
            saldo
        };
        this.dados_retorno = dados;

    }

}
