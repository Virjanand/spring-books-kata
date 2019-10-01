package com.virjanand.springbookskata.converters;

import com.virjanand.springbookskata.commands.BookCommand;
import com.virjanand.springbookskata.domain.Book;
import org.springframework.stereotype.Component;

@Component
public class BookToBookCommand {
    public BookCommand convert(Book book) {
        BookCommand bookCommand = new BookCommand();
        bookCommand.setTitle(book.getTitle());
        bookCommand.setAuthor(book.getAuthor());
        return bookCommand;
    }
}
