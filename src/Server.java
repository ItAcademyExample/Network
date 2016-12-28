import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome to Server side");
    try (ServerSocket servers = new ServerSocket(Constant.PORT);
         Socket fromclient = servers.accept();
         BufferedReader clientInput = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
         PrintWriter clientOut = new PrintWriter(fromclient.getOutputStream(), true)) {
      while (true) {
        System.out.println("Waiting client messages...");
        String inputClient = clientInput.readLine();
        if ((inputClient == null)){
          break;
        } else {
          System.out.println("From Client: " +  inputClient);
          if (inputClient.equalsIgnoreCase("2+2")) {
            clientOut.println("Echo: " + 4);
            continue;
          }
          clientOut.println("Echo: " + inputClient);
        }
      }
    }
    System.out.println("End program");
  }
}
