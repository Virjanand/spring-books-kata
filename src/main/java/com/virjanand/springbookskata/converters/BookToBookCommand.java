package com.virjanand.springbookskata.converters;

import com.virjanand.springbookskata.commands.BookCommand;
import com.virjanand.springbookskata.domain.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookToBookCommand {
    BookCommand convert(Book book) {
        BookCommand bookCommand = new BookCommand();
        bookCommand.setTitle(book.getTitle());
        bookCommand.setAuthor(book.getAuthor());
        return bookCommand;
    }

    public List<BookCommand> convertBooksToBookCommands(List<Book> books) {
        return books.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
