package lesson_4.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BottomFrame {
    private JTextField text;
    private JPanel bottom;
    private JButton submit;

    public BottomFrame() {
        text = new JTextField();
        bottom = new JPanel();
        submit = new JButton("Submit");
        bottom.setLayout(new BorderLayout());
        bottom.add(text, BorderLayout.CENTER);
        bottom.add(submit, BorderLayout.EAST);
        submit.addActionListener(e -> {
            System.out.println(text.getText());
            text.setText("");
        });
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    System.out.println(text.getText());
                    text.setText("");
                }
            }
        });
    }

    public JPanel getBottom() {
        return bottom;
    }
}
