import java.io.IOException;

public class ContaCrud{
    
    private String id;
    private String saldo;

    public ContaCrud(String id,String saldo){

        this.id = id;
        this.saldo = saldo;
    }
    public String[] dadosConta() throws IOException{

        ManipuladorArquivo objArquivo = new ManipuladorArquivo("contas.txt");

        String[] dadosContas = objArquivo.lerRegistro(this.id);

        return dadosContas;
    }
    public Boolean cadastroConta()throws IOException{
        
        ManipuladorArquivo objArquivo = new ManipuladorArquivo("contas.txt");

        String[] parametrosInsercao = {
            this.saldo
        };

        int retornoCadastro = objArquivo.inserirRegistro(parametrosInsercao);

        if(retornoCadastro != 0){
            return true;
        }
        return false;
    }
    public Boolean modificarConta()throws IOException{
        ManipuladorArquivo objArquivo = new ManipuladorArquivo("contas.txt");

        String[] parametrosInsercao = {
            this.saldo
        };
        int retornoCadastro = objArquivo.modificarRegistro(parametrosInsercao, this.id);

        if(retornoCadastro != 0){
            return true;
        }
        return false;
    }
    public Boolean deletarConta()throws IOException{
        ManipuladorArquivo objArquivo = new ManipuladorArquivo("contas.txt");

        int retornoCadastro = objArquivo.deletarRegistro(this.id);

        if(retornoCadastro != 0){
            return true;
        }
        return false;
    }

}
