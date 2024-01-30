INSERT INTO authors (author_id, author_name, birthdate, nationality, info)
VALUES
(1, 'Jane Austen', '1775-12-16', 'British', 'Renowned English novelist'),
(2, 'Fyodor Dostoevsky', '1821-11-11', 'Russian', 'Russian novelist and philosopher'),
(3, 'Gabriel Garcia Marquez', '1927-03-06', 'Colombian', 'Nobel Prize-winning Colombian author'),
(4, 'Haruki Murakami', '1949-01-12', 'Japanese', 'Contemporary Japanese writer'),
(5, 'Chimamanda Ngozi Adichie', '1977-09-15', 'Nigerian', 'Nigerian author and speaker');

CREATE TYPE public.role AS ENUM (
    'ADMIN',
    'USER',
);

ALTER TYPE public.role OWNER TO "postgresMaster";

CREATE CAST (character varying AS public.role) WITH INOUT AS ASSIGNMENT;

CREATE TABLE IF NOT EXISTS _user (
    user_id SERIAL PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role public.role NOT NULL
);

CREATE TABLE IF NOT EXISTS token (
    token_id SERIAL PRIMARY KEY,
    token VARCHAR(255) UNIQUE NOT NULL,
    token_type VARCHAR(50) NOT NULL,
    revoked BOOLEAN NOT NULL,
    expired BOOLEAN NOT NULL,
    user_id BIGINT,
	FOREIGN KEY (user_id) REFERENCES _user(user_id)
);

-- Creazione della tabella "authors"
CREATE TABLE authors (
    author_id SERIAL PRIMARY KEY,
    author_name VARCHAR(255) NOT NULL,
    birthdate DATE,
    nationality VARCHAR(50),
    info VARCHAR(250)
);

-- Creazione della tabella "genres"
CREATE TABLE genres (
    genre_id SERIAL PRIMARY KEY,
    genre_name VARCHAR(100) NOT NULL
);

-- Creazione della tabella "feedback"
CREATE TABLE feedback (
    feedback_id SERIAL PRIMARY KEY,
    comment VARCHAR(250),
    rating BIGINT,
    publication_date DATE
);

-- Creazione della tabella "books"
CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_id BIGINT,
    publication_year BIGINT,
    genre_id BIGINT,
    editor VARCHAR(100),
    publisher VARCHAR(100),
    pages BIGINT,
    description VARCHAR(250),
    feedback_id BIGINT,
    FOREIGN KEY (author_id) REFERENCES authors(author_id),
    FOREIGN KEY (genre_id) REFERENCES genres(genre_id),
    FOREIGN KEY (feedback_id) REFERENCES feedback(feedback_id)
);

-- Ceazione della tabella "user_books"
CREATE TABLE user_books (
    assignment_id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES _user(user_id),
    FOREIGN KEY (book_id) REFERENCES books(book_id)
)

