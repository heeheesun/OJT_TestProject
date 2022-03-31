package com.hello.service;

import com.hello.dto.BookDTO;
import com.hello.dto.SaveBookRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public int save(SaveBookRequestDTO requestDTO){
        return bookRepository.save(requestDTO.toEntity()).getKey();
    }
}
