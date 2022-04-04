package com.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hello.domain.BookEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class SaveBookRequestDTO {
    @JsonProperty("key")
    private int ID;
    private String title;
    private int price;
    private String writer;
    private String publisher;

    public BookEntity toEntity(){
        return BookEntity.builder()
                .ID(ID)
                .title(title)
                .price(price)
                .writer(writer)
                .publisher(publisher)
                .build();
    }
    

    public SaveBookRequestDTO(int key, String title, int price, String writer, String publisher) {
        this.ID = ID;
        this.title = title;
        this.price = price;
        this.writer = writer;
        this.publisher = publisher;
    }

    public static SaveBookRequestDTOBuilder builder() {
        return new SaveBookRequestDTOBuilder();
    }


    public static class SaveBookRequestDTOBuilder {
        private int ID;
        private String title;
        private int price;
        private String writer;
        private String publisher;

        SaveBookRequestDTOBuilder() {
        }

        public SaveBookRequestDTOBuilder key(int ID) {
            this.ID = ID;
            return this;
        }

        public SaveBookRequestDTOBuilder title(String title) {
            this.title = title;
            return this;
        }

        public SaveBookRequestDTOBuilder price(int price) {
            this.price = price;
            return this;
        }

        public SaveBookRequestDTOBuilder writer(String writer) {
            this.writer = writer;
            return this;
        }

        public SaveBookRequestDTOBuilder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public SaveBookRequestDTO build() {
            return new SaveBookRequestDTO(ID, title, price, writer, publisher);
        }

        public String toString() {
            return "SaveBookRequestDTO.SaveBookRequestDTOBuilder(key=" + this.ID + ", title=" + this.title + ", price=" + this.price + ", writer=" + this.writer + ", publisher=" + this.publisher + ")";
        }
    }
}
