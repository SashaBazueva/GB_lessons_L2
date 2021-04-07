package lesson_8.Client;

import lesson_8.Client.gui.ChatWindow;

public class ChatApplication {
    private final ChatWindow window;
    private ChatConnection connection;

    public ChatApplication() {
        window = new ChatWindow();
        connection = new ChatConnection("127.0.0.1", 8080);
    }
    public ChatApplication(String host, int port){
        window = new ChatWindow();
        connection = new ChatConnection(host, port);
    }
}
