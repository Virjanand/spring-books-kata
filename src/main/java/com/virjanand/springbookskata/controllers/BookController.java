package com.virjanand.springbookskata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static java.util.Arrays.asList;

@Controller
public class BookController {

    @GetMapping("")
    public String showListOfBooks(Model model) {
        List<String> bookList = asList("Wheel of Time");
        model.addAttribute("booklist", bookList);
        return "books";
    }
}
