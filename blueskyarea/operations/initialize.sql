CREATE TABLE questions(
    id serial PRIMARY KEY,
    category_id integer,
    question varchar NOT NULL,
    answer varchar NOT NULL,
    question_count integer,
    right_count integer,
    created_at timestamp with time zone,
    modified_at timestamp with time zone
);
