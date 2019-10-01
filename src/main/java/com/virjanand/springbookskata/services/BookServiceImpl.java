package com.virjanand.springbookskata.services;

import com.virjanand.springbookskata.commands.BookCommand;
import com.virjanand.springbookskata.converters.BookToBookCommand;
import com.virjanand.springbookskata.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository repository;
    private final BookToBookCommand bookToBookCommand;

    public BookServiceImpl(BookRepository repository, BookToBookCommand bookToBookCommand) {
        this.repository = repository;
        this.bookToBookCommand = bookToBookCommand;
    }

    public List<BookCommand> getBookCommands() {
        return createBookCommandList();
    }

    private List<BookCommand> createBookCommandList() {
        return bookToBookCommand.convertBooksToBookCommands(repository.findAll());
    }
}
