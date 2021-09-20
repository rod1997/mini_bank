import input_output.*;
import java.io.IOException;

public class AcessarConta {

    public static void acessar()throws IOException{

        String user = In.input("User: ");
        String senha = In.input("Senha: ");

        int id_usuario = new LoginUsuario(user, senha).getRetornoLogin();

        if(id_usuario >= 0){

            TodosDados objTodosDados = new PegaDadosParaInterfaceInicial(Integer.toString(id_usuario)).retornaTodosDados();
            //System.out.println("\nOlá, "+ dadosConta[2]);
            //NumberFormat z = NumberFormat.getCurrencyInstance();
            //System.out.println("Seu saldo: "+ z.format(Integer.parseInt(dadosConta[3])));

            MenuUsuarioLogado.MenuInterativo(objTodosDados);
            
        }else{
            System.out.println("Usuario ou senha incorretos!");

        }
    }
    
}
