package com.hello.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BookEntity {
    //DB데이터와 1:1 매칭
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increase
    @Column(name = "ID")
    private int ID;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "price")
    private int price;

    @Column(name = "writer", nullable = false)
    private String writer;

    @Column(name = "publisher")
    private String publisher;

    BookEntity(int ID, String title, int price, String writer, String publisher) {
        this.ID = ID;
        this.title = title;
        this.price = price;
        this.writer = writer;
        this.publisher = publisher;
    }

    public static BookEntityBuilder builder() {
        return new BookEntityBuilder();
    }

    public static class BookEntityBuilder {
        private int ID;
        private String title;
        private int price;
        private String writer;
        private String publisher;

        BookEntityBuilder() {
        }

        public BookEntityBuilder ID(int ID) {
            this.ID = ID;
            return this;
        }

        public BookEntityBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BookEntityBuilder price(int price) {
            this.price = price;
            return this;
        }

        public BookEntityBuilder writer(String writer) {
            this.writer = writer;
            return this;
        }

        public BookEntityBuilder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public BookEntity build() {
            return new BookEntity(ID, title, price, writer, publisher);
        }

        public String toString() {
            return "BookEntity.BookEntityBuilder(ID=" + this.ID + ", title=" + this.title + ", price=" + this.price + ", writer=" + this.writer + ", publisher=" + this.publisher + ")";
        }
    }
}
