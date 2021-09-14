package classes_acoes_arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DeletarRegistroBaseDados extends SalvarAlteracoes {

    private int id_deletar;
    private int id_deletado;

    public DeletarRegistroBaseDados(String nome_arquivo ,int id_deletar){

        this.nome_arquivo   = nome_arquivo;
        this.id_deletar  = id_deletar;
        this.falha = true;

    }
    public int deletar()throws IOException{

        deletarRegistro();

        if(!this.falha ) {
            salvarAlteracoes();
            return this.id_deletado;
        }
        return 0;

    }
    private void deletarRegistro()throws IOException{

        try{
            BufferedReader BufferLeitura = new BufferedReader(new FileReader(this.nome_arquivo));
            String linha = "";

            while(true){

                linha = BufferLeitura.readLine();
                if(linha == null)
                    break;

                String[] dadoslinha = linha.split("__");

                if(Integer.parseInt(dadoslinha[0]) ==  this.id_deletar){
                    this.id_deletado = Integer.parseInt(dadoslinha[0]);
                    continue;

                }else{
                    this.todos_dados +=  linha + "\n";	
                }
            }
            BufferLeitura.close();
            this.falha = false;

        }catch(Error | Exception e){

            this.falha = true;
        }    
    }
    
}
