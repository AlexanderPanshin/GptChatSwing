package listener;

import gui.GlobalPanel;
import logik.ChatHistori;
import logik.Post;
import logik.PostApache;
import music.Playerclip;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendButtonListiner implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!GlobalPanel.getChat().getChatArea().getText().equals("")){
            Playerclip.playRoboMusic();
            String vopros = GlobalPanel.getOutArea().getTextArea().getText();
            ChatHistori.saveChat(vopros,"Вы");
            String otvet = PostApache.liteTest(vopros);
            /*String otvet = null;
            try {
                otvet = Post.etQusteion111(vopros);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }*/
            ChatHistori.saveChat(otvet,"Чат бот ГПТ");
            String temp = GlobalPanel.getChat().getChatArea().getText();
            GlobalPanel.getChat().getChatArea().setText(temp + System.lineSeparator() + "Вы - " + vopros + System.lineSeparator() + "Чат бот ГПТ - " + otvet);
            GlobalPanel.getOutArea().getTextArea().setText("");
            Playerclip.stopRoboMusic();
        }
    }
}
