package lesson_6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() {
        try {
            Socket client = new Socket("127.0.0.1", 8080);

            DataInputStream input = new DataInputStream(client.getInputStream());
            DataOutputStream output = new DataOutputStream(client.getOutputStream());

            String receive, send;
            Scanner scan = new Scanner(System.in);
            while(true){
                System.out.print("You: ");
                send = scan.nextLine();
                output.writeUTF(send);
                receive = "Server: " + input.readUTF();
                System.out.println(receive);
            }
        } catch (IOException e) {
            System.out.println("Server is not available for connection...Connection was stopped.");
//            e.printStackTrace();
        }
    }
}
