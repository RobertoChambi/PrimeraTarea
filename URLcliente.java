package Ejercicios;
import java.net.*; //contiene la clase URL
import java.io.*;
import java.util.Map;
import java.util.Set;
public class URLcliente {
	
		public static void main(String[] args) throws IOException {
			
			try {
			      // Instaciamos URL donde mencionamos a apache
			      URL direccion = new URL("http://httpd.apache.org/docs/2.4/");
			      // Divide las diferentes partes de una URL
			      System.out.println("El protocolo utilizado es: " + direccion.getProtocol());
			      System.out.println("El host es: " + direccion.getHost());
			      URLConnection cone=direccion.openConnection();
					//guarda llaves
					Map  headers =cone.getHeaderFields();
					//el set
					Set <String> llave = headers.keySet();		
					for( String key:  llave ){
						String val = cone.getHeaderField(key);
						System.out.println(key+" "+val);			
					}
			    } catch (MalformedURLException e) {
			    System.out.println("Error en la construccion de la URL");
			    }
			
		}
	
}
