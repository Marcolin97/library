-- Creazione della tabella enum "role"
CREATE TYPE public.role AS ENUM (
    'ADMIN',
    'USER'
);

ALTER TYPE public.role OWNER TO "postgresMaster";

CREATE CAST (character varying AS public.role) WITH INOUT AS ASSIGNMENT;

-- Creazione della tabella "_user"
CREATE TABLE IF NOT EXISTS _user (
    user_id SERIAL PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role public.role NOT NULL
);

-- Creazione della tabella "token"
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


-- Authors Table
INSERT INTO public.authors (birthdate, author_id, first_name, info, last_name, nationality)
VALUES
    ('1980-05-15', 1, 'John', 'Bestselling author known for mystery novels', 'Doe', 'American'),
    ('1975-08-22', 2, 'Jane', 'Renowned poet and essayist', 'Smith', 'British'),
    ('1990-03-10', 3, 'Michael', 'Science fiction writer with a focus on artificial intelligence', 'Johnson', 'Canadian'),
    ('1985-11-05', 4, 'Emily', 'Historical fiction author specializing in medieval settings', 'Brown', 'Australian'),
    ('1972-07-18', 5, 'Carlos', 'Author of contemporary novels exploring cultural diversity', 'Rodriguez', 'Spanish');

-- feedback Table
INSERT INTO public.feedback (publication_date, feedback_id, rating, comment)
VALUES
    ('2022-01-31', 1, 5, 'Excellent read, couldn\t put it down!'),
    ('2022-02-15', 2, 4, 'Poetry that speaks to the heart'),
    ('2021-12-10', 3, 4, 'Mind-bending science fiction at its best'),
    ('2023-03-05', 4, 5, 'Captivating journey through history'),
    ('2023-06-20', 5, 4, 'Kept me on the edge of my seat from start to finish');

-- Genres Table
INSERT INTO public.genres (genre_id, genre_name)
VALUES
    (1, 'Mystery'),
    (2, 'Poetry'),
    (3, 'Science Fiction'),
    (4, 'Historical Fiction'),
    (5, 'Thriller');

-- Books Table
INSERT INTO public.books (publication_year, book_id, feedback_id, genre_id, pages, price, description, editor, publisher, title)
VALUES
    ('2022-01-31', 1, 1, 1, 300, 25, 'Exciting mystery novel', 'ABC Editors', 'XYZ Publishers', 'The Mysterious Case'),
    ('2022-02-15', 2, 2, 2, 200, 20, 'Beautiful collection of poems', 'DEF Editors', 'LMN Publishers', 'Expressions of the Soul'),
    ('2021-12-10', 3, 3, 3, 400, 30, 'Thrilling science fiction adventure', 'GHI Editors', 'OPQ Publishers', 'The Quantum Odyssey'),
    ('2023-03-05', 4, 4, 4, 350, 28, 'Compelling historical fiction journey', 'JKL Editors', 'RST Publishers', 'Echoes of the Past'),
    ('2023-06-20', 5, 5, 1, 250, 22, 'Intriguing mystery thriller', 'UVW Editors', 'XYZ Publishers', 'Shadows in the Dark');

-- Books_Authors Table
INSERT INTO public.books_authors (authors_author_id, book_book_id)
VALUES
    (1, 1),
    (2, 1),
    (3, 2),
    (4, 3),
    (5, 4);
