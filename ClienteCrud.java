import java.io.IOException;

public class ClienteCrud {

    private String id;
    private String nome;
    private String id_conta;
    private String id_usuario;

    public ClienteCrud(String id, String id_conta, String id_usuario, String nome){

        this.id = id;   
        this.id_conta = id_conta;
        this.id_usuario = id_usuario;
        this.nome = nome;


    }
    public String[] lerDadosCliente() throws IOException{

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo("clientes.txt");

        String[] dadosUsuario = objetoArquivo.lerRegistro(this.id);

        return dadosUsuario;
    }
    public Boolean cadastrar()throws IOException{

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo("clientes.txt");
        String[] dadosClienteCadastro = {
                                            this.id_conta,
                                            this.id_usuario,
                                            this.nome 
                                        };
        int idRetornado = objetoArquivo.inserirRegistro(dadosClienteCadastro);

        if(idRetornado != 0){
            return true;
        }
        return false;
    }
    public Boolean modificar()throws IOException{

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo("clientes.txt");
        String[] dadosClienteCadastro = {
                                            this.id_conta ,
                                            this.id_usuario,
                                            this.nome 
                                        };
        int idRetornado = objetoArquivo.modificarRegistro(dadosClienteCadastro, this.id);

        if(idRetornado != 0){
            return true;
        }
        return false;
    }
    public Boolean deletar()throws IOException{

        ManipuladorArquivo objetoArquivo = new ManipuladorArquivo("clientes.txt");
        int idRetornado = objetoArquivo.deletarRegistro(this.id);

        if(idRetornado != 0){
            return true;
        }
        return false;
    }
}
