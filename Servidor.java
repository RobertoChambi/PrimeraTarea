package Ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
	/*Integrantes
	 * Roberto Carlos Chambi Calizaya 
	 * Fabio Vladimir Cachi Condori
	 * José Joel Suxo Mamani
	 * Daniel Cristian Chambi Choque
	 */

	public static void main(String[] args) {
		ServerSocket servidor = null;
		Socket sc = null;
		final int PUERTO = 5000;
		DataInputStream in;
		DataOutputStream out;
		
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado:   ");
			
			
			while(true) {
				sc = servidor.accept(); //se queda a la espera y recibe socket del cliente
				System.out.println("Cliente conectado...");
				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());
				out.writeUTF("Hola. Ingresa la fecha y CI: ");
				String fecha= in.readUTF();
				String CI= in.readUTF(); 
				String diasem = DiaSem(fecha);
				String resp = Verifica(diasem, CI);
				int fe= Integer.valueOf(fecha.substring(0, fecha.indexOf("/")));
				System.out.println("El cliente quiere salir el Día: "+diasem);
				out.writeUTF("Usted "+resp+" Puede salir la fecha "+fecha);
				sc.close(); //cerrramos el cliente
				System.out.println("Cliente desconectado...");
				
			}
			
		} catch (IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public static String DiaSem (String fecha) {
		String dia="";
		int dd= Integer.valueOf(fecha.substring(0, fecha.indexOf("/")));
		fecha = fecha.substring(fecha.indexOf("/")+1);
		int mes = Integer.valueOf(fecha.substring(0, fecha.indexOf("/")));
		fecha = fecha.substring(fecha.indexOf("/")+1);
		int ano = Integer.valueOf(fecha);
		TimeZone timezone = TimeZone.getDefault();
		Calendar calendar = new GregorianCalendar(timezone);
		calendar.set(ano, mes-1, dd);
		int nD=calendar.get(Calendar.DAY_OF_WEEK);
		switch (nD){
		case 1: dia = "Domingo";
		break;
		case 2: dia = "Lunes";
		break;
		case 3: dia = "Martes";
		break;
		case 4: dia = "Miercoles";
		break;
		case 5: dia = "Jueves";
		break;
		case 6: dia = "Viernes";
		break;
		case 7: dia = "Sabado";
		break;
		}
		return dia;
	}
	
	public static String Verifica (String dia, String CI) {
		String ultimo = CI.substring(CI.length()-1);
		String res ="NO";
		switch (dia) {
		case "Lunes":
			if(ultimo.equals("1") || ultimo.equals("2"))
				res = "SI";
			break;
		case "Martes":
			if(ultimo.equals("3") || ultimo.equals("4"))
				res = "SI";
			break;
		case "Miercoles":
			if(ultimo.equals("5") || ultimo.equals("6"))
				res = "SI";
			break;
		case "Jueves":
			if(ultimo.equals("7") || ultimo.equals("8"))
				res = "SI";
			break;
		case "Viernes":
			if(ultimo.equals("0") || ultimo.equals("9"))
				res = "SI";
			break;
        default:
            break;
		}
		return res;
	}
}
