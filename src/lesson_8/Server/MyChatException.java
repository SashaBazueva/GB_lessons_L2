package lesson_8.Server;

public class MyChatException extends RuntimeException {
    public MyChatException(String message) {
        super(message);
    }

    public MyChatException(String message, Throwable cause) {
        super(message, cause);
    }
}
