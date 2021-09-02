import java.text.NumberFormat;
import java.io.IOException;

public class MenuInicial {
    
    private String id_usuario;
    private String id_cliente;
    private String id_conta;
    private String saldo;
    private String nome_cliente;

    MenuInicial( String id_usuario, String id_cliente, String id_conta, String saldo, String nome_cliente){

        this.id_usuario = id_usuario;
        this.id_cliente = id_cliente;
        this.id_conta = id_conta;
        this.saldo = saldo;
        this.nome_cliente = nome_cliente;
    }
    public void MenuInterativo()throws IOException{

        System.out.println("Bem vindo ao banco");
        System.out.println("Ola," + nome_cliente);
        NumberFormat z = NumberFormat.getCurrencyInstance();
        System.out.println("Seu saldo: "+ z.format(Integer.parseInt(saldo)));

        String opcao =  BancoZeroTaxa.inputUsuario("[1] transferir, [5]sair");

        switch (opcao) {
            case "1":
                this.transferencia();
                break;
        
            default:
                break;
        }

    }
    public void transferencia()throws IOException{

        String valor_tranferencia =  BancoZeroTaxa.inputUsuario("Digite o valor a transferir: ");
        String id_conta_destino =  BancoZeroTaxa.inputUsuario("digite a conta destino: ");

        System.out.println("-------- DADOS DA TRANSACAO ------\n");
        System.out.println("");
        System.out.println("Conta destino: "+ id_conta_destino);
        System.out.println("Nome beneficiario: NULL ");
        System.out.println("Valor a transferir: "+ valor_tranferencia);

        boolean retornoTransacao = new TransferirDinheiro(this.id_conta, id_conta_destino, Integer.parseInt(valor_tranferencia)).transferir();

        if(retornoTransacao){
            System.out.println("Vtransacao efetuada com sucesso");
        }else{
            System.out.println("operacao nao concluida");

        }

    }
}
