package com.virjanand.springbookskata.services;

import com.virjanand.springbookskata.controllers.BookCommandListCreator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenBookServiceIsUsed {

    @Test
    public void returnListOfBookCommands() {
        BookService bookService = new BookService();
        assertThat(bookService.getBookCommands()).isEqualTo(BookCommandListCreator.createBookCommandList());
    }
}
