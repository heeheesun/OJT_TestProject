package com.hello.controller;

import com.hello.domain.BookEntity;
import com.hello.dto.BookDTO;
import com.hello.dto.ResponseBookDTO;
import com.hello.dto.SaveBookRequestDTO;
import com.hello.dto.UpdateBookRequestDTO;
import com.hello.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HelloController {

    @Autowired
    private BookService bookService;

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        System.out.println("hello world");
        return "Hello World!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello/dto")
    public BookDTO helloBook(@RequestParam("title") String title,
                             @RequestParam("price") int price,
                             @RequestParam("writer") String writer,
                             @RequestParam("publisher") String publisher) {
        //현재 RequestParam으로 모든 값을 일일히 가져오는데
        //RequestParam("DTO") BookDTO [변수명] 처럼 한번에 값을 받아올 수도 있다
        System.out.println("hello");
        BookDTO book1 = BookDTO.builder()
                .title(title)
                .price(price)
                .writer(writer)
                .publisher(publisher)
                .build();

        return book1;
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/api/v1/posts")
    public void postBook(@RequestBody BookEntity bookEntity) {
        System.out.println("postBook");

        bookService.save(bookEntity);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/v1/posts/{ID}")
    public ResponseBookDTO getBook(@PathVariable int ID){
        System.out.println("getBook");
        return bookService.findByID(ID);
    }

    @PutMapping("/api/v1/posts/{ID}")
    public int updateBook(@PathVariable int ID, @RequestBody UpdateBookRequestDTO requestDTO){
        System.out.println("updateBook");
        return bookService.update(ID,requestDTO);
    }


}
