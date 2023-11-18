package gui;

import listener.ButtonConnectListiner;
import listener.RMouseMenu;
import listener.TabAdapter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Header extends JPanel {
    private JTextField login;
    private JPasswordField pass;
    private JButton connect;
    private JLabel info;
    private  JCheckBox jCheckBox;


    public Header() throws HeadlessException {
        setLayout(new FlowLayout());
        login = new JTextField(10);
        login.setToolTipText("Login");
        login.getAccessibleContext().setAccessibleName("Имя пользователя");
        login.addKeyListener(new TabAdapter());
        login.setComponentPopupMenu(new RMouseMenu(login));
        login.setBorder(new TitledBorder("Логин"));
        pass =  new JPasswordField(10);
        pass.setToolTipText("Password");
        pass.getAccessibleContext().setAccessibleName("Пароль");
        pass.addKeyListener(new TabAdapter());
        pass.setComponentPopupMenu(new RMouseMenu(pass));
        pass.setBorder(new TitledBorder("Пароль"));
        connect = new JButton("Подключиться");
        connect.getAccessibleContext().setAccessibleName("Подключиться");
        connect.addActionListener(new ButtonConnectListiner());
        info = new JLabel("Не подключены");
        info.setFocusable(true);
        info.getAccessibleContext().setAccessibleName("Не подключены");
        jCheckBox = new JCheckBox("Запомнить");
        add(login);
        add(pass);
        add(jCheckBox);
        add(connect);

        add(info);
    }
    public boolean isSavePassword(){
        return jCheckBox.isSelected();
    }
    public JCheckBox getjCheckBox() {
        return jCheckBox;
    }
    public JTextField getLogin() {
        return login;
    }

    public void setLogin(JTextField login) {
        this.login = login;
    }

    public JPasswordField getPass() {
        return pass;
    }

    public void setPass(JPasswordField pass) {
        this.pass = pass;
    }

    public JButton getConnect() {
        return connect;
    }

    public void setConnect(JButton connect) {
        this.connect = connect;
    }

    public JLabel getInfo() {
        return info;
    }

    public void setInfo(JLabel info) {
        this.info = info;
    }
}
