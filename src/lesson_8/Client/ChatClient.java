package lesson_8.Client;

import lesson_8.Client.GUI.API.Receiver;
import lesson_8.Client.GUI.ChatWindow;

public class ChatClient {
    private final ChatWindow window;
    private final ChatCommunication communication;

    public ChatClient(String host, int port) {
        communication = new ChatCommunication(host, port);
        window = new ChatWindow(data -> communication.transmit(data));

        new Thread(() -> {
            Receiver receiver = window.getReceiver();
            while (true) {
                String message = communication.receive();
                if (!message.isBlank()) {
                    receiver.receive(message);
                }
            }
        })
                .start();
    }
}
