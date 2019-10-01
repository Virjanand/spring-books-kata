package com.virjanand.springbookskata.controllers;

import com.virjanand.springbookskata.commands.BookCommand;
import com.virjanand.springbookskata.domain.Book;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class BookCommandListCreator {

    private BookCommandListCreator() {
    }

    public static List<BookCommand> createBookCommandList() {
        BookCommand bookCommand = createBookCommand("Wheel of Time", "Robert Jordan");
        BookCommand bookCommand2 = createBookCommand("Assassin's Apprentice", "Robin Hobb");
        return Arrays.asList(bookCommand, bookCommand2);
    }

    public static BookCommand createBookCommand(String title, String author) {
        BookCommand bookCommand = new BookCommand();
        bookCommand.setTitle(title);
        bookCommand.setAuthor(author);
        return bookCommand;
    }

    public static List<Book> createBookList() {
        Book book1 = new Book("Wheel of Time", "Robert Jordan");
        Book book2 = new Book("Assassin's Apprentice", "Robin Hobb");
        return asList(book1, book2);
    }
}