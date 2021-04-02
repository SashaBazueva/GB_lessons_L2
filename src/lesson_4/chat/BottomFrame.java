package lesson_4.chat;

import javax.swing.*;
import java.awt.*;

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
        submit.addActionListener(new ButtonActionListener(text));
    }

    public JPanel getBottom() {
        return bottom;
    }

}
