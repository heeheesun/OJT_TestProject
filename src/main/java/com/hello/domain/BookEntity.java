package com.hello.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Builder
public class BookEntity {
    //DB데이터와 1:1 매칭
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increase
    private int key;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 10)
    private int price;

    @Column(length = 50, nullable = false)
    private String writer;

    @Column(length = 50)
    private String publisher;

}
