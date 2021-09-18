import cliente.CriarCliente;
import conta.CriarConta;
import input_output.*;
import usuario.CriarUsuario;
import java.io.IOException;


public class CriarContaNoBanco {
    
    public static void criar()throws IOException{

        String nome = In.input("digite nome:");
        String user = In.input("digite seu user:");
        String saldo_inicial = In.input("digite o saldo inicial:");
        String senha = In.input("digite uma senha forte:");

        int id_usuario = new CriarUsuario(user, senha).criar();
        int id_cliente = new CriarCliente(nome).criar();
        int id_conta ;

        if(id_cliente >= 0 && id_usuario >= 0){
            id_conta = new CriarConta(id_cliente, id_usuario, Float.parseFloat(saldo_inicial)).criar();

            templateSucesso(nome,user,senha,saldo_inicial);
        }    

    }

    public static void templateSucesso( String nome, String user, String senha, String saldo_inicial){

        System.out.print("\nSua conta foi criada com sucesso!\n");
        System.out.print("\n    Titular: "+ nome);
        System.out.print("\n    Login: "+ user);
        System.out.print("\n    Senha: "+ senha);
        System.out.print("\n    Saldo: R$"+ saldo_inicial);

    }
    
    
}
