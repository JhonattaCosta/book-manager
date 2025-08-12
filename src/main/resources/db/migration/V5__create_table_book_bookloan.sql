--V1 Create_table_book_bookloan.sql --
CREATE TABLE book_bookloan (
    book_id INTEGER,
    bookloan_id INTEGER,
    CONSTRAINT fk_book_bookloan_book FOREIGN KEY(book_id) REFERENCES book(id),
    CONSTRAINT fk_book_bookloan_bookloan FOREIGN KEY(bookloan_id) REFERENCES bookloan(id)
);