package listener;

import gui.GlobalPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ButtonExitListiner implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        GlobalPanel.getGlobalPanel().dispatchEvent(new WindowEvent(GlobalPanel.getGlobalPanel(),WindowEvent.WINDOW_CLOSING));

    }
}
