package com.company;

import org.junit.Before;
import org.junit.Test;
import org.netbeans.jemmy.QueueTool;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JCheckBoxOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;

import javax.swing.*;

import static org.junit.Assert.*;

public class TaskTest extends TitleBar {

    private JFrameOperator mainFrame;
    private QueueTool mainQueue;
    @Before
    public void getFrame(){

        String[] fd = new String[0];
        Main.main(fd);
        mainFrame = new JFrameOperator();
        mainQueue = new QueueTool();
        mainQueue.waitEmpty(2000);
    }

    @Test
    public void testTitleFrame(){
        String titleFrame = mainFrame.getTitle();
        assertEquals("",titleFrame);
        mainQueue.waitEmpty(1000);
    }

    @Test
    public void testAddButton(){

        JButtonOperator addButton = new JButtonOperator(mainFrame,"Добавить задачу");
        addButton.push();
        JTextFieldOperator textField = new JTextFieldOperator(mainFrame,9);
        assertTrue(textField.getText().equals("Новая задача"));
        mainQueue.waitEmpty(3000);
    }

    @Test
    public void testClearButton(){

        JTextFieldOperator textField = new JTextFieldOperator(mainFrame,1);
        JCheckBoxOperator checkBox = new JCheckBoxOperator(mainFrame,1);
        checkBox.push();
        JButtonOperator clearButton = new JButtonOperator(mainFrame,"Удалить завершенные задачи");
        clearButton.push();
        JTextFieldOperator newTextField = new JTextFieldOperator(mainFrame,1);
        assertTrue(newTextField.getText().equals("Новая задача"));
        mainQueue.waitEmpty(3000);
    }
    @Test
    public void testChangeTask(){
        JTextFieldOperator textField = new JTextFieldOperator(mainFrame,0);
            textField.setText("Погулять с собакой");
        assertTrue(textField.getText().equals("Погулять с собакой"));
        mainQueue.waitEmpty(3000);
    }

}