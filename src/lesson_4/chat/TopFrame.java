package lesson_4.chat;

import javax.swing.*;
import java.awt.*;

public class TopFrame {
    private JTextArea textArea;
    private JPanel top;

    public TopFrame() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        top = new JPanel();
        top.setLayout(new BorderLayout());
        top.add(textArea, BorderLayout.CENTER);
        textArea.setText("Hello!\n Write your first message...");
    }

    public JPanel getTop() {
        return top;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
