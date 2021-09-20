import java.text.NumberFormat;
import java.io.IOException;
import input_output.In;

public class MenuUsuarioLogado {

    public static void MenuInterativo(TodosDados dados)throws IOException{

        System.out.println("Bem vindo ao banco");
        System.out.println("Ola," + dados.nome);
        NumberFormat z = NumberFormat.getCurrencyInstance();
        System.out.println("Seu saldo: "+ z.format(dados.saldo));

        String opcao =  In.input("[1] transferir, [5]sair");

        switch (opcao) {
            case "1":
                transferencia(dados);
                break;
        
            default:
                break;
        }

    }
    public static void transferencia(TodosDados dados_conta_origem)throws IOException{

        String valor_tranferencia =  In.input("Digite o valor a transferir: ");
        String id_conta_destino =  In.input("digite a conta destino: ");

        System.out.println("-------- DADOS DA TRANSACAO ------\n");
        System.out.println("");
        System.out.println("Conta destino: "+ id_conta_destino);
        System.out.println("Nome beneficiario: ");
        System.out.println("Valor a transferir: "+ valor_tranferencia);

        boolean retornoTransacao = new TransferirDinheiro(dados_conta_origem, Integer.parseInt(id_conta_destino), Float.parseFloat(valor_tranferencia)).transferir();

        if(retornoTransacao){
            System.out.println("Transacao efetuada com sucesso");
        }else{
            System.out.println("Operacao nao concluida");

        }

    }
}
