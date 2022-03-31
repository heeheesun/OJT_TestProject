package com.hello.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookDTO {
    private final String title;
    private int price;
    private String writer;
    private String publisher;

}
