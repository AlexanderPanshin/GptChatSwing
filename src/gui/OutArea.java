package gui;

import listener.RMouseMenu;
import listener.TabAdapter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class OutArea extends JPanel {
    private JTextArea textArea;
    public OutArea() {
        textArea = new JTextArea(1,40);
        textArea.setToolTipText("Введите запрос здесь");
        textArea.getAccessibleContext().setAccessibleName("Введите запрос здесь");
        textArea.setBorder(new LineBorder(Color.BLACK));
        textArea.addKeyListener(new TabAdapter());
        textArea.setComponentPopupMenu(new RMouseMenu(textArea));
        textArea.setBorder(new TitledBorder("Ввод"));
        add(textArea);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}
