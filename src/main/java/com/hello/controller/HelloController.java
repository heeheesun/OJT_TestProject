package com.hello.controller;

import com.hello.dto.BookDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

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





}
