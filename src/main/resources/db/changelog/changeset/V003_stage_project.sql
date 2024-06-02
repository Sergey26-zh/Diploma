CREATE TABLE "stage_project"
(
    id BIGSERIAL  PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    start_date DATE,
    "end_date" DATE,
    project_id BIGINT,
    FOREIGN KEY (project_id) REFERENCES project(id)
)