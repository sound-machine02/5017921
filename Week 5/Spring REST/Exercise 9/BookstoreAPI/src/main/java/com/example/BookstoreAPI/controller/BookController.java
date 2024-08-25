package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.entity.Book;
import com.example.BookstoreAPI.exception.ResourceNotFoundException;
import com.example.BookstoreAPI.mapper.BookMapper;
import com.example.BookstoreAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> {
                    BookDTO bookDTO = bookMapper.toDTO(book);
                    addBookLinks(bookDTO);
                    return bookDTO;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        BookDTO bookDTO = bookMapper.toDTO(book);
        addBookLinks(bookDTO);
        return ResponseEntity.ok(bookDTO);
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        Book createdBook = bookRepository.save(book);
        BookDTO createdBookDTO = bookMapper.toDTO(createdBook);
        addBookLinks(createdBookDTO);
        return ResponseEntity.status(201).body(createdBookDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book.setIsbn(bookDTO.getIsbn());

        Book updatedBook = bookRepository.save(book);
        BookDTO updatedBookDTO = bookMapper.toDTO(updatedBook);
        addBookLinks(updatedBookDTO);
        return ResponseEntity.ok(updatedBookDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        bookRepository.delete(book);
        return ResponseEntity.noContent().build();
    }

    private void addBookLinks(BookDTO bookDTO) {
        bookDTO.add(linkTo(methodOn(BookController.class).getBookById(bookDTO.getId())).withSelfRel());
        bookDTO.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("all-books"));
        bookDTO.add(linkTo(methodOn(BookController.class).updateBook(bookDTO.getId(), bookDTO)).withRel("update"));
        bookDTO.add(linkTo(methodOn(BookController.class).deleteBook(bookDTO.getId())).withRel("delete"));
    }
}