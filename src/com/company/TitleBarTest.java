package com.company;


import org.junit.Before;
import org.junit.Test;
import org.netbeans.jemmy.QueueTool;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JLabelOperator;

import static org.junit.Assert.assertTrue;

public class TitleBarTest extends TitleBar {
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
    public void testTitleBar(){
        JLabelOperator Label = new JLabelOperator(mainFrame,0);
        assertTrue(Label.getText().equals("To-Do Приложение"));
        mainQueue.waitEmpty(3000);
    }
}