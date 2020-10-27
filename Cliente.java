package Ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {
		/*Integrantes
		 * Roberto Carlos Chambi Calizaya 
		 * Fabio Vladimir Cachi Condori
		 * José Joel Suxo Mamani
		 * Daniel Cristian Chambi Choque
		 */

		final String HOST="127.0.0.1";
		final int PUERTO =  5000;
		DataInputStream in;
		DataOutputStream out;
		try {
			Socket sc = new Socket(HOST, PUERTO);
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			String mensaje = in.readUTF();
			System.out.println(mensaje);
			Scanner lee = new Scanner(System.in);
			String fecha= lee.nextLine();
			String CI = lee.nextLine();
			out.writeUTF(fecha);
			out.writeUTF(CI);
			String respuesta = in.readUTF();
			System.out.println(respuesta);
			sc.close();
			
		} catch (IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,e);
		}
		
	}

}
