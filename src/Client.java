import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome to Client side");
    System.out.println("Connecting to... " + Constant.HOST);
     try (Socket fromServer = new Socket(Constant.HOST, Constant.PORT);
         BufferedReader serverInput = new BufferedReader(new InputStreamReader(fromServer.getInputStream()));
         PrintWriter serverOuput = new PrintWriter(fromServer.getOutputStream(), true);
         BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {
      while (true) {
        System.out.println("New iteration Client");
        String clientMessage = consoleInput.readLine();
        if (clientMessage.equalsIgnoreCase("close") || clientMessage.equalsIgnoreCase("exit")) {
          break;
        }
        serverOuput.println(clientMessage);
        String serverMessage = serverInput.readLine();
        System.out.println(serverMessage);
      }
    }
  }
}