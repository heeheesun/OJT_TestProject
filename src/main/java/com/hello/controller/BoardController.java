package com.hello.controller;

import com.hello.domain.BookEntity;
import com.hello.dto.BookDTO;
import com.hello.dto.ResponseBookDTO;
import com.hello.dto.UpdateBookRequestDTO;
import com.hello.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET, path = "/write")
    public String writeBook() {
        System.out.println("writeBook");
        return "boardWrite";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.PUT}, path = "/posts")
    public String postBook(@ModelAttribute BookEntity bookEntity) {
        System.out.println("postBook");
        bookService.save(bookEntity);
        return "redirect:/write";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{ID}")
    public String getBook(@PathVariable int ID, Model model){
        System.out.println("getBook");
        ResponseBookDTO responseBookDTO = bookService.findByID(ID);
        System.out.println("responseBookDTO = "+ responseBookDTO);
        model.addAttribute("bookDTO",responseBookDTO);
        return "boardDetail";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.PUT}, path = "/edit/{ID}")
    public String editBook(@PathVariable int ID, Model model){
        System.out.println("editBook");
        ResponseBookDTO responseBookDTO = bookService.findByID(ID);
        model.addAttribute("bookDTO",responseBookDTO);
        return "boardUpdate";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.PUT}, path = "/update/{ID}")
    public String updateBook(@PathVariable int ID, @ModelAttribute BookEntity requestDTO){
        System.out.println("updateBook");
        BookEntity bookEntity = bookService.update(ID,requestDTO);
        System.out.println(">>>>> crateDate = "+ bookEntity.getCreatedDate() +" modifiedDate = "+ bookEntity.getModifiedDate() +"<<<<<");
        return "redirect:/"+ID;

    }

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.DELETE}, path = "/delete/{ID}")
    public ResponseEntity<?> deleteBook(@PathVariable int ID){
        try{
            boolean isDelete = this.bookService.delete(ID);
            if(isDelete) {
                return ResponseEntity.ok("delete success");
            }else {
                return ResponseEntity.badRequest().body("can't find entity");
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Invalid Parameter");
        }
    }


}
