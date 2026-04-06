package com.example.springbootproject.repository;

import com.example.springbootproject.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
