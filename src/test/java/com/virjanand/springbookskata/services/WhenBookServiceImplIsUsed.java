package com.virjanand.springbookskata.services;

import com.virjanand.springbookskata.commands.BookCommand;
import com.virjanand.springbookskata.controllers.BookCommandListCreator;
import com.virjanand.springbookskata.converters.BookToBookCommand;
import com.virjanand.springbookskata.domain.Book;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.virjanand.springbookskata.controllers.BookCommandListCreator.createBookCommand;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class WhenBookServiceImplIsUsed {

    @Mock
    BookToBookCommand bookToBookCommand;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        setupBookToBookCommand();
    }

    private void setupBookToBookCommand() {
        connectBookAndBookCommand("Wheel of Time", "Robert Jordan");
        connectBookAndBookCommand("Assassin's Apprentice", "Robin Hobb");
    }

    private void connectBookAndBookCommand(String title, String author) {
        Book book = new Book(title, author);
        BookCommand bookCommand = createBookCommand(title, author);
        when(bookToBookCommand.convert(book)).thenReturn(bookCommand);
    }

    @Test
    public void returnListOfBookCommands() {
        BookServiceImpl bookService = new BookServiceImpl(bookToBookCommand);
        assertThat(bookService.getBookCommands()).isEqualTo(BookCommandListCreator.createBookCommandList());
    }

    @Test
    public void convertBooksToBookCommands() {
        BookServiceImpl bookService = new BookServiceImpl(bookToBookCommand);
        bookService.getBookCommands();
        verify(bookToBookCommand, times(2)).convert(any());
    }
}
