package com.virjanand.springbookskata.services;

import com.virjanand.springbookskata.controllers.BookCommandListCreator;
import com.virjanand.springbookskata.converters.BookToBookCommand;
import com.virjanand.springbookskata.domain.Book;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.virjanand.springbookskata.controllers.BookCommandListCreator.createBookCommandList;
import static com.virjanand.springbookskata.controllers.BookCommandListCreator.createBookList;
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
        List<Book> books = createBookList();
        when(bookToBookCommand.convertBooksToBookCommands(books))
                .thenReturn(createBookCommandList());
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
        verify(bookToBookCommand, times(1)).convertBooksToBookCommands(any());
    }
}
