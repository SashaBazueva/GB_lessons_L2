package lesson_8.Client.GUI;


import lesson_8.Client.GUI.API.Sender;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EnterPressedAction extends KeyAdapter {
    private final JTextField textField;
    private final Sender sender;

    public EnterPressedAction(JTextField textField, Sender sender) {
        this.textField = textField;
        this.sender = sender;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            sender.send(textField.getText());
            textField.setText("");
        }
    }
}
