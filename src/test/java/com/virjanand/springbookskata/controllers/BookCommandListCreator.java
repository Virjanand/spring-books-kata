package com.virjanand.springbookskata.controllers;

import com.virjanand.springbookskata.commands.BookCommand;

import java.util.Arrays;
import java.util.List;

public class BookCommandListCreator {

    private BookCommandListCreator() {
    }

    public static List<BookCommand> createBookCommandList() {
        BookCommand bookCommand = createBookCommand("Wheel of Time", "Robert Jordan");
        BookCommand bookCommand2 = createBookCommand("Assassin's Apprentice", "Robin Hobb");
        return Arrays.asList(bookCommand, bookCommand2);
    }

    private static BookCommand createBookCommand(String title, String author) {
        BookCommand bookCommand = new BookCommand();
        bookCommand.setTitle(title);
        bookCommand.setAuthor(author);
        return bookCommand;
    }
}