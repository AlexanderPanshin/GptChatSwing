package listener;

import gui.GlobalPanel;
import logik.ChatHistori;
import logik.PostApache;
import music.Playerclip;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SendEnter implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
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
                        ChatHistori.saveChat(otvet + System.lineSeparator(),"Чат бот ГПТ");
                        String temp = GlobalPanel.getChat().getChatArea().getText();
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                GlobalPanel.getChat().getChatArea().setText(temp + System.lineSeparator() + "Вы - " + vopros + System.lineSeparator() + "Чат бот ГПТ - " + otvet + System.lineSeparator());
                                GlobalPanel.getChat().getChatArea().requestFocus();
                                GlobalPanel.getFooter().getSend().setEnabled(true);
                                GlobalPanel.getChat().getChatArea().setCaretPosition(GlobalPanel.getChat().getChatArea().getText().lastIndexOf("Вы - "));
                            }
                        });
                        Playerclip.stopRoboMusic();
                    }
                }).start();




            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
