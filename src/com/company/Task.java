package com.company;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Task extends JPanel{

    public JLabel getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index.setText(index);
    }

    JLabel index;

    public JTextField getTaskName() {
        return taskName;
    }


    public void setTaskName(JTextField taskName) {
        this.taskName = taskName;
    }

    JTextField taskName;
    JCheckBox done;

    private boolean checked;

    Task()
    {
        createTask("Новая задача");
    }
    Task(String name) {
        createTask(name);
    }

    public void createTask(String name) {
        this.setPreferredSize(new Dimension(400,20));
        this.setLayout(new BorderLayout());

        checked = false;

        this.setBackground(Color.gray);

        index = new JLabel("");
        index.setPreferredSize(new Dimension(20,20));
        index.setFont(new Font("Comic Sans MS",Font.BOLD,13));
        index.setHorizontalAlignment(JLabel.CENTER);
        index.setForeground(Color.white);
        this.add(index,BorderLayout.WEST);

        taskName = new JTextField(name);
        taskName.setFont(new Font("Comic Sans MS",Font.BOLD,13));
        taskName.setBorder(BorderFactory.createEmptyBorder());
        taskName.setBackground(Color.gray);
        taskName.setForeground(Color.white);
        this.add(taskName,BorderLayout.CENTER);

        done = new JCheckBox();
        done.setPreferredSize(new Dimension(40,20));
        done.setBorder(BorderFactory.createEmptyBorder());
        done.setBackground(Color.gray);
        done.setFocusPainted(true);
        this.add(done,BorderLayout.EAST);
    }

    public void changeIndex(int num)
    {
        this.index.setText(num+"");
        this.revalidate();
    }


    public JCheckBox getDone()
    {
        return done;
    }

    public boolean getState()
    {
        return checked;
    }

    public void changeState()
    {
        this.setBackground(Color.lightGray);
        taskName.setBackground(Color.lightGray);
        taskName.setForeground(Color.black);
        done.setBackground(Color.lightGray);
        index.setForeground(Color.black);
        checked = true;
        revalidate();
    }
}