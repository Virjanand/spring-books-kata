package com.virjanand.springbookskata.controllers;

import com.virjanand.springbookskata.commands.BookCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static java.util.Arrays.asList;

@Controller
public class BookController {

    @GetMapping("")
    public String showListOfBooks(Model model) {
        model.addAttribute("booklist", createBookCommandList());
        return "books";
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
