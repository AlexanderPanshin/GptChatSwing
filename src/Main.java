import gui.GlobalPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GlobalPanel m1 = new GlobalPanel();
            }
        });
    }
}