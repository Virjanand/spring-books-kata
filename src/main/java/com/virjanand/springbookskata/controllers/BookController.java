package com.virjanand.springbookskata.controllers;

import com.virjanand.springbookskata.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String showListOfBooks(Model model) {
        model.addAttribute("booklist", bookService.getBookCommands());
        return "books";
    }

}
