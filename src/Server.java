import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome to Server side");
    System.out.println("Waiting for Client...");
    try (ServerSocket servers = new ServerSocket(4444);
         Socket fromclient = servers.accept();
         BufferedReader in = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
         PrintWriter clientOut = new PrintWriter(fromclient.getOutputStream(), true)) {
      String input;
      System.out.println("Wait for messages");
      while (true) {
        System.out.println("New Iteration");
        input = in.readLine();
        if (input == null) {
          break;
        }
        if (input.equalsIgnoreCase("2+2")) {
          System.out.println("From Client: " + input);
          clientOut.println("Echo: " + 4);
          continue;
        }
        if (input.equalsIgnoreCase("exit")) {
          break;
        }
        System.out.println("From Client: " + input);
        clientOut.println("Echo: " + input);
      }
    }
    System.out.println("End program");
  }
}
