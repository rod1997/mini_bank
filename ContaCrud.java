import java.io.IOException;

public class ContaCrud{
    
    private String id;
    private String id_usuario;
    private String id_cliente;
    private String saldo;
    private String nome_arquivo = "/home/rodrigo/aprendendo_java/arquivosTxt/contas.txt";

    public ContaCrud(String id, String id_usuario, String id_cliente,String saldo){

        this.id = id;
        this.id_usuario = id_usuario;
        this.id_cliente = id_cliente;
        this.saldo = (saldo == null )? "0" : saldo;
    }
    public String[] dadosContaIdUsuario()throws IOException{

        int coluna_busca = 1;
        String busca = this.id_usuario;
        String arquivo = this.nome_arquivo;
        String[][] dadosConta = new BuscaRegistrosBaseDados(coluna_busca, busca, arquivo).getResultados();

        return dadosConta[0];
    }
    public String[] dadosConta() throws IOException{

        ManipuladorArquivo objArquivo = new ManipuladorArquivo(this.nome_arquivo);

        String[] dadosContas = objArquivo.lerRegistro(this.id);

        return dadosContas;
    }
    public Boolean cadastroConta()throws IOException{
        
        ManipuladorArquivo objArquivo = new ManipuladorArquivo(this.nome_arquivo);

        String[] parametrosInsercao = {
            this.saldo,
            this.id_cliente,
            this.id_usuario
        };

        int retornoCadastro = objArquivo.inserirRegistro(parametrosInsercao);

        if(retornoCadastro != 0){
            return true;
        }
        return false;
    }
    public Boolean modificarConta()throws IOException{
        ManipuladorArquivo objArquivo = new ManipuladorArquivo(this.nome_arquivo);

        String[] parametrosInsercao = {
            this.id_cliente,
            this.id_usuario
        };
        int retornoCadastro = objArquivo.modificarRegistro(parametrosInsercao, this.id);

        if(retornoCadastro != 0){
            return true;
        }
        return false;
    }
    public Boolean deletarConta()throws IOException{
        ManipuladorArquivo objArquivo = new ManipuladorArquivo(this.nome_arquivo);

        int retornoCadastro = objArquivo.deletarRegistro(this.id);

        if(retornoCadastro != 0){
            return true;
        }
        return false;
    }

}
