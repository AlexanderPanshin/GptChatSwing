package gui;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {
    private JButton send;
    private JButton clear;
    private JButton exit;
    public Footer() {
        setLayout(new FlowLayout());
        send = new JButton("Отправить");
        clear = new JButton("Отчистить");
        exit = new JButton("  Выйти  ");

        add(send);
        add(clear);
        add(exit);
    }
}
