package lesson_8.Client.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {
    public ChatWindow(){
        setTitle("Chat v1.0");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JTextArea text = new JTextArea();
        text.setEditable(false);
        top.add(text, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());
        JTextField input = new JTextField();
        bottom.add(input, BorderLayout.CENTER);
        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TO-DO: написать действие(отправку) после нажатия кнопки "Submit"
            }
        });
        bottom.add(submit, BorderLayout.EAST);

        setVisible(true);
    }
}
