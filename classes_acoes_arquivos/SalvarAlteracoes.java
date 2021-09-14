package classes_acoes_arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public abstract class SalvarAlteracoes {

    public String nome_arquivo;
    public Boolean falha;
    public String todos_dados = "";

    public void salvarAlteracoes() throws IOException {

        if(!this.falha){
            BufferedWriter BufferEscrita = new BufferedWriter(new FileWriter(this.nome_arquivo,false));
            
            BufferEscrita.write(this.todos_dados);
            BufferEscrita.flush();
            BufferEscrita.close();
        } 
        
        //System.out.println(this.todos_dados);
	
	}
}
