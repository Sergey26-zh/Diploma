CREATE TABLE Tasks (
                       taskID SERIAL PRIMARY KEY,
                       stageID INT,
                       TaskName VARCHAR(255),
                       Status VARCHAR(50),
                       CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (stageID) REFERENCES stage_project(id)
);