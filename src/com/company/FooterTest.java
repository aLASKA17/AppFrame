package com.company;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FooterTest extends TitleBar {
    Footer fr = new Footer();

    @Test
  public void buttonAddTaskNameTest(){
        String text = "Добавить задачу";
        Assertions.assertEquals(text,fr.getTextAdd());
    }

    @Test
    public void buttonClearTaskNameTest(){
        String text = "Удалить завершенные задачи";
        Assertions.assertEquals(text,fr.getTextClear());
    }
}