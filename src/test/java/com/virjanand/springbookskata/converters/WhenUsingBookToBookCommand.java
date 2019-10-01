package com.virjanand.springbookskata.converters;

import com.virjanand.springbookskata.domain.Book;
import org.junit.Before;
import org.junit.Test;

import static com.virjanand.springbookskata.controllers.BookCommandListCreator.*;
import static org.assertj.core.api.Assertions.assertThat;


public class WhenUsingBookToBookCommand {

    private BookToBookCommand converter;

    @Before
    public void setUp() {
        converter = new BookToBookCommand();
    }

    @Test
    public void convertBookToBookCommand() {

        String title = "title";
        String author = "author";
        Book book = new Book(title, author);

        assertThat(converter.convert(book)).isEqualTo(createBookCommand(title, author));
    }

    @Test
    public void convertBooksToBookCommands() {

        assertThat(converter.convertBooksToBookCommands(createBookList())).isEqualTo(createBookCommandList());
    }
}