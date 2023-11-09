package listener;

import gui.GlobalPanel;
import logik.Post;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonConnectListiner implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String pass = new String(GlobalPanel.getHeader().getPass().getPassword());
        if(!GlobalPanel.getHeader().getLogin().getText().equals("")&!pass.equals("")){
            Integer count = Post.getCount(GlobalPanel.getHeader().getLogin().getText());
            GlobalPanel.getHeader().getInfo().setText("У вас " + count + " символов");
            GlobalPanel.getHeader().getInfo().getAccessibleContext().setAccessibleName("У вас " + count + " символов");
        }else {
            GlobalPanel.getHeader().getInfo().setText("Не верный логин или пароль");
            GlobalPanel.getHeader().getInfo().getAccessibleContext().setAccessibleName("Введите правельный пароль");
        }
    }

}
