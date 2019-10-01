package com.virjanand.springbookskata.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhenBookControllerIsUsedIT {

    @Autowired
    private BookController bookController;

    @Test
    public void showListOfBookCommands() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("booklist", BookCommandListCreator.createBookCommandList()))
                .andExpect(view().name("books"));
    }
}
