CREATE TABLE bookloan (
    id SERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE,
    status BOOLEAN NOT NULL DEFAULT TRUE
);