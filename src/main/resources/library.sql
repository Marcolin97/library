--il nome del database è library
--le tabelle sono state riempite da chat gpt


-- Creazione della tabella "authors"
CREATE TABLE authors (
    author_id BIGINT PRIMARY KEY,
    author_name VARCHAR(255) NOT NULL,
    birthdate DATE,
    nationality VARCHAR(50),
    info VARCHAR(250)
);

-- Creazione della tabella "genres"
CREATE TABLE genres (
    genre_id BIGINT PRIMARY KEY,
    genre_name VARCHAR(100) NOT NULL --cambiare?
);

-- Creazione della tabella "books"
CREATE TABLE books (
    book_id BIGINT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_id BIGINT,
    publication_year BIGINT,
    genre_id BIGINT,
    editor VARCHAR(100),
    publisher VARCHAR(100),
    pages BIGINT,
    description VARCHAR(250),
    feedback_id BIGINT, --foreign mettere
    FOREIGN KEY (author_id) REFERENCES authors(author_id),
    FOREIGN KEY (genre_id) REFERENCES genres(genre_id)
);

-- Creazione della tabella "feedback"
CREATE TABLE feedback (
    feedback_id BIGINT PRIMARY KEY, --foreign mettere
    comment VARCHAR(250),
    rating BIGINT,
    publication_date BIGINT
);

-- Creazione della tabella "customers"
CREATE TABLE customers (
    customer_id BIGINT PRIMARY KEY,
    customer_name VARCHAR(100),
    nickname_login VARCHAR(100),
    password VARCHAR(100),
    email VARCHAR(100),
    phone BIGINT,
    address VARCHAR(150)
);