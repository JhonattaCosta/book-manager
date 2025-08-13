CREATE TABLE book_author (
    book_id INTEGER,
    author_id INTEGER,
    CONSTRAINT fk_book_author_book FOREIGN KEY(book_id) REFERENCES book(id),
    CONSTRAINT fk_book_author_author FOREIGN KEY(author_id) REFERENCES author(id)
);