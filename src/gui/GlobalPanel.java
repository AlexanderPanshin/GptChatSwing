package gui;

import logik.ChatHistori;
import logik.LoginHistori;
import logik.Post;

import javax.swing.*;
import java.awt.*;

public class GlobalPanel extends JFrame {
    private static Header header;
    private static Chat chat;
    private static OutArea outArea;
    private static Footer footer;
    private static GlobalPanel globalPanel;

    public static GlobalPanel getGlobalPanel() {
        return globalPanel;
    }

    public GlobalPanel() throws HeadlessException {
        setTitle("GptChatSwing");
        setSize(600,500);
        setLayout(new GridLayout(4,1));
        setVisible(true);
        header = new Header();
        chat = new Chat();
        outArea = new OutArea();
        footer = new Footer();
        ChatHistori.loadChat();
        add(header);
        add(chat);
        add(outArea);
        add(footer);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new LoginHistori());
        globalPanel = this;
    }

    public static Header getHeader() {
        return header;
    }

    public static void setHeader(Header header) {
        GlobalPanel.header = header;
    }

    public static Chat getChat() {
        return chat;
    }

    public static void setChat(Chat chat) {
        GlobalPanel.chat = chat;
    }

    public static OutArea getOutArea() {
        return outArea;
    }

    public static void setOutArea(OutArea outArea) {
        GlobalPanel.outArea = outArea;
    }

    public static Footer getFooter() {
        return footer;
    }

    public static void setFooter(Footer footer) {
        GlobalPanel.footer = footer;
    }
}
