package lesson_7.Server;

public class MyChatException extends RuntimeException {
    public MyChatException(String message) {
        super(message);
    }

    public MyChatException(String message, Throwable cause) {
        super(message, cause);
    }
}
