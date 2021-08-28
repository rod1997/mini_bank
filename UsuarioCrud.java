import java.io.IOException;

public class UsuarioCrud {

    private String id;
    private String user;
    private String senha;
    private String nome_arquivo = "/home/rodrigo/aprendendo_java/arquivosTxt/usuarios.txt";

    public UsuarioCrud(String user, String senha, String id){

        this.user = user;
        this.senha = senha;
        this.id = id;

    }
    public String[] lerDadosUsuario() throws IOException{

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo(this.nome_arquivo);

        String[] dadosUsuario = objetoArquivo.lerRegistro(this.id);

        return dadosUsuario;
    }
    public Boolean cadastrar()throws IOException{

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo(this.nome_arquivo);
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

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo(this.nome_arquivo);
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

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo(this.nome_arquivo);
        int idRetornado = objetoArquivo.deletarRegistro(this.id);

        if(idRetornado != 0){
            return true;
        }
        return false;
    }
}
