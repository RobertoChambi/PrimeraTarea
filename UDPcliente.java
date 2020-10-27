package Ejercicios;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
					/*   TAREA 7 
					Ejercicio 1.
					*/
public class UDPcliente {
	// Main CienteUDP 
	public static void main(String[] args) throws IOException 
	{
		// Instaniamos cliente con localhost y con el mismo puerto usado en el servido.
		UDPcliente ClienteUDP = new UDPcliente("localhost", 5000);
		// Llamamos a la funcion para establecer conexión con el servidor servidor
		ClienteUDP.iniciar();
	}
		public UDPcliente(String direccion, int puerto) throws UnknownHostException 
		{
			SerDestino = InetAddress.getByName(direccion);
			Puerto = puerto;
		}
	// Declaracion de variables UDP
	int Puerto;
	InetAddress SerDestino;
	DatagramSocket SocketUDP;
	DatagramPacket PaqRecibido;
	DatagramPacket PaqEnvio;

	
	
	// Esta funcion nos permitira enlazar una conexion con el servidor
	public void iniciar() throws IOException 
	{
		// Creamos el socket UDP
		SocketUDP = new DatagramSocket(); 
		//Enviamos 		
		System.out.println("***Cliente Conectado**");
		String menEnviar = Leer();
		// Creamos un vector de bytes para guardar el mensaje
		byte MenEnviar[] = new byte[1024];   
		// Convertimos la cadena en byte
		MenEnviar = menEnviar.getBytes(); 
		DatagramPacket PaqEnvio = new DatagramPacket(MenEnviar, MenEnviar.length, SerDestino, Puerto); 
		// Enviamos el Datagrama
		SocketUDP.send(PaqEnvio);
		byte Recibido[] = new byte[1024]; //vector de bytes para recibir la respuesta del servidor
		// Creacion datagrama 
		DatagramPacket PaqRecibido = new DatagramPacket(Recibido,Recibido.length);
		SocketUDP.receive(PaqRecibido); // Recibimos la respuesta desde el servidor
		// Convertimos el datagrama a cadena , para MOSTRAR los datos se utilizaremos "getData()"
		String mensajeRecibido = new String(PaqRecibido.getData());
		//System.out.println(recorte(mensajeRecibido));
		System.out.println(mensajeRecibido);
		System.out.println("¡Solicitud completada!");
		// Creamos otro vector de bytes para un segundo mensaje recibido
		//byte Men2Recibido[] = new byte[1024]; 
		// Creamos el datagrama
		//PaqRecibido = new DatagramPacket(Men2Recibido,Men2Recibido.length); 
		// Recibimos la respuesta desde el servidor
		//SocketUDP.receive(PaqRecibido);
		// Para mostrar lo el mensaje recibido usamos "getData()"
		//String ServidorMen = new String(PaqRecibido.getData());
		//System.out.println("Respuesta del servidor (MAYUSCULAS): " + ServidorMen.toUpperCase());
		finalizar(); //Finalizamos
	}

	private String Leer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Escribe tu nombre Ususario: ");
		String men = sc.nextLine();
		return men;
	}
	public void finalizar() {
		try {
			SocketUDP.close();
			System.out.println("Fin Conexion...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}