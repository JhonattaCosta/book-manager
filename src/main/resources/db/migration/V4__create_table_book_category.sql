--V1 Create_table_book_category.sql --
CREATE TABLE book_category (
    book_id INTEGER,
    category_id INTEGER,
    CONSTRAINT fk_book_category_book FOREIGN KEY(book_id) REFERENCES book(id),
    CONSTRAINT fk_book_category_category FOREIGN KEY(category_id) REFERENCES category(id)
);


