import java.text.NumberFormat;
import java.io.IOException;

public class MenuUsuarioLogado {

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
