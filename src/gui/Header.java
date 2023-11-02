package gui;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {
    private JTextField login;
    private JPasswordField pass;
    private JButton connect;
    private JLabel info;
    public Header() throws HeadlessException {
        setLayout(new FlowLayout());
        login = new JTextField(10);
        login.setToolTipText("Login");
        login.getAccessibleContext().setAccessibleName("Имя пользователя");
        pass =  new JPasswordField(10);
        pass.setToolTipText("Password");
        pass.getAccessibleContext().setAccessibleName("Пароль");
        connect = new JButton("Подключиться");
        connect.getAccessibleContext().setAccessibleName("Подключиться");
        info = new JLabel("Не подключены");
        info.setFocusable(true);
        info.getAccessibleContext().setAccessibleName("Не подключены");
        add(login);
        add(pass);
        add(connect);
        add(info);
    }
}
