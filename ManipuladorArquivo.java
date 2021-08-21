    
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivo {

	private int metodo; // 0 ler, 1 cadastrar , 2 modificar, 3 deletar, 4 ler todos registros

	private String arquivo = "usuarios.txt";

	private String todos_usuarios = "";

	private String user;
	private String senha;

	private int ultimo_id_cadastrado;

	private String id_modificar;
	private int id_modificado;


	private String id_deletar;
	private int id_deletado;

	private String id_procurar;
	private String[] dados_id_procurar;


	public String[] lerUmRegistro(String id_procurar)throws IOException{

		this.metodo = 0;
		this.id_procurar = id_procurar;
		this.leitor();

		return this.dados_id_procurar;

	}
	public int cadastrar(String user, String senha)throws IOException{

		this.metodo = 1;
		this.user = user;
		this.senha = senha;
		this.leitor();
		this.salvarAlteracoes();

		return ultimo_id_cadastrado;

	}
	public int modificar(String id_modificar)throws IOException{

		this.metodo = 2;
		this.id_modificar = id_modificar;
		this.leitor();
		this.salvarAlteracoes();

		return id_modificado;

	}
	public int deletar(String id_deletar)throws IOException{

		this.metodo = 3;
		this.id_deletar = id_deletar;
		this.leitor();
		this.salvarAlteracoes();

		return this.id_deletado;

	}

	public String Ler_todos()throws IOException{
		this.metodo = 4;
		this.leitor();

		return this.todos_usuarios;

	}
		
	private void leitor() throws IOException {

		BufferedReader BufferLeitura = new BufferedReader(new FileReader(this.arquivo));

		if(this.metodo == 0){

			String linha = "";
			while(true){

				linha = BufferLeitura.readLine();
				if( linha != null){

				 	String[] dadosLinha = linha.split("__");
					 
					int id = Integer.parseInt(dadosLinha[0]);
					int id_procurar = Integer.parseInt(this.id_procurar);
					 
					 if(id == id_procurar){
						this.dados_id_procurar = dadosLinha;
						break;
					}

				}else{
					break;
				}	
			}	
		
		}else if(this.metodo == 1){
			
			String linha = "";
			while(true){

				linha = BufferLeitura.readLine();

				if(linha != null){
					String[] dadoslinha = linha.split("__");

					this.ultimo_id_cadastrado = Integer.parseInt(dadoslinha[0]);
					this.todos_usuarios +=  linha + "\n";	
				
				}else{
					break;
				}
			}	
			
			this.todos_usuarios += Integer.toString(this.ultimo_id_cadastrado + 1) + "__" + this.user + "__" + this.senha ;
		
		}else if(this.metodo == 2){

			String linha = "";

			while(linha != null){

				linha = BufferLeitura.readLine();

				String[] dadoslinha = linha.split("__");

				int id = Integer.parseInt(dadoslinha[0]);

				int id_modificar = Integer.parseInt(this.id_modificar);

				if(id == id_modificar){

					this.todos_usuarios +=  dadoslinha[0] + "__" + this.user + "__" + this.senha +  "\n";
					this.id_modificado = Integer.parseInt(dadoslinha[0]);

				}else{
					this.todos_usuarios +=  linha + "\n";
				}	

			}	

		}else if(this.metodo == 3){

			String linha = ""; 

			while(linha != null){

				linha = BufferLeitura.readLine();

				String[] dadoslinha = linha.split("__");

				int id = Integer.parseInt(dadoslinha[0]);

				int id_deletar = Integer.parseInt(this.id_deletar);

				if(id != id_deletar){

					this.todos_usuarios +=  BufferLeitura.readLine() + "\n";

				}else{

					this.id_deletado =  Integer.parseInt(dadoslinha[0]);
				}
			}	

		}else if(this.metodo == 4){

			while(true){

				String linha = BufferLeitura.readLine();

				if( linha == null){
					break;
				}
				this.todos_usuarios += linha + "\n";
			}	
		}
		
		BufferLeitura.close();
	}


	private void salvarAlteracoes() throws IOException {

		BufferedWriter BufferEscrita = new BufferedWriter(new FileWriter(this.arquivo,false));
		
		BufferEscrita.write(this.todos_usuarios);
		BufferEscrita.flush();
		BufferEscrita.close();
	
	}
}
