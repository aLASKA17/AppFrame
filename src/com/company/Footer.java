package com.company;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Footer extends JPanel{

    JButton addTask;
    JButton clear;

    Border emptyBorder = BorderFactory.createEmptyBorder();

    Footer()
    {
        this.setPreferredSize(new Dimension(400,80));

        addTask = new JButton("Добавить задачу");
        addTask.setBorder(emptyBorder);
        this.setBackground(Color.gray);
        addTask.setFont(new Font("Comic Sans MS",Font.BOLD, 25));
        addTask.setVerticalAlignment(JButton.BOTTOM);
        addTask.setBackground(Color.lightGray);
        this.add(addTask);

        this.add(Box.createHorizontalStrut(0));
        clear = new JButton("Удалить завершенные задачи");
        clear.setFont(new Font("Comic Sans MS",Font.BOLD, 20));
        clear.setBorder(emptyBorder);
        clear.setBackground(Color.lightGray);
        this.add(clear);

    }

    public JButton getNewTask(){
        return addTask;
    }

    public JButton getClear() {
        return clear;
    }
}