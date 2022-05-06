package com.prasad.books.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prasad.books.domain.Book;
import com.prasad.books.service.BookService;

@RestController
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		logger.info("Inside getAllBooks");
		return bookService.getAllBooks();
	}

	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") long id) {
		logger.info("Inside getBookById");
		Book book = null;

		Optional<Book> bookOpt = bookService.getBookById(id);

		if (bookOpt.isPresent()) {
			book = bookOpt.get();
		}

		return book;
	}

	@PatchMapping("/books/{id}")
	public Book updateBook(@PathVariable("id") long id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}

	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") long id) {
		bookService.deleteBook(id);
	}

}
