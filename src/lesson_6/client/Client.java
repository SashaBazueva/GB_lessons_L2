package lesson_6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() {
        try {
            final Socket client = new Socket("127.0.0.1", 8080);
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
                        receive = "Server: " + input.readUTF();
                        System.out.println(receive);
                    } catch (IOException e) {
                        System.out.println("Server is not available for connection...Connection was stopped.");
                        break;
//                        e.printStackTrace();
                    }
                }
            });
            read.start();

            while (true) {
                send = scan.nextLine();
                output.writeUTF(send);
            }
        } catch (IOException e) {
            System.out.println("Server is not available for connection...Connection was stopped.");
//            e.printStackTrace();
        }
    }
}
