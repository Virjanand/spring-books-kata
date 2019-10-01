package com.virjanand.springbookskata.services;

import com.virjanand.springbookskata.commands.BookCommand;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class BookService {

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
        BookCommand bookCommand = new BookCommand();
        bookCommand.setTitle(title);
        bookCommand.setAuthor(author);
        return bookCommand;
    }
}
