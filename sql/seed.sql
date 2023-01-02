DROP TABLE IF EXISTS posts;

CREATE TABLE posts (
                           id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                           user_id UUID NOT NULL,
                           title varchar(255) NOT NULL,
                           body varchar,
                           CONSTRAINT fk_user
                               FOREIGN KEY(user_id)
                                   REFERENCES users(id)
);

INSERT INTO posts (user_id, title, body)
VALUES ('a534fc6c-8c94-4911-9260-738e10a27fca', 'berke title', 'berke body'),
       ('9fd4ba77-8659-40a2-bde9-d927125fb314', 'john title', 'john body'),
       ('7fc24be9-6265-4a0a-9876-573dee9437d2', 'jane title', 'jane body'),
       ('2b19dd8b-6829-4363-a031-e081fc8a0c2b', 'grace title', 'grace body'),
       ('18354101-cabf-423b-9a17-7f272770275f', 'lisa title', 'lisa body'),
       ('58d57d08-3945-4b0c-8eba-627d2a92a022', 'sergio title 1', 'sergio body 1'),
       ('58d57d08-3945-4b0c-8eba-627d2a92a022', 'sergio title 2', 'sergio body 2');