    
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivo {

	private int metodo; // 0 ler, 1 cadastrar , 2 modificar, 3 deletar, 4 ler todos registros

	private String nome_arquivo;
	private String todos_usuarios = "";
	
	private String[] parametrosInsercao;
	private int ultimo_id_cadastrado;

	private String id_modificar;
	private int id_modificado;

	private String id_deletar;
	private int id_deletado;

	private String id_procurar;
	private String[] dados_id_procurar;


	public ManipuladorArquivo(String nome_arquivo){

		this.nome_arquivo = nome_arquivo;
	}


	public String[] lerRegistro(String id_procurar)throws IOException{

		try{
			this.metodo = 0;
			this.id_procurar = id_procurar;
			this.leitor();
			return this.dados_id_procurar;

		}catch(IOException e){

			System.out.println(e);
			String[] retornoVazio = {};
			return retornoVazio;
		}	
	}
	public int inserirRegistro(String[] parametros)throws IOException{

		try{
			this.metodo = 1;
			this.parametrosInsercao = parametros;
			this.leitor();
			this.salvarAlteracoes();

			return ultimo_id_cadastrado;

		}catch(IOException e){

			System.out.println(e);
			return 0;
		}	
	}
	public int modificarRegistro(String[] parametros, String id_modificar)throws IOException{

		try{		
			this.metodo = 2;
			this.parametrosInsercao = parametros;
			this.id_modificar = id_modificar;
			this.leitor();
			this.salvarAlteracoes();

			return id_modificado;

		}catch(IOException e){

			System.out.println(e);
			return 0;
		}	
	}
	public int deletarRegistro(String id_deletar)throws IOException{

		try{	
			this.metodo = 3;
			this.id_deletar = id_deletar;
			this.leitor();
			this.salvarAlteracoes();

			return this.id_deletado;

		}catch(IOException e){

			System.out.println(e);
			return 0;
		}	
	}
	public String Ler_todos()throws IOException{

		try{
			this.metodo = 4;
			this.leitor();

			return this.todos_usuarios;

		}catch(IOException e){

			System.out.println(e);
			return "";
		}	
	}
	private void leitor() throws IOException {

		BufferedReader BufferLeitura = new BufferedReader(new FileReader(this.nome_arquivo));

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
			int numeroDeParamentros = this.parametrosInsercao.length;
			String textoDeinsercao = "";

			for(int c =0 ; c < numeroDeParamentros ; c++ ){
				textoDeinsercao += "__" + parametrosInsercao[c];
			}
			this.todos_usuarios += Integer.toString(this.ultimo_id_cadastrado + 1) + textoDeinsercao;
		
		}else if(this.metodo == 2){

			String linha = "";

			while(linha != null){

				linha = BufferLeitura.readLine();

				String[] dadoslinha = linha.split("__");

				int id = Integer.parseInt(dadoslinha[0]);

				int id_modificar = Integer.parseInt(this.id_modificar);

				if(id == id_modificar){


					int numeroDeParamentros = this.parametrosInsercao.length;
					String textoDeinsercao = "";
		
					for(int c =0 ; c < numeroDeParamentros ; c++ ){
						textoDeinsercao += "__" + parametrosInsercao[c];
					}

					this.todos_usuarios +=  dadoslinha[0] +  textoDeinsercao + "\n";
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

		BufferedWriter BufferEscrita = new BufferedWriter(new FileWriter(this.nome_arquivo,false));
		
		BufferEscrita.write(this.todos_usuarios);
		BufferEscrita.flush();
		BufferEscrita.close();
	
	}
}
