package com.example.BookstoreAPI.mapper;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.entity.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-25T18:33:47+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO toDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setIsbn( book.getIsbn() );
        bookDTO.setId( book.getId() );
        bookDTO.setTitle( book.getTitle() );
        bookDTO.setAuthor( book.getAuthor() );
        bookDTO.setPrice( book.getPrice() );

        return bookDTO;
    }

    @Override
    public List<BookDTO> toDTOs(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookDTO> list = new ArrayList<BookDTO>( books.size() );
        for ( Book book : books ) {
            list.add( toDTO( book ) );
        }

        return list;
    }

    @Override
    public Book toEntity(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDTO.getId() );
        book.setTitle( bookDTO.getTitle() );
        book.setAuthor( bookDTO.getAuthor() );
        book.setPrice( bookDTO.getPrice() );
        book.setIsbn( bookDTO.getIsbn() );

        return book;
    }

    @Override
    public List<Book> toEntities(List<BookDTO> bookDTOs) {
        if ( bookDTOs == null ) {
            return null;
        }

        List<Book> list = new ArrayList<Book>( bookDTOs.size() );
        for ( BookDTO bookDTO : bookDTOs ) {
            list.add( toEntity( bookDTO ) );
        }

        return list;
    }

    @Override
    public List<BookDTO> toDTOList(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookDTO> list = new ArrayList<BookDTO>( books.size() );
        for ( Book book : books ) {
            list.add( toDTO( book ) );
        }

        return list;
    }
}
