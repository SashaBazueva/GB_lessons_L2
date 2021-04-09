package lesson_8.Client;

import lesson_8.Server.MyChatException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatCommunication {
    private final DataInputStream input;
    private final DataOutputStream output;
    public ChatCommunication(String host, int port) {
        try {
            Socket client = new Socket(host, port);
            input = new DataInputStream(client.getInputStream());
            output = new DataOutputStream(client.getOutputStream());

        } catch (IOException e) {
            throw new MyChatException("Error was happened during connection establishing", e);
        }
    }

    public void transmit(String message){
        try {
            output.writeUTF(message);
        } catch (IOException e) {
            throw new MyChatException("Error was happened during transmitting message", e);
        }
    }
    public String receive() {
        try {
            return input.readUTF();
        } catch (IOException e) {
            throw new MyChatException("Error was happened during receiving message", e);
        }
    }
}
