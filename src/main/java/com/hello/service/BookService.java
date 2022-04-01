package com.hello.service;

import com.hello.domain.BookEntity;
import com.hello.dto.BookDTO;
import com.hello.dto.ResponseBookDTO;
import com.hello.dto.SaveBookRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
