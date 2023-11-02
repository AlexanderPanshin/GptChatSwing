package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class OutArea extends JPanel {
    private JTextArea textArea;
    public OutArea() {
        textArea = new JTextArea(1,40);
        textArea.setToolTipText("Введите запрос здесь");
        textArea.getAccessibleContext().setAccessibleName("Введите запрос здесь");
        textArea.setBorder(new LineBorder(Color.BLACK));
        add(textArea);
    }
}
