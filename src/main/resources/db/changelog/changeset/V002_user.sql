CREATE TABLE "users" (
    id BIGSERIAL  PRIMARY KEY,
    "first_name" VARCHAR(64) NOT NULL,
    "last_name" VARCHAR(64) NOT NULL,
    "email" VARCHAR(128) NOT NULL,
    "birthdate" DATE,
    "position" VARCHAR(128) NOT NULL,
    "password" VARCHAR(128) NOT NULL
);