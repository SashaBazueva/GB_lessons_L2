package lesson_8.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

public class ClientHandler {
    private final Socket client;
    private final DataInputStream input;
    private final DataOutputStream output;
    private ChatServer cs;
    private String name;

    public ClientHandler(Socket clientSocket, ChatServer chatServer) {
        try {
            this.client = clientSocket;
            input = new DataInputStream(client.getInputStream());
            output = new DataOutputStream(client.getOutputStream());
            cs = chatServer;

        } catch (Exception e) {
            throw new MyChatException("Error in connection with client...", e);
        }
        new Thread(() -> {
            doAuthentication();
            listen();
        })
                .start();
    }

    public String getName() {
        return name;
    }

    public void listen() {
        receiveMessage();
    }

    public void sendMessage(String message) {
        try {
            output.writeUTF(message);
        } catch (IOException e) {
            throw new MyChatException("Error in sending message", e);
        }
    }

    public void receiveMessage() {
        while (true) {
            try {
                cs.broadcast(String.format("%s: %s", name, input.readUTF()));
            } catch (IOException e) {
                throw new MyChatException("Error in receiving message", e);
            }
        }
    }

    private void doAuthentication() {
        sendMessage("For authentication enter: -auth your_login your_password");
        while (true) {
            try {
                String message = input.readUTF();

                if (message.startsWith("-auth")) {
                    String[] enteredCredentials = message.split("\\s");
                    String login = enteredCredentials[1];
                    String password = enteredCredentials[2];
                    Optional<AuthenticationService.Entry> mayBeCredentials = cs.getAuthenticationService().findEntryByEnteredCredentials(login, password);

                    if (mayBeCredentials.isPresent()) {
                        AuthenticationService.Entry credentials = mayBeCredentials.get();
                        if (!cs.isLogged(credentials.getName())) {
                            this.name = credentials.getName();
                            cs.broadcast(String.format("User [%s] is entered the chat", name));
                            cs.sendMessageOnServer(String.format("User [%s] is entered the chat", name));
                            cs.subscribe(this);
                            break;
                        } else {
                            sendMessage(String.format("User %s is already logged in", credentials.getName()));
                        }
                    } else {
                        sendMessage("Error in input login or password...\nCheck the correctness of entered credentials");
                    }

                } else {
                    sendMessage("You entered invalid command...\nValid command is: -auth your_login your_password");
                }
            } catch (IOException e) {
                throw new MyChatException("Error happened during authentication");
            }
        }
    }
}
