package input_output;

import java.util.Scanner;

public class In {

    public static String input(String msg){

        Scanner input_usuario = new Scanner(System.in);
        System.out.print(msg);
        String msg_digitada = input_usuario.nextLine();

        return msg_digitada;
    }
}
