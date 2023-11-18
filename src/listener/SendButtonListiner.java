package listener;

import gui.GlobalPanel;
import logik.ChatHistori;
import logik.Post;
import logik.PostApache;
import music.Playerclip;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendButtonListiner implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!GlobalPanel.getChat().getChatArea().getText().equals("")){
            Playerclip.playRoboMusic();
            String vopros = GlobalPanel.getOutArea().getTextArea().getText();
            ChatHistori.saveChat(vopros,"Вы");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            GlobalPanel.getOutArea().getTextArea().setText("");
                            GlobalPanel.getFooter().getSend().setEnabled(false);
                        }
                    });
                    String otvet = PostApache.liteTest(vopros);
                    ChatHistori.saveChat(otvet,"Чат бот ГПТ");
                    String temp = GlobalPanel.getChat().getChatArea().getText();
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            GlobalPanel.getChat().getChatArea().setText(temp + System.lineSeparator() + "Вы - " + vopros + System.lineSeparator() + "Чат бот ГПТ - " + otvet);
                            GlobalPanel.getChat().getChatArea().requestFocus();
                            GlobalPanel.getFooter().getSend().setEnabled(true);
                        }
                    });
                    Playerclip.stopRoboMusic();
                }
            }).start();




        }
    }
}
