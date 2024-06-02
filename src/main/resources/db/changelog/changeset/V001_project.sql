CREATE TABLE project (
    id BIGSERIAL  PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    description VARCHAR(512) NOT NULL,
    location VARCHAR(128) NOT NULL,
    start_date DATE,
    "end_date" DATE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    "user_id" BIGSERIAL
);