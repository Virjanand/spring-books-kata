package com.virjanand.springbookskata.repositories;

import com.virjanand.springbookskata.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
