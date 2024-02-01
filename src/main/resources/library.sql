-- Insertar datos para 5 autores en la tabla authors
INSERT INTO authors (birthdate, author_id, first_name, last_name, nationality, info)
VALUES
  ('1990-01-01', 1, 'Juan', 'García', 'Español', 'Escritor reconocido'),
  ('1985-03-15', 2, 'Maria', 'Lopez', 'Mexicano', 'Poeta famoso'),
  ('1978-07-20', 3, 'Carlos', 'Rodriguez', 'Argentino', 'Autor de bestsellers'),
  ('1982-05-12', 4, 'Isabel', 'Martínez', 'Colombiano', 'Ganador de premios literarios'),
  ('1995-09-08', 5, 'Andrés', 'Fernández', 'Chileno', 'Autor emergente');

  -- Insertar datos para 5 géneros en la tabla genre
  INSERT INTO genres (genre_id, genre_name)
  VALUES
    (1, 'Ficción'),
    (2, 'Fantasía'),
    (3, 'Misterio'),
    (4, 'Ciencia Ficción'),
    (5, 'Romance');

-- Insertar datos para 5 comentarios en la tabla feedback
INSERT INTO feedback (publication_date, feedback_id, rating, comment)
VALUES
  ('2023-05-10', 1, 4.5, 'Me encantó este libro, la trama es fascinante.'),
  ('2023-06-02', 2, 3.0, 'Interesante, pero la narrativa podría mejorar.'),
  ('2023-07-15', 3, 5.0, '¡Increíble! No pude dejar de leer.'),
  ('2023-08-20', 4, 4.0, 'Buena historia, los personajes son convincentes.'),
  ('2023-09-05', 5, 3.5, 'No estuvo mal, pero esperaba más emoción.');

-- Insertar datos para 5 libros en la tabla book
INSERT INTO books (publication_year, book_id, feedback_id, genre_id, pages, price, description, editor, publisher, title)
VALUES
  ('2010-05-10', 1, 1, 1, 300, 25.99, 'Una historia emocionante', 'Editorial A', 'Publicaciones XYZ', 'El Misterio del Pasado'),
  ('2015-06-11', 2, 2, 2, 240, 19.99, 'Un viaje épico', 'Editorial B', 'Libros Fantásticos', 'La Senda del Héroe'),
  ('2008-07-12', 3, 3, 3, 400, 32.50, 'Intriga y suspense', 'Editorial C', 'Misterio Editorial', 'El Secreto del Silencio'),
  ('2022-08-13', 4, 4, 4, 320, 28.75, 'Ciencia ficción futurista', 'Editorial D', 'Futuro Publicaciones', 'El Amanecer de los Androides'),
  ('2017-09-14', 5, 5, 5, 280, 21.99, 'Romance en París', 'Editorial E', 'Románticos Inc.', 'Amor en Montmartre');

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
INSERT INTO public.feedback (publication_date, feedback_id, rating, comment)
VALUES
    ('2022-01-31', 1, 5, 'Excellent read, couldn\t put it down!'),
    ('2022-02-15', 2, 4, 'Poetry that speaks to the heart'),
    ('2021-12-10', 3, 4, 'Mind-bending science fiction at its best'),
    ('2023-03-05', 4, 5, 'Captivating journey through history'),
    ('2023-06-20', 5, 4, 'Kept me on the edge of my seat from start to finish');

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



-- Genres Table
INSERT INTO public.genres (genre_id, genre_name)
VALUES
    (1, 'Mystery'),
    (2, 'Poetry'),
    (3, 'Science Fiction'),
    (4, 'Historical Fiction'),
    (5, 'Thriller');



--insert da mettere nel giusto ordine
