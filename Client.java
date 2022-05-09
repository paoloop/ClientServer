import java.net.*;
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
  
	public static void main(String[] args) throws IOException {
		// inzializzo mettendo in null
    Socket socket=null;
		BufferedReader in=null, stdIn=null;
		PrintWriter out=null;

		try {
			socket = new Socket("127.0.0.1", 30000);
      
			System.out.println("client in avvio");
			
			// creazione stream di input 
			InputStreamReader red = new InputStreamReader( socket.getInputStream());
      
			in = new BufferedReader(red);
			
			//output 
			OutputStreamWriter wri = new OutputStreamWriter( socket.getOutputStream());
			BufferedWriter bw = new BufferedWriter(wri);
			out = new PrintWriter(bw, true);

      
			//input da tastiera
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			String userInput;
			
			
			while (true){
				tastieraInp = stdIn.readLine();
        // invio al server
				out.println(tastieraInp);
        // stampo la risposta 
				System.out.println("Invio messaggio " + in.readLine());
			}
		} catch (UnknownHostException e) {
			System.out.println("errore con host locale");
			System.exit(1);
		} catch (IOException e) {// errore generale
			System.out.println("Impossibile collegarsi");
			System.exit(1);
		}
    // chiudo tutte le connesioni 
		stdIn.close();
		socket.close();
	}
} 