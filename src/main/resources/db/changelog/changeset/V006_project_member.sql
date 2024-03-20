CREATE TABLE project_member (
    "project_member_id" BIGSERIAL PRIMARY KEY,
    "user_id" BIGINT NOT NULL,
    "project_id" BIGINT NOT NULL,
    "roles" VARCHAR(64) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user"(id),
    FOREIGN KEY (project_id) REFERENCES "project"(id)
);