package com.virjanand.springbookskata.services;

import com.virjanand.springbookskata.commands.BookCommand;

import java.util.List;

public interface BookService {

    List<BookCommand> getBookCommands();
}
