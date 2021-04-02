package lesson_4.chat;

import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame {
    public ChatWindow(){
        setTitle("Chat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500, 500, 320, 500);

        setLayout(new BorderLayout());

        TopFrame top = new TopFrame();
        add(top.getTop(), BorderLayout.CENTER);

        BottomFrame bottom = new BottomFrame();
        add(bottom.getBottom(), BorderLayout.SOUTH);
        setVisible(true);
    }
}
