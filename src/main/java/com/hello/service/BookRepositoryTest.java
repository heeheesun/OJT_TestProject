package com.hello.service;


import com.hello.domain.BookEntity;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;


    public void cleanup() {
        bookRepository.deleteAll();
    }

    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.now();
        bookRepository.save(BookEntity.builder()
                .title("title")
                .price(10000)
                .writer("writer")
                .publisher("publisher")
                .build());

        //when
        List<BookEntity> bookList = bookRepository.findAll();

        //then
        BookEntity bookEntity = bookList.get(0);
        System.out.println(">>>>> crateDate = "+ bookEntity.getCreatedDate() +" modifiedDate = "+ bookEntity.getModifiedDate() +"<<<<<");

    }



}
