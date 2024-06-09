CREATE TABLE ProjectReports
(
    reportID        SERIAL PRIMARY KEY,
    projectID       BIGSERIAL,
    TotalTasks      INT,
    CompletedTasks  INT,
    InProgressTasks INT,
    CreatedAt       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ProjectID) REFERENCES project (id)
);