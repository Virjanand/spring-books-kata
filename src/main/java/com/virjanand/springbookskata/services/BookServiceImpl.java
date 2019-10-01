package com.virjanand.springbookskata.services;

import com.virjanand.springbookskata.commands.BookCommand;
import com.virjanand.springbookskata.converters.BookToBookCommand;
import com.virjanand.springbookskata.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class BookServiceImpl implements BookService{

    private BookToBookCommand bookToBookCommand;

    public BookServiceImpl(BookToBookCommand bookToBookCommand) {
        this.bookToBookCommand = bookToBookCommand;
    }

    public List<BookCommand> getBookCommands() {
        return createBookCommandList();
    }

    private List<BookCommand> createBookCommandList() {
        return asList(
                createBookCommand("Wheel of Time", "Robert Jordan"),
                createBookCommand("Assassin's Apprentice", "Robin Hobb")
        );
    }

    private BookCommand createBookCommand(String title, String author) {
        Book book = new Book(title, author);
        return bookToBookCommand.convert(book);
    }
}
