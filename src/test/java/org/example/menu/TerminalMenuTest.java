package org.example.menu;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class TerminalMenuTest {




    @Test
    void selectMenuOption() throws IOException {

        List<String> options = new ArrayList<>(Arrays.asList("one","two","Three"));
        InputStream reader = new ByteArrayInputStream("one".getBytes());
        TerminalMenu menu = new TerminalMenu(options,reader);

        assertEquals("one",menu.selectMenuOption("msg","1"));

    }

    @Test
    void getMenuOptions() {
        List<String> options = new ArrayList<>(Arrays.asList("one","two","Three"));
        InputStream reader = mock();
        TerminalMenu menu = new TerminalMenu(options,reader);

        assertEquals(options,menu.getMenuOptions());


    }

    @Test
    void setMenuOptions() {
        List<String> options = new ArrayList<>(Arrays.asList("one","two","Three"));
        InputStream reader = mock(System.in);
        TerminalMenu menu = new TerminalMenu(options,reader);

        menu.setMenuOptions(Arrays.asList("two"));
        assertEquals(options,menu.getMenuOptions());


    }
}