package lesson_8.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatConnection {
    public ChatConnection(String host, int port) {
        try {
            Socket client = new Socket(host, port);
            DataInputStream input = new DataInputStream(client.getInputStream());
            DataOutputStream output = new DataOutputStream(client.getOutputStream());

            new Thread(() -> {
                Scanner sc = new Scanner(System.in);
                while (true) {
                    try {
                        output.writeUTF(sc.nextLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            })
                    .start();

            while (true) {
                System.out.println(input.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
