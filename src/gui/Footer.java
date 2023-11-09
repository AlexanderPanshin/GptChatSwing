package gui;

import listener.ButtonClearListiner;
import listener.ButtonExitListiner;
import listener.PayButtonListiner;
import listener.SendButtonListiner;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {
    private JButton send;
    private JButton clear;
    private JButton exit;
    private JButton pay;
    public Footer() {
        setLayout(new FlowLayout());
        send = new JButton("Отправить");
        clear = new JButton("Отчистить");
        exit = new JButton("  Выйти  ");
        pay = new JButton("Оплатить");
        send.addActionListener(new SendButtonListiner());
        clear.addActionListener(new ButtonClearListiner());
        exit.addActionListener(new ButtonExitListiner());
        pay.addActionListener(new PayButtonListiner());

        add(send);
        add(clear);
        add(exit);
        add(pay);
    }

    public JButton getSend() {
        return send;
    }

    public void setSend(JButton send) {
        this.send = send;
    }

    public JButton getClear() {
        return clear;
    }

    public void setClear(JButton clear) {
        this.clear = clear;
    }

    public JButton getExit() {
        return exit;
    }

    public void setExit(JButton exit) {
        this.exit = exit;
    }
}
