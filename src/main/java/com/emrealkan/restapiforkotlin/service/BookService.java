package com.emrealkan.restapiforkotlin.service;

import com.emrealkan.restapiforkotlin.dto.BookRequest;
import com.emrealkan.restapiforkotlin.dto.BookResponse;
import com.emrealkan.restapiforkotlin.mapper.BookMapper;
import com.emrealkan.restapiforkotlin.model.Book;
import com.emrealkan.restapiforkotlin.model.Category;
import com.emrealkan.restapiforkotlin.repository.BookRepository;
import com.emrealkan.restapiforkotlin.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final BookMapper bookMapper;



    @Transactional
    public void saveBook(BookRequest bookRequest){
        Category category = categoryRepository.findById(bookRequest.getCategoryId()).orElseThrow(()->new RuntimeException("Not Found"));
        Book book = new Book();
        book.setIsbnNumber(bookRequest.getIsbnNumber());
        book.setName(bookRequest.getName());
        book.setCategory(category);

       bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public List<BookResponse> getAllBooks(){
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
