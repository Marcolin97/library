-- Inserimento dati nella tabella "authors"
INSERT INTO authors (author_name, birthdate, nationality, info)
VALUES
    ('J.R.R. Tolkien', '1892-01-03', 'British', 'Author of fantasy literature'),
    ('George Orwell', '1903-06-25', 'British', 'Author and journalist'),
    ('Jane Austen', '1775-12-16', 'British', 'Novelist known for her romantic fiction'),
    ('Umberto Eco', '1932-01-05', 'Italian', 'Philosopher, novelist, and literary critic'),
    ('J.K. Rowling', '1965-07-31', 'British', 'Author and philanthropist');

-- Inserimento dati nella tabella "genres"
INSERT INTO genres (genre_name)
VALUES
    ('Epica fantasy'),
    ('Distopia'),
    ('Romanzo'),
    ('Giallo storico'),
    ('Fantasy');

-- Inserimento dati nella tabella "feedback"
INSERT INTO feedback (comment, rating, publication_date)
VALUES
    ('Molto appassionante!', 5, '2024-01-31'),
    ('Interessante ma cupo', 4, '2024-01-31'),
    ('Amo i romanzi di Jane Austen', 5, '2024-01-31'),
    ('Intrigante e ben scritto', 4, '2024-01-31'),
    ('Magia e avventura per tutte le età', 5, '2024-01-31');

-- Inserimento di dati nella tabella "books"
INSERT INTO books (title, author_id, publication_year, genre_id, editor, publisher, pages, description, feedback_id)
VALUES
    ('Il Signore degli Anelli', 1, '1954-01-01', 1, 'Mondadori', 'Bompiani', 1170, 'Epica fantasy di J.R.R. Tolkien', 1),
    ('1984', 2, '1949-01-01', 2, 'Einaudi', 'Harvill Secker', 328, 'Distopia di George Orwell', 2),
    ('Orgoglio e Pregiudizio', 3, '1813-01-01', 3, 'Newton Compton', 'Thomas Egerton', 432, 'Romanzo di Jane Austen', 3),
    ('Il Nome della Rosa', 4, '1980-01-01', 4, 'Adelphi', 'Harcourt Brace Jovanovich', 503, 'Giallo storico di Umberto Eco', 4),
    ('Harry Potter e la Pietra Filosofale', 5, '1997-01-01', 5, 'Salani', 'Bloomsbury', 332, 'Fantasy di J.K. Rowling', 5);

CREATE TYPE public.role AS ENUM (
    'ADMIN',
    'USER'
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

