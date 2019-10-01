package com.virjanand.springbookskata.controllers;

import com.virjanand.springbookskata.services.BookService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class WhenBookControllerIsUsed {

    @Mock
    BookService bookService;

    private BookController bookController;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        bookController = new BookController(bookService);

        when(bookService.getBookCommands()).thenReturn(Lists.emptyList());
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void mapToBooks() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("books"));
    }

    @Test
    public void getBookCommandsFromBookService() throws Exception {

        mockMvc.perform(get("/"));
        verify(bookService, times(1)).getBookCommands();
    }


}
