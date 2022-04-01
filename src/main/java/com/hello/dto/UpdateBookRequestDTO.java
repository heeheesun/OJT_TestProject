package com.hello.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateBookRequestDTO {
    private int ID;
    private String title;
    private int price;
    private String writer;
    private String publisher;

    public UpdateBookRequestDTO(String title, int price, String writer, String publisher){
        this.title = title;
        this.price = price;
        this.writer = writer;
        this.publisher = publisher;
    }
}
