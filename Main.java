import java.io.IOException;
import java.text.NumberFormat;
import input_output.*;

public class Main {
        
    public static void main(String[] args) throws IOException{

        System.out.println("Olá, Bem Vindo Ao nosso Banco!");
        String opcao = In.input("[1] Acessar conta\n[2] Criar conta\n");

        switch(opcao){
            case "1":
                AcessarConta.acessar();
                break;

            case "2":
                CriarContaNoBanco.criar();
                break;

            default:
                System.out.println("saindo..");
                break;
        }  
    }
}    