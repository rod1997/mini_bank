import java.io.IOException;

public class ClienteCrud {

    private String id;
    private String nome;
    private String nome_arquivo = "/home/rodrigo/aprendendo_java/arquivosTxt/clientes.txt";


    public ClienteCrud(String id, String nome){

        this.id = id;   
        this.nome = nome;

    }
    public String[] lerDadosCliente() throws IOException{

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo(this.nome_arquivo);

        String[] dadosUsuario = objetoArquivo.lerRegistro(this.id);

        return dadosUsuario;
    }
    public int cadastrar()throws IOException{

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo(this.nome_arquivo);
        String[] dadosClienteCadastro = {
                                            this.nome 
                                        };
        int idRetornado = objetoArquivo.inserirRegistro(dadosClienteCadastro);

        if(idRetornado != 0){
            return idRetornado;
        }
        return 0;
    }
    public Boolean modificar()throws IOException{

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo(this.nome_arquivo);
        String[] dadosClienteModificar = {
                                            this.nome 
                                        };
        int idRetornado = objetoArquivo.modificarRegistro(dadosClienteModificar, this.id);

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
