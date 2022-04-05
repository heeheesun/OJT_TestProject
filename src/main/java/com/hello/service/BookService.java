package com.hello.service;

import com.hello.domain.BookEntity;
import com.hello.dto.BookDTO;
import com.hello.dto.ResponseBookDTO;
import com.hello.dto.SaveBookRequestDTO;
import com.hello.dto.UpdateBookRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    LocalDateTime now = LocalDateTime.now();

    public void save(BookEntity bookEntity){
        bookRepository.save(bookEntity);
        System.out.println(">>>>> crateDate = "+ bookEntity.getCreatedDate() +" modifiedDate = "+ bookEntity.getModifiedDate() +"<<<<<");
    }

    public ResponseBookDTO findByID(int ID){
        BookEntity bookEntity = bookRepository.findById(ID).orElseThrow(() -> new IllegalArgumentException("해당하는 코드의 책이 없습니다. ID=" + ID));
        return new ResponseBookDTO(bookEntity);
    }

    @Transactional
    public BookEntity update(int ID, BookEntity requestDTO){
        BookEntity bookEntity = bookRepository.findById(ID).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. ID = "+ID));
        bookEntity.update(requestDTO.getTitle(),requestDTO.getPrice(),requestDTO.getWriter(),requestDTO.getPublisher());


        return bookEntity;
    }

    public boolean delete(int ID) throws IllegalArgumentException{
        BookEntity bookEntity = bookRepository.findById(ID).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. ID = "+ID));
        if(bookEntity != null){
            bookRepository.delete(bookEntity);
            return true;
        }
        return false;
    }



}
