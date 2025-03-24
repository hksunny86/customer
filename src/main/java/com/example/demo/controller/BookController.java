package com.example.demo.controller;

import com.example.demo.dto.BookLocationRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/add-to-location")
    public ResponseEntity<String> addBookToLocation(@RequestBody BookLocationRequest request){
        bookService.addBookToLocation(request);
        return ResponseEntity.ok("Book added to location successfully!");
    }

    @RequestMapping("/available")
    public ResponseEntity<List<BookResponse>> getAvailableBooks(){
        return ResponseEntity.ok(bookService.getAvailableBooks());
    }


}
