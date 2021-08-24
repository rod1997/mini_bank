import java.io.IOException;

public class UsuarioCrud {

    private String id;
    private String user;
    private String senha;

    public UsuarioCrud(String user, String senha, String id){

        this.user = user;
        this.senha = senha;
        this.id = id;

    }
    public Boolean logar() throws IOException{

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo("usuarios.txt");

        String[] dadosUsuario = objetoArquivo.lerRegistro(this.id);

        if(dadosUsuario[1] == this.user && dadosUsuario[1] == this.senha){

            return true;
        }
        return false;
    }
    public Boolean cadastrar()throws IOException{

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo("usuarios.txt");
        String[] dadosUsuarioCadastro = {
                                            this.user,
                                            this.senha
                                        };
        int idRetornado = objetoArquivo.inserirRegistro(dadosUsuarioCadastro);

        if(idRetornado != 0){
            return true;
        }
        return false;
    }
    public Boolean modificar()throws IOException{

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo("usuarios.txt");
        String[] dadosUsuarioCadastro = {
                                            this.user,
                                            this.senha
                                        };
        int idRetornado = objetoArquivo.modificarRegistro(dadosUsuarioCadastro, this.id);

        if(idRetornado != 0){
            return true;
        }
        return false;
    }
    public Boolean deletar()throws IOException{

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo("usuarios.txt");
        int idRetornado = objetoArquivo.deletarRegistro(this.id);

        if(idRetornado != 0){
            return true;
        }
        return false;
    }
}
