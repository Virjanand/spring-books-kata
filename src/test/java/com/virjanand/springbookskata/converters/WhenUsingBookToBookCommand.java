package com.virjanand.springbookskata.converters;

import com.virjanand.springbookskata.domain.Book;
import org.junit.Test;

import static com.virjanand.springbookskata.controllers.BookCommandListCreator.createBookCommand;
import static org.assertj.core.api.Assertions.assertThat;


public class WhenUsingBookToBookCommand {

    @Test
    public void convertBookToBookCommand() {
        BookToBookCommand converter = new BookToBookCommand();

        String title = "title";
        String author = "author";
        Book book = new Book(title, author);

        assertThat(converter.convert(book)).isEqualTo(createBookCommand(title, author));
    }

}