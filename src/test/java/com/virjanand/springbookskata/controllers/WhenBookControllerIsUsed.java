package com.virjanand.springbookskata.controllers;

import com.virjanand.springbookskata.commands.BookCommand;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class WhenBookControllerIsUsed {

    @Test
    public void showListOfBookCommands() throws Exception {

        BookController bookController = new BookController();
        List<BookCommand> bookList = createBookCommandList();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("booklist", bookList))
                .andExpect(view().name("books"));
    }

    private List<BookCommand> createBookCommandList() {
        BookCommand bookCommand = new BookCommand();
        bookCommand.setTitle("Wheel of Time");
        bookCommand.setAuthor("Robert Jordan");
        return asList(bookCommand);
    }
}
