package com.prasad.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasad.books.domain.Book;
import com.prasad.books.repos.BookRepo;

@Service
public class BookService {

	@Autowired
	BookRepo bookRepo;

	public Optional<Book> getBookById(long id) {
		return bookRepo.findById(id);
	}

	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	public Book updateBook(long id, Book book) {
		Book bookDB = bookRepo.getById(id);

		if (!book.getTitle().isEmpty()) {
			bookDB.setTitle(book.getTitle());
		}

		if (!book.getDescription().isEmpty()) {
			bookDB.setDescription(book.getDescription());
		}

		if (!book.getCategory().isEmpty()) {
			bookDB.setCategory(book.getCategory());
		}

		return bookRepo.save(bookDB);
	}

	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}

	public void deleteBook(long id) {
		bookRepo.deleteById(id);
	}

}
