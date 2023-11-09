package listener;

import gui.GlobalPanel;
import logik.ChatHistori;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClearListiner implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ChatHistori.clearChat();
        GlobalPanel.getChat().getChatArea().setText("Тут будет переписка с ботом");
    }
}
