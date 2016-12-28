import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args) throws IOException {

    System.out.println("Welcome to Client side");
    Socket fromServer;

    if (args.length == 0) {
      System.out.println("use: client hostname");
      System.exit(-1);
    }

    System.out.println("Connecting to... " + args[0]);
    fromServer = new Socket(args[0], 4444);
    BufferedReader serverInput = new BufferedReader(new InputStreamReader(fromServer.getInputStream()));
    PrintWriter out = new PrintWriter(fromServer.getOutputStream(), true);
    BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
    String clientMessage, serverMessage;

    while (true) {
      System.out.println("New iteration Client");
      clientMessage = consoleInput.readLine();
      out.println(clientMessage);
      serverMessage = serverInput.readLine();
      System.out.println(serverMessage);
      if (clientMessage.equalsIgnoreCase("close")) {
        break;
      }
      if (clientMessage.equalsIgnoreCase("exit")) {
        break;
      }
    }
    out.close();
    serverInput.close();
    consoleInput.close();
    fromServer.close();
  }
}