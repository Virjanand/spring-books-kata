package com.virjanand.springbookskata.controllers;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class WhenOpeningTheBaseWebsiteIT {

    @Test
    public void testMockMVC() throws Exception {

        BookController bookController = new BookController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        List<String> bookList = asList("Wheel of Time");
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("booklist", bookList))
                .andExpect(view().name("books"));
    }
}
