import java.io.*;
import java.net.*;
import java.sql.Timestamp;
import java.util.Date;

public class Server
{
	public static void main(String[] args) throws IOException {
	    //Avvio il server sulla porta 
    
        ServerSocket serverSocket = new ServerSocket(30000);
        System.out.println("avviato server socket porta 30000");
        Socket clientSocket=null;
        BufferedReader testo=null;
        PrintWriter out=null;
        try {
            //Accetto le richieste 
            clientSocket = serverSocket.accept();
            
            //Stream in input dal client
            InputStreamReader InputStreamClient = new InputStreamReader(clientSocket.getInputStream());
            testo = new BufferedReader(InputStreamClient);
            
            //Stream in output dal client
            OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            out = new PrintWriter(bw, true);
            //ciclo di ricezione dal client e invio di risposta
            while (true) {
              // ricezione del client 
                String str = testo.readLine();

              
                if (str.equals("DATA")){
                
					System.out.println("Comanda della data ricevuto!");
                  
					Date date = new Date();
					System.out.println(new Timestamp(date.getTime()));
				}
                // invio risposta 
                System.out.println("Nuovo messaggio: " + str);
                out.println(str);
            }
        } catch (IOException e) {
            //Errore generale 
            System.out.println("Impossibile accettare la richiesta!");
            System.exit(1);
        }
        //Chiudo tutte connessioni
        clientSocket.close();
        serverSocket.close();
	}
}