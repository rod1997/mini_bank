import java.io.IOException;

public class TransferirDinheiro {

    private String id_conta_origem;
    private String id_conta_destino;
    private String[] dados_conta_origem;
    private String[] dados_conta_destino;

    private String  nome_arquivo = "/home/rodrigo/aprendendo_java/arquivosTxt/contas.txt";

    private int valor_tranferencia;

    TransferirDinheiro(String id_conta_origem ,String id_conta_destino, int valor_tranferencia){

        this.id_conta_destino = id_conta_destino;
        this.id_conta_origem = id_conta_origem;
        this.valor_tranferencia = valor_tranferencia;
    }
    public boolean transferir()throws IOException{

        if(validarSaldoContaOrigem()){

            int saldo_conta_origem = Integer.parseInt(dados_conta_origem[3]);
            int saldo_conta_destino = Integer.parseInt(dados_conta_destino[3]);

            int valor_diminuir_conta_origem = saldo_conta_origem - valor_tranferencia; 
            int valor_acrescentar_conta_destino = saldo_conta_destino + valor_tranferencia; 

            modificaSaldoConta(this.id_conta_origem, Integer.toString(valor_diminuir_conta_origem));
            modificaSaldoConta(this.id_conta_destino, Integer.toString(valor_acrescentar_conta_destino));

            return true;

        }
        return false;
    }
    private void modificaSaldoConta(String id_conta, String valor_final) throws IOException{

        int[] colunas_modificar = {3};
        String[] dados_modificacao = {valor_final};
        int id_modificar = Integer.parseInt(id_conta);
        int id_conta_modificado = new ModificarRegistrosBaseDados(this.nome_arquivo, colunas_modificar, dados_modificacao, id_modificar).modificar();

    }
    private boolean validarSaldoContaOrigem()throws IOException{

        String[] dadosContaOrigem = new ContaCrud(id_conta_origem, "", "", "").dadosConta();
        int saldoContaOrigem = Integer.parseInt(dadosContaOrigem[3]);

        if(saldoContaOrigem >= valor_tranferencia ){
            String[] dadosContaDestino = new ContaCrud(id_conta_destino, "", "", "").dadosConta();
            this.dados_conta_destino = dadosContaDestino;
            this.dados_conta_origem = dadosContaOrigem;
            return true; 
        }
        return false;
    }
}
