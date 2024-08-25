package com.example.BookstoreAPI.mapper;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "isbn", target = "isbn")
    BookDTO toDTO(Book book);

    List<BookDTO> toDTOs(List<Book> books);

    Book toEntity(BookDTO bookDTO);

    List<Book> toEntities(List<BookDTO> bookDTOs);

    List<BookDTO> toDTOList(List<Book> books);
}