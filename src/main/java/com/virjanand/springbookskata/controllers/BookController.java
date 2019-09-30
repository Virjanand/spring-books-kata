package com.virjanand.springbookskata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("")
    public String showListOfBooks() {
        return "books";
    }
}
