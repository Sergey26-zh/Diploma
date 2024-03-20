CREATE TABLE "users" (
    id BIGSERIAL  PRIMARY KEY,
    "user_name" VARCHAR(64) NOT NULL,
    "first_name" VARCHAR(64) NOT NULL,
    "last_name" VARCHAR(64) NOT NULL,
    "email" VARCHAR(128) NOT NULL,
    "birthdate" DATE NOT NULL ,
    "password" VARCHAR(128) NOT NULL,
    "roles" VARCHAR(64) NOT NULL
);