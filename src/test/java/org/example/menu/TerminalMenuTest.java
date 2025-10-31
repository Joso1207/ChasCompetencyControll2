package org.example.menu;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class TerminalMenuTest {




    @Test
    void selectMenuOption() throws IOException {

        //mock inputstream reader for dependency?
        //probably not as dependency is from base language and can be 'stubbed' by simply defining the state of the stream
        Set<String> options = new HashSet<>(Set.of("one","two","Three"));
        InputStream reader = new ByteArrayInputStream("one".getBytes());
        TerminalMenu menu = new TerminalMenu(options,reader);

        assertEquals("one",menu.selectMenuOption("msg","1"));

    }

    @Test
    void getMenuOptions() {
        Set<String> options = new HashSet<>(Set.of("one","two","Three"));
        InputStream reader = mock(); //Probably not correct use of Mock but since InputStream is an abstract
        TerminalMenu menu = new TerminalMenu(options,reader);

        assertEquals(options,menu.getMenuOptions());


    }

    @Test
    void setMenuOptions() {
        Set<String> options = new HashSet<>(Set.of("one","two","Three"));
        InputStream reader = mock();
        TerminalMenu menu = new TerminalMenu(options,reader);

        menu.setMenuOptions(Set.of("two"));
        assertNotEquals(options,menu.getMenuOptions());


    }
}