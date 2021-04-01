package lesson_6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {
    public Server() {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is ready for connection...");
            Socket client = server.accept();
            System.out.println("Server and client are connected successfully");

            DataInputStream input = new DataInputStream(client.getInputStream());
            DataOutputStream output = new DataOutputStream(client.getOutputStream());

            String receive, send;
            Scanner scan = new Scanner(System.in);
            while (true) {
                try{
                    receive = input.readUTF();
                    System.out.println("Client: " + receive);
                    System.out.print("You: ");
                    send = scan.nextLine();
                    output.writeUTF(send);
                }catch (EOFException | SocketException e){
                    System.out.println("Client is offline...Connection was stopped.");
                    break;
//                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
