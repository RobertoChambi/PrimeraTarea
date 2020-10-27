package Ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Map;
import java.util.Set;

public class URLejercicio{
	public static void main(String[] args) throws IOException{
		//Creamos la url  donde mandaremos como parametro el localhost
		URL dirurl = new URL("http://localhost");
		//Abrimos la coneccion
		URLConnection conn=dirurl.openConnection();
		//guarda llaves
		Map  headers =conn.getHeaderFields();
		//el set
		Set <String> llave = headers.keySet();		
		for( String key:  llave ){
			String val = conn.getHeaderField(key);
			System.out.println(key+" "+val);			
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(dirurl.openStream()));											
		// desde aqui imprimimos linea por linea, lo que nos envie el servidor
		String respuestaLinea;
		while ((respuestaLinea = in.readLine()) != null) {
			System.out.println(respuestaLinea);
		}
	}
}