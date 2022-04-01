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

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void save(BookEntity bookEntity){
        System.out.println("plz work");
//        System.out.println("bookRepository.save(requestDTO.toEntity()).getID() = "+bookRepository.save(requestDTO.toEntity()).getID());
        bookRepository.save(bookEntity);
    }

    public ResponseBookDTO findByID(int ID){
        BookEntity bookEntity = bookRepository.findById(ID).orElseThrow(() -> new IllegalArgumentException("해당하는 코드의 책이 없습니다. ID=" + ID));
        return new ResponseBookDTO(bookEntity);
    }

    @Transactional
    public int update(int ID, UpdateBookRequestDTO requestDTO){
        BookEntity bookEntity = bookRepository.findById(ID).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. ID = "+ID));

        bookEntity.update(requestDTO.getTitle(),requestDTO.getPrice(),requestDTO.getWriter(),requestDTO.getPublisher());
        return ID;
    }
}
