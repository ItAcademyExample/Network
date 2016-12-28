import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.net.*;

public class Server {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome to Server side");
    ServerSocket servers = null;
    Socket fromclient = null;

    try {
      servers = new ServerSocket(4444);
    } catch (IOException e) {
      System.out.println("Couldn't listen to port 4444");
      System.exit(-1);
    }

    try {
      System.out.print("Waiting for a client...");
      fromclient = servers.accept();
      System.out.println("Client connected");
    } catch (IOException e) {
      System.out.println("Can't accept");
      System.exit(-1);
    }

    BufferedReader in = new BufferedReader(new
        InputStreamReader(fromclient.getInputStream()));
    PrintWriter clientOut = new PrintWriter(fromclient.getOutputStream(), true);
    String input;

    System.out.println("Wait for messages");
    while (true) {
      System.out.println("New Iteration");
      input = in.readLine();
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
    System.out.println("End program");
    clientOut.close();
    in.close();
    fromclient.close();
    servers.close();
  }
}
