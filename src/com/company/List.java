package com.company;
import java.awt.*;
import java.io.*;

import javax.swing.*;

public class List extends JPanel{

    List()
    {
        GridLayout layout = new GridLayout(10,1);
        layout.setVgap(5);
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(400,560));
    }

   public void updateNumbers()
    {
        Component[] listItems = this.getComponents();
        try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
            for(int i = 0;i< listItems.length;i++){
                writer.write(((Task)listItems[i]).getIndex().getText());
                writer.write(":");
                writer.write(((Task)listItems[i]).getTaskName().getText());
                writer.write("\n");
            }}
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        for(int i = 0;i<listItems.length;i++)
        {
            if(listItems[i] instanceof Task)
            {
                ((Task)listItems[i]).changeIndex(i+1);
            }
        }
    }

    public void removeCompletedTasks()
    {
        for(Component c : getComponents())
        {
            if(c instanceof Task)
            {
                if(((Task)c).getState())
                {
                    remove(c);
                    updateNumbers();
                }
            }
        }

    }
}