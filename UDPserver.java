package Ejercicios;
import java.util.Date;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPserver {
	public static void main(String[] args) {
		// Intanciamos el servidor (objeto) con un puerto, en este caso el puerto 5000.
		UDPserver Servidor = new UDPserver(5000);
		Servidor.iniciar();
		//Servidor.finalizar();
	}
	// Constructor 
	public UDPserver(int p) {
		puerto = p;
	}
	// Declaracion de variables a usar
	DatagramSocket socketUDP;
	DatagramPacket paqRecibido;
	DatagramPacket paqEnviar;
	int puerto;
	String acumulado="";

	// Esta funcion nos sirve para iniciar el servisor y recibir peticiones
	public void iniciar() {
		try {
			Date date = new Date();
			// Creamos un socket bajo UDP
			socketUDP = new DatagramSocket(puerto);
			System.out.println("*****SERVIDOR UDP INICIADO***** ");
			System.out.println("Esperando Solicitud del cliente...");
			
			while (true) {

				// recibimos paquete
				byte [] men = new byte[100]; //Creamos vector Byte para recibir mensaje
				paqRecibido = new DatagramPacket(men, men.length);
				socketUDP.receive(paqRecibido);
				System.out.println("¡Paquete Recibido!");
				// Recibiendo vector e bytes y convirtiendo a cadena
				String menRecibido = new String(men);
				System.out.println("Nombre de Ususario: " + menRecibido);
				acumulado = acumulado + "\n" + menRecibido;
				men=acumulado.getBytes();
				System.out.println("lista\n"+acumulado);
				//en la variable paqEnviar definicmos el puerto y direccion de la variable "paqRecibido"
				DatagramPacket paqEnviar = new DatagramPacket(men,acumulado.length(),paqRecibido.getAddress(),paqRecibido.getPort());
				//importante que este el tamaño del mensaje, tamaño de acumulado.
				socketUDP.send(paqEnviar);
				//Enviamos una cadena como mensaje del servidor "
				//String cadEnvio = menRecibido.toUpperCase();
				//byte mensajeEnviar[] = new byte[1024];
				// Conviertimos a un vector de Bytes (getBytes)
				//mensajeEnviar = cadEnvio.getBytes();
				// Creamos datagrama para que se envie el mensaje(paquete)
				//paqEnviar = new DatagramPacket(mensajeEnviar, mensajeEnviar.length, paqRecibido.getAddress(),
					//	paqRecibido.getPort());
				// Enviamos paquete al cliente
				//socketUDP.send(paqEnviar);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Esta funcion nos permite realizar la finalizacion de la conexion entre servidor cliente
	public void finalizar() {
		try {
			socketUDP.close();
			System.out.println("Fin de la conexion...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}