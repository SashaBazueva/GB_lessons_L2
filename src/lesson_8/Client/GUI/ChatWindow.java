package lesson_8.Client.GUI;

import lesson_8.Client.GUI.API.Receiver;
import lesson_8.Client.GUI.API.Sender;

import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame {
    private final JTextArea chatArea;
    public ChatWindow(Sender sender){
        setTitle("Chat v1.0");
        setBounds(0, 0, 400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        top.add(chatArea, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());

        JTextField input = new JTextField();
        input.addKeyListener(new EnterPressedAction(input, sender));
        bottom.add(input, BorderLayout.CENTER);
        JButton submit = new JButton("Submit");
        submit.addActionListener(new ButtonListener(input, sender));
        bottom.add(submit, BorderLayout.EAST);

        add(top, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }
    public Receiver getReceiver(){
        return message -> {
            if(!message.isBlank()){
                chatArea.append(message);
                chatArea.append("\n");
            }
        };
    }
}
