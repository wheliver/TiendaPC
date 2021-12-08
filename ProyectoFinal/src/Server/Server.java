package Server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server extends Thread {

	public static void main(String args[]) {

		InputStream Leer = null;
		OutputStream Escribir = null;
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(8906);
		} catch (IOException ioe) {
			System.out.println("Server: Conexion rechazada Error: " + ioe);
			System.exit(1);
		}

		System.out.println("Server: funcionando en puerto 8906...");

		try {
			socket = serverSocket.accept();
			System.out.println("Server: Conexion aceptada de " + socket.getInetAddress());
			Leer = socket.getInputStream();
		    Escribir = new FileOutputStream(System.getProperty("user.dir")+"/Respaldo/Respaldo.dat");
			byte[] bytes = new byte[16 * 1024];

			int count;
			while ((count = Leer.read(bytes)) > 0) {
				Escribir.write(bytes, 0, count);
			}
			System.out.println("Server: Escritura lista");

			Escribir.close();
			Leer.close();
			socket.close();
			serverSocket.close();
		} catch (IOException ioe) {
			System.out.println("Error de servidor: " + ioe);
			System.exit(1);
		}
	}
}