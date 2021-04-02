package lesson_4.chat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {
    private JTextField text;
    StringBuilder sb;
    public ButtonActionListener(JTextField text){
        this.text = text;
        sb = new StringBuilder();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        sb.append(text.getText());
        System.out.println(sb.toString());
        sb.setLength(0);
        text.setText("");
    }

}
