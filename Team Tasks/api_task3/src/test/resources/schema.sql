CREATE TABLE IF NOT EXISTS messages (
    id INT NOT NULL PRIMARY KEY,
    msg VARCHAR(4000)
);

INSERT INTO messages VALUES(13, 'First message of queue');
INSERT INTO messages VALUES(14, 'Second message of queue');
INSERT INTO messages VALUES(15, 'Third message of queue');