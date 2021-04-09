package lesson_8.Client.GUI;

import lesson_8.Client.GUI.API.Sender;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final JTextField textField;
    private final Sender sender;

    public ButtonListener(JTextField textField, Sender sender) {
        this.textField = textField;
        this.sender = sender;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sender.send(textField.getText());
        textField.setText("");
    }
}
