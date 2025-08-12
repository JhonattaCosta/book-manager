--V1 Create_table_bookloan.sql --
CREATE TABLE bookloan (
    id SERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE,
    status BOOLEAN NOT NULL DEFAULT TRUE
);