import java.io.IOException;
import classes_acoes_arquivos.*;

public class TransferirDinheiro {

    private int id_conta_origem;
    private int id_conta_destino;
    private TodosDados dados_conta_origem;
    private String[] dados_conta_destino;

    private String  nome_arquivo = "C:\\Users\\DEV-04\\Pictures\\mini_bank\\arquivos_txt\\contas.txt";

    private float valor_tranferencia;

    TransferirDinheiro(TodosDados dados_conta_logada ,int id_conta_destino, float valor_tranferencia){

        this.id_conta_destino = id_conta_destino;
        this.id_conta_origem = dados_conta_logada.id_conta;
        this.dados_conta_origem = dados_conta_logada;
        this.valor_tranferencia = valor_tranferencia;
    }
    public boolean transferir()throws IOException{

        if(validarSaldoContaOrigem()){

            float saldo_conta_origem = dados_conta_origem.saldo;
            float saldo_conta_destino = Float.parseFloat(dados_conta_destino[3]);

            float valor_diminuir_conta_origem = saldo_conta_origem - valor_tranferencia; 
            float valor_acrescentar_conta_destino = saldo_conta_destino + valor_tranferencia; 

            modificaSaldoConta(this.id_conta_origem, Float.toString(valor_diminuir_conta_origem));
            modificaSaldoConta(this.id_conta_destino, Float.toString(valor_acrescentar_conta_destino));

            return true;

        }
        return false;
    }
    private boolean validarSaldoContaOrigem()throws IOException{
        
        float saldoContaOrigem = this.dados_conta_origem.saldo;
        
        if(saldoContaOrigem >= valor_tranferencia ){

            try{
                int coluna_saldo = 0;
                String busca = Integer.toString(this.id_conta_destino);
                String[][] dadosContaDestino = new BuscaRegistrosBaseDados(coluna_saldo,busca, this.nome_arquivo).getResultados();
                this.dados_conta_destino = dadosContaDestino[0];
                return true; 

            }catch(Error | Exception  e){
                return false;
            }    
        }
        return false;
    }
    private void modificaSaldoConta(int id_conta, String valor_final) throws IOException{

        int[] colunas_modificar = {3};
        String[] dados_modificacao = {valor_final};
        int id_modificar = id_conta;
        int id_conta_modificado = new ModificarRegistrosBaseDados(id_modificar, colunas_modificar, dados_modificacao,this.nome_arquivo).modificar();

    }
}
