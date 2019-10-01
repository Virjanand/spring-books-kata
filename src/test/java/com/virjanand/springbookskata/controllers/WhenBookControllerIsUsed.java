package com.virjanand.springbookskata.controllers;

import com.virjanand.springbookskata.services.BookService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class WhenBookControllerIsUsed {

    @Mock
    BookService bookService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void showListOfBookCommands() throws Exception {

        BookController bookController = new BookController(bookService);
        when(bookService.getBookCommands()).thenReturn(BookCommandListCreator.createBookCommandList());
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("booklist", BookCommandListCreator.createBookCommandList()))
                .andExpect(view().name("books"));
        verify(bookService, times(1)).getBookCommands();
    }
}
