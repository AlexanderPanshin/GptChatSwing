package gui;

import javax.swing.*;
import java.awt.*;

public class GlobalPanel extends JFrame {
    private Header header;
    private Chat chat;
    private OutArea outArea;
    private Footer footer;
    public GlobalPanel() throws HeadlessException {
        setTitle("GptChatSwing");
        setSize(500,400);
        setLayout(new GridLayout(4,1));
        setVisible(true);
        header = new Header();
        chat = new Chat();
        outArea = new OutArea();
        footer = new Footer();
        add(header);
        add(chat);
        add(outArea);
        add(footer);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
