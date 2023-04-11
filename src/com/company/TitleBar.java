package com.company;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleBar extends JPanel{


    TitleBar()
    {
        String text = "To-Do Приложение";
        this.setPreferredSize(new Dimension(400,80));
        this.setBackground(Color.DARK_GRAY);
        JLabel titleText = new JLabel(text);
        titleText.setForeground(Color.white);
        titleText.setPreferredSize(new Dimension(200,60));
        titleText.setFont(new Font("Roboto",Font.BOLD, 20));
        titleText.setHorizontalAlignment(JLabel.CENTER);
        this.add(titleText);
    }
}