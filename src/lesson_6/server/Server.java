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

            DataOutputStream output = new DataOutputStream(client.getOutputStream());

            String send;
            Scanner scan = new Scanner(System.in);

            Thread read = new Thread(() -> {
                String receive;
                DataInputStream input = null;
                try {
                    input = new DataInputStream(client.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while (true) {
                    try {
                        receive = "Client: " + input.readUTF();
                        System.out.println(receive);
                    } catch (IOException e) {
                        System.out.println("Client is offline...Connection was stopped.\nTwice press \"Enter\"");
                        break;
//                        e.printStackTrace();
                    }
                }
            });
            read.start();

            while (true) {
                try {
                    send = scan.nextLine();
                    output.writeUTF(send);
                } catch (EOFException | SocketException e) {
                    System.out.println("Program stopped");
                    break;
//                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
