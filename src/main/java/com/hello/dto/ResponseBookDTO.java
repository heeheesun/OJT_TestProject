package com.hello.dto;

import com.hello.domain.BookEntity;
import lombok.Getter;

@Getter
public class ResponseBookDTO {
    private int ID;
    private String title;
    private int price;
    private String writer;
    private String publisher;

    public ResponseBookDTO(BookEntity bookEntity){
        this.ID = bookEntity.getID();
        this.title = bookEntity.getTitle();
        this.price = bookEntity.getPrice();
        this.writer = bookEntity.getWriter();
        this.publisher = bookEntity.getPublisher();
    }
}
