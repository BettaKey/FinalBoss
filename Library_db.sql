CREATE TABLE "Users" (
  "user_id" SERIAL PRIMARY KEY,
  "username" VARCHAR(50) UNIQUE NOT NULL,
  "password" VARCHAR(255) NOT NULL,
  "role" VARCHAR(50) NOT NULL
);

CREATE TABLE "MyUserDetails" (
  "user_details_id" SERIAL PRIMARY KEY,
  "user_id" INT NOT NULL,
  "first_name" VARCHAR(50) NOT NULL,
  "last_name" VARCHAR(50) NOT NULL,
  "email" VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE "Authors" (
  "author_id" SERIAL PRIMARY KEY,
  "author_name" VARCHAR(100) NOT NULL
);

CREATE TABLE "Genres" (
  "genre_id" SERIAL PRIMARY KEY,
  "genre_name" VARCHAR(100) NOT NULL
);

CREATE TABLE "Books" (
  "book_id" SERIAL PRIMARY KEY,
  "title" VARCHAR(255) NOT NULL,
  "publication_year" INT
);

CREATE TABLE "BookAuthors" (
  "book_id" INT NOT NULL,
  "author_id" INT NOT NULL
);

CREATE TABLE "BookGenres" (
  "book_id" INT NOT NULL,
  "genre_id" INT NOT NULL
);

CREATE TABLE "BookLoans" (
  "loan_id" SERIAL PRIMARY KEY,
  "user_id" INT NOT NULL,
  "book_id" INT NOT NULL,
  "loan_date" DATE NOT NULL,
  "return_date" DATE
);

ALTER TABLE "MyUserDetails" ADD FOREIGN KEY ("user_id") REFERENCES "Users" ("user_id") ON DELETE CASCADE;

ALTER TABLE "BookAuthors" ADD FOREIGN KEY ("book_id") REFERENCES "Books" ("book_id") ON DELETE CASCADE;

ALTER TABLE "BookAuthors" ADD FOREIGN KEY ("author_id") REFERENCES "Authors" ("author_id") ON DELETE CASCADE;

ALTER TABLE "BookGenres" ADD FOREIGN KEY ("book_id") REFERENCES "Books" ("book_id") ON DELETE CASCADE;

ALTER TABLE "BookGenres" ADD FOREIGN KEY ("genre_id") REFERENCES "Genres" ("genre_id") ON DELETE CASCADE;

ALTER TABLE "BookLoans" ADD FOREIGN KEY ("user_id") REFERENCES "Users" ("user_id") ON DELETE CASCADE;

ALTER TABLE "BookLoans" ADD FOREIGN KEY ("book_id") REFERENCES "Books" ("book_id") ON DELETE CASCADE;
