--il nome del database è library
--le tabelle sono state riempite da chat gpt


-- Creazione della tabella "authors"
CREATE TABLE authors (
    author_id INT PRIMARY KEY,
    author_name VARCHAR(255) NOT NULL,
    birthdate DATE,
    nationality VARCHAR(50),
    info VARCHAR(250)
);

-- Creazione della tabella "genres"
CREATE TABLE genres (
    genre_id INT PRIMARY KEY,
    genre_name VARCHAR(100) NOT NULL
);

-- Creazione della tabella "books"
CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_id INT,
    publication_year INT,
    genre_id INT,
    editor VARCHAR(100),
    publisher VARCHAR(100),
    pages INT,
    description VARCHAR(250),
    feedback_id INT,
    price INT,
    FOREIGN KEY (author_id) REFERENCES authors(author_id),
    FOREIGN KEY (genre_id) REFERENCES genres(genre_id)
);

-- Creazione della tabella "feedback"
CREATE TABLE feedback (
    feedback_id INT PRIMARY KEY,
    comment VARCHAR(250),
    rating INT,
    publication_date INT
);

-- Creazione della tabella "customers"
CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(100),
    nickname_login VARCHAR(100),
    password VARCHAR(100),
    email VARCHAR(100),
    phone INT,
    address VARCHAR(150)
);