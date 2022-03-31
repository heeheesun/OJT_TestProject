package com.hello.dto;

import com.hello.domain.BookEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SaveBookRequestDTO {
    private String title;
    private int price;
    private String writer;
    private String publisher;

    public BookEntity toEntity(){
        return BookEntity.builder()
                .title(title)
                .price(price)
                .writer(writer)
                .publisher(publisher)
                .build();
    }

}
