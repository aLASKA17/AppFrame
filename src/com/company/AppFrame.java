package com.company;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;


public class AppFrame extends JFrame{

    private TitleBar title;
    private Footer footer;
    private List list;
    private JButton newTask;
    private JButton clear;


    AppFrame()
    {
        this.setSize(400,700);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        title = new TitleBar();
        footer = new Footer();
        list = new List();

        this.add(title,BorderLayout.NORTH);
        this.add(footer,BorderLayout.SOUTH);
        this.add(list,BorderLayout.CENTER);

        newTask = footer.getNewTask();
        clear = footer.getClear();

        addListeners();
    }
   public void save(){
       Component[] listItems = this.getComponents();

   }

    public void addListeners()
    {
        if ((new File("notes3.txt")).exists()) {
            int counter = 0;
            try {
                Scanner scan = new Scanner(new File("notes3.txt"));
                while (scan.hasNext()) {
                    String string = scan.nextLine();
                    String[] array = string.split(":");

                    String index = array[0];
                    String name = array[1];
                    Task task = new Task(name);
                    list.add(task);
                    list.updateNumbers();
                    task.getDone().addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            super.mousePressed(e);
                            checkBoxOn(task);
                        }
                    });
                }
                scan.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        newTask.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e) {
                Task task = new Task();
                list.add(task);
                list.updateNumbers();
                save();
                task.getDone().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        checkBoxOn(task);
                    }
                });
            }

        });


        clear.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                list.removeCompletedTasks();
                repaint();

            }
        });
    }
    public void checkBoxOn(Task task) {
        task.changeState();
        list.updateNumbers();
        revalidate();
    }
}