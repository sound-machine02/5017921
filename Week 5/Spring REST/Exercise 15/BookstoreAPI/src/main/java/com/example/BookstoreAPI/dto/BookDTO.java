package com.example.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"title", "author"})
public class BookDTO extends RepresentationModel<BookDTO> {

    private Long id;

    @JsonProperty("bookTitle")
    private String title;

    @JsonProperty("bookAuthor")
    private String author;
    private Double price;
    private String isbn;

}