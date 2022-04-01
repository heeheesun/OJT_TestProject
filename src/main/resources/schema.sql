CREATE TABLE BOOK_ENTITY(
    ID int AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50),
    price int,
    writer VARCHAR(20),
    publisher VARCHAR(20)
);
INSERT INTO BOOK_ENTITY(title,price,writer,publisher) VALUES ('남극대륙',40500,'David Day','미다스북스');
INSERT INTO BOOK_ENTITY(title,price,writer,publisher) VALUES ('사람은 무엇으로 사는가',20000,'레프 톨스토이','민음사');