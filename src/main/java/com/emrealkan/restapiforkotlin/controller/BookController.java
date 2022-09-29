package com.emrealkan.restapiforkotlin.controller;

import com.emrealkan.restapiforkotlin.dto.BookRequest;
import com.emrealkan.restapiforkotlin.dto.BookResponse;
import com.emrealkan.restapiforkotlin.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.status;
import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
public class BookController {


    private final BookService bookService;

    @PostMapping("/save-book")
    public ResponseEntity<Void> createBook(@RequestBody BookRequest bookRequest){
        bookService.saveBook(bookRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/book-list")
    public ResponseEntity<List<BookResponse>> getBookList(){
       return status(HttpStatus.OK).body(bookService.getAllBooks());
    }



}
