import java.io.IOException;
import java.util.Scanner;
import java.text.NumberFormat;

public class BancoZeroTaxa {
        
    public static void main(String[] args) throws IOException{
        System.out.println("Olá, Bem Vindo Ao nosso Banco!");

        Scanner inputUsuario = new Scanner(System.in);
        System.out.println("Digite sua login: ");

        String user = inputUsuario.nextLine();

        System.out.println("Digite sua senha: ");

        String senha = inputUsuario.nextLine();

        int id_usuario = new LoginUsuario(user, senha).getRetornoLogin();

        if(id_usuario > 0){

            String[] dadosConta = new PegaDadosParaInterfaceInicial(Integer.toString(id_usuario)).getDadosInterface();
            System.out.println("Olá, "+ dadosConta[2]);
            NumberFormat z = NumberFormat.getCurrencyInstance();
            System.out.println("Seu saldo: "+ z.format(Integer.parseInt(dadosConta[3])));

        }else{
            System.out.println("Usuario ou senha incorretos!");

        }

    }
  

}