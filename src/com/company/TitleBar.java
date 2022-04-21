package com.company;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleBar extends JPanel{

    String text = "To-Do Приложение";
    TitleBar()
    {
        this.setPreferredSize(new Dimension(400,80));
        this.setBackground(Color.gray);
        JLabel titleText = new JLabel(text);
        titleText.setForeground(Color.white);
        titleText.setPreferredSize(new Dimension(200,60));
        titleText.setFont(new Font("Comic Sans MS",Font.BOLD, 20));
        titleText.setHorizontalAlignment(JLabel.CENTER);
        this.add(titleText);
    }
    public String getText(){
        return text;
    }

}