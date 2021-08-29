import java.io.IOException;
import java.util.Scanner;
import java.text.NumberFormat;

public class BancoZeroTaxa {
        
    public static void main(String[] args) throws IOException{
        System.out.println("Olá, Bem Vindo Ao nosso Banco!");
        String opcao = inputUsuario("[1] Acessar conta\n[2] Criar conta\n");

        switch(opcao){
            case "1":
                acessarConta();
                break;

            case "2":
                criarConta();
                break;

            default:
                System.out.println("saindo..");
                break;
        }  
    }
    public static void acessarConta()throws IOException{

        String user = inputUsuario("digite seu user: ");
        String senha = inputUsuario("digite sua senha:");

        int id_usuario = new LoginUsuario(user, senha).getRetornoLogin();

        if(id_usuario != 0){

            String[] dadosConta = new PegaDadosParaInterfaceInicial(Integer.toString(id_usuario)).getDadosInterface();
            System.out.println("\nOlá, "+ dadosConta[2]);
            NumberFormat z = NumberFormat.getCurrencyInstance();
            System.out.println("Seu saldo: "+ z.format(Integer.parseInt(dadosConta[3])));

        }else{
            System.out.println("Usuario ou senha incorretos!");

        }
    }
    public static void criarConta()throws IOException{

        String nome = inputUsuario("digite nome:");
        String user = inputUsuario("digite seu user:");
        String senha = inputUsuario("digite uma senha forte:");
        String saldo = inputUsuario("digite o saldo inicial:");

        int id_usuario = new UsuarioCrud(user, senha, "").cadastrar();
        int id_cliente = new ClienteCrud("", nome).cadastrar();
        int id_conta = new ContaCrud("", Integer.toString( id_usuario), Integer.toString( id_cliente) , saldo).cadastroConta();

        print("Sua conta foi criada com sucesso!\n");
        print("dados da sua conta:\n");
        print("titular: "+ nome);
        print("login: "+ user);
        print("senha: "+ senha);
        print("saldo: "+ saldo);

    }
    public static String inputUsuario(String msg){

        Scanner input_usuario = new Scanner(System.in);
        System.out.print(msg);
        String msg_digitada = input_usuario.nextLine();
        return msg_digitada;
    }

    public static void print(String msg){
        System.out.print(msg);
    }

}