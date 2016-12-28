import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args) throws IOException {

    System.out.println("Welcome to Client side");
    System.out.println("Connecting to... " + Constant.HOST);
    try (Socket fromServer = new Socket(Constant.HOST, Constant.PORT);
         BufferedReader serverInput = new BufferedReader(new InputStreamReader(fromServer.getInputStream()));
         PrintWriter serverOuput = new PrintWriter(fromServer.getOutputStream(), true);
         BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {
      String clientMessage, serverMessage;
      while (true) {
        System.out.println("New iteration Client");
        clientMessage = consoleInput.readLine();
        serverOuput.println(clientMessage);
        serverMessage = serverInput.readLine();
        System.out.println(serverMessage);
        if (clientMessage.equalsIgnoreCase("close") || clientMessage.equalsIgnoreCase("exit")) {
          break;
        }
      }
    }
  }
}