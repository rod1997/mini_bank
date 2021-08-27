public class LoginUsuario {

    private String user;
    private String senha;
    private int retornoLogin;

    public LoginUsuario(String user, String senha){

        this.user = user;
        this.senha  = senha;
        this.carregaDadosUsuario()
    }

    public getRetornoLogin(){
        return this.retornoLogin;
    }

    private void carregaDadosUsuario()throws IOException{

        ManipuladorArquivo objArquivo = new ManipuladorArquivo("usuarios.txt");
        dadosUsuario = objArquivo.buscarRegistros(this.user);

        if(dadosUsuario.length < 1){
            this.retornoLogin = 0;

        }else if(this.user === dadosUsuario[1] && this.senha === dadosUsuario[3]){
           this.retornoLogin = dadosUsuario[0];

        }else{
            this.retornoLogin = 0;
        }

    }


}