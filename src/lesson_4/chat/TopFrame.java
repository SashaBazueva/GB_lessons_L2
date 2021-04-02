package lesson_4.chat;

import javax.swing.*;
import java.awt.*;

public class TopFrame {
    private JTextField textField;
    private JPanel top;

    public TopFrame(){
        textField = new JTextField();
        textField.setEditable(false);
        top = new JPanel();
        top.setLayout(new BorderLayout());
        top.add(textField, BorderLayout.CENTER);

    }

    public JPanel getTop() {
        return top;
    }
}
