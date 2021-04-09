package lesson_8.Client;

public class ChatApplication {

    public static void run() {
        run("127.0.0.1", 8080);
    }
    public static void run(String host, int port){
        new ChatClient(host, port);
    }
}
