import java.io.IOException;

public class LoginUsuario {

    private String user;
    private String senha;
    private int retornoLogin;
    private String nome_arquivo = "/home/rodrigo/aprendendo_java/arquivosTxt/usuarios.txt";

    public LoginUsuario(String user, String senha)throws IOException{

        this.user = user;
        this.senha  = senha;
        this.carregaDadosUsuario();
    }

    public int getRetornoLogin(){
        return this.retornoLogin;
    }

    private void carregaDadosUsuario()throws IOException{

        int coluna_busca = 1;
        String busca = this.user;
        String arquivo = this.nome_arquivo;

        String[][] dadosUsuario = new BuscaRegistrosBaseDados(coluna_busca, busca, arquivo).getResultados();

        if(dadosUsuario[0][0] != "" || dadosUsuario[0][0] == null){

            String usuario = dadosUsuario[0][1];
            String senha = dadosUsuario[0][2];
        
            //System.out.println(usuario);

            if(usuario.equals(this.user)  && senha.equals(this.senha) ){
            this.retornoLogin =  Integer.parseInt(dadosUsuario[0][0]);

            }else{
                this.retornoLogin = 0;
            }
        }else{
            this.retornoLogin = 0;
        }    

    }

}