CREATE TABLE BOOK_ENTITY(
    ID int AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50),
    price int,
    writer VARCHAR(20),
    publisher VARCHAR(20)
);


INSERT INTO BOOK_ENTITY(title,price,writer,publisher) VALUES ('남극대륙',40500,'David Day','미다스북스');