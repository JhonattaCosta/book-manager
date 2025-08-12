--V1 Create_table_book.sql --
CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    release_day DATE,
);