package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiplePanels implements ActionListener {

    JFrame windows = new JFrame("Multiple Panels");
    JPanel panel_01 = new JPanel();
    JPanel panel_02 = new JPanel();

    JButton click = new JButton();
    JLabel text = new JLabel("Bouton is clicked");

    public MultiplePanels() {
        panel_01.setBackground(Color.CYAN);
        panel_02.setBackground(Color.YELLOW);
        panel_02.add(click);
        text.setForeground(Color.blue);
        panel_01.add(text);
        text.setVisible(false);

        click.addActionListener(this);

        windows.add(panel_01, BorderLayout.CENTER);
        windows.add(panel_02, BorderLayout.PAGE_END);

        windows.setSize(400,400);
        windows.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windows.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        text.setVisible(true);
        panel_01.setBackground(Color.yellow);
        panel_02.setBackground(Color.green);
    }
}
