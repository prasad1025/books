package com.prasad.books.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prasad.books.domain.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

}
