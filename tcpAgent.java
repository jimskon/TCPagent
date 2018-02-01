//: tcpAgent.java
//  SYNOPSIS:      tcpAgent 
//  DESCRIPTION:   The program creates a tcp socket in the inet 
//                 domain, binds it to port 8555, listen and accept 
//                 a connection from tcpClient0, and receives any message
//                 arrived to the socket and prints it out
/////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.net.*;

public class tcpAgent {  
  // Choose a port outside of the range 1-1024:
  public static final int PORT = 8555;

  public static void main(String[] args) 
      throws IOException {
    
    // Create a Server Socket and binds it to the port 8555
    ServerSocket s = new ServerSocket(PORT);
    // System.out.println("Started: " + s);
    
   try {
      while (true)
	  {
      // Blocks until a connection occurs:
      Socket socket = s.accept();
      try {
	 
        // System.out.println("Connection accepted: "+ socket);
	// Read from InputStream from the Socket
        BufferedReader in = 
          new BufferedReader(
            new InputStreamReader(
              socket.getInputStream()));
	  
          // get the Recived string 
          String str = in.readLine();
          
          // print the recieved message to the STND output
          System.out.println("message recieved: " + str);

	  // Get a message from the user and send it back
	  InputStreamReader converter = new InputStreamReader(System.in);
	  BufferedReader console = new BufferedReader(converter);
	  System.out.print("Enter Reply: ");

	  String reply = console.readLine();
	  PrintWriter out = new PrintWriter(
	       new BufferedWriter(
	          new OutputStreamWriter(
		      socket.getOutputStream())),true);

	  // send reply to the tcpServer
	  out.println(reply);
	  
      // Always close the two sockets...
      } finally {
	System.out.println("closing...");
        socket.close(); 
      }
    }  //while true
   } finally {
     s.close();
   }
    } 
  
} ///:~


















