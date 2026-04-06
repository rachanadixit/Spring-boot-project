package com.example.springbootproject.service;

import com.example.springbootproject.model.Book;
import com.example.springbootproject.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(String id, Book updatedBook) {
        Book existing = getBookById(id);
        if (existing == null) {
            return null;
        }
        existing.setTitle(updatedBook.getTitle());
        existing.setAuthor(updatedBook.getAuthor());
        existing.setPrice(updatedBook.getPrice());
        return bookRepository.save(existing);
    }

    public boolean deleteBook(String id) {
        Book existing = getBookById(id);
        if (existing == null) {
            return false;
        }
        bookRepository.deleteById(id);
        return true;
    }
}
