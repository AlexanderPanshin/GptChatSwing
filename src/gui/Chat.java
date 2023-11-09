package gui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Chat extends JPanel {
    JTextArea chatArea;
    public Chat() {
        chatArea = new JTextArea(5,40);
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setText("Тут будет переписка с ботом");
        chatArea.setBorder(new LineBorder(Color.BLACK));
        chatArea.getAccessibleContext().setAccessibleName("Область чата не редактируемая");
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBorder(new TitledBorder("Чат"));
        add(scrollPane);
    }

    public JTextArea getChatArea() {
        return chatArea;
    }

    public void setChatArea(JTextArea chatArea) {
        this.chatArea = chatArea;
    }
}
