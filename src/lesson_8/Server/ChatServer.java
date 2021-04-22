package lesson_8.Server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
    private AuthenticationService authenticationService = new AuthenticationService();
    private Set<ClientHandler> logged = new HashSet<>();
    private final File file;

    public ChatServer() {
        file = new File("src/lesson_8/Server/ChatMessages");

        try {
            ServerSocket socket = new ServerSocket(8080);
            System.out.println("Server is ready for connection...");
            while (true) {
                Socket client = socket.accept();
                System.out.println("Connected successfully");
                new ClientHandler(client, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public void sendMessageOnServer(String message) {
        System.out.println(message);
    }

    public void broadcast(String message) {
        for (ClientHandler client : logged) {
            client.sendMessage(message);
        }

        try (FileWriter fw = new FileWriter(file, true)) {
            fw.append(message);
            fw.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        logged.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        logged.remove(clientHandler);
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public synchronized boolean isLogged(String name) {
        return logged.stream().filter(clientHandler -> clientHandler.getName().equals(name)).findFirst().isPresent();
    }
}
