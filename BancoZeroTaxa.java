import java.io.IOException;

public class BancoZeroTaxa {
        
    public static void main(String[] args) throws IOException{
        System.out.println("Olá, mundo!");

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo();

        //String todosUsuarios = objetoArquivo.Ler_todos();
        //String[] Usuario = objetoArquivo.lerUmRegistro("1");


        int cadastrado = objetoArquivo.cadastrar("ggggg","1234");


        //System.out.print("todos Usuarios: \n" + todosUsuarios);
        //System.out.println("usuario: \n" + Usuario[1] + " senha: " + Usuario[2]);
        System.out.println("Novo usuario: "+ cadastrado + "\n");
      
        
    }

}