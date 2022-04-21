package com.company;

import org.junit.Before;
import org.junit.Test;


import org.netbeans.jemmy.QueueTool;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JCheckBoxOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;

import java.awt.AWTEvent;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.InvocationEvent;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class TitleBarTest extends TitleBar {

    private JFrameOperator mainFrame;
    private QueueTool mainQueue;

    @Before
    public void getFrame(){
        //Создаем приложение
        String[] fd = new String[0];
        Main.main(fd);
        //Ищем фрейм
        mainFrame = new JFrameOperator();
        //Это приостановление очереди выполнения событий
        //просто для того, чтобы было удобнее смотреть
        mainQueue = new QueueTool();
        mainQueue.waitEmpty(2000);
    }

    @Test
    public void testTitleBar(){

    }
}