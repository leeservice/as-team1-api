DELIMITER $$ 
DROP PROCEDURE IF EXISTS create_transaction $$ 
CREATE PROCEDURE create_transaction() 
BEGIN
START TRANSACTION;
-- Drop if exists
DROP DATABASE IF EXISTS Team1_RyanB;
-- Create database
CREATE DATABASE Team1_RyanB;
CREATE TABLE IF NOT EXISTS `Role` (
    id TINYINT NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS `User` (
    username VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    role_id TINYINT NOT NULL,
    PRIMARY KEY (username),
    INDEX role_id (role_id ASC) VISIBLE,
    CONSTRAINT FOREIGN KEY (role_id) REFERENCES `Role`(id)
);
CREATE TABLE IF NOT EXISTS Token (
    username VARCHAR(50) NOT NULL,
    token VARCHAR(50) NOT NULL,
    expiry DATETIME NOT NULL,
    INDEX username(username ASC) VISIBLE,
    CONSTRAINT FOREIGN KEY (username) REFERENCES `User`(username)
);
CREATE TABLE IF NOT EXISTS Competency (
    id TINYINT AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS Banding (
    id TINYINT NOT NULL AUTO_INCREMENT,
    level_of_band VARCHAR(50) NOT NULL,
    training_available VARCHAR(50),
    competency_id TINYINT,
    PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (competency_id) REFERENCES Competency(id)
);
CREATE TABLE IF NOT EXISTS Capability (
    id TINYINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS Job_Roles (
    id TINYINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(150) NOT NULL,
    band_id TINYINT NOT NULL,
    capability_id TINYINT NOT NULL,
    INDEX `name` (`name` ASC) VISIBLE,
    PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (band_id) REFERENCES Banding(id),
    CONSTRAINT FOREIGN KEY (capability_id) REFERENCES Capability(id)
);
-- Role test data
INSERT INTO Role(id, name)
VALUES (1, 'Admin');
INSERT INTO Role(id, name)
VALUES (2, 'User');
-- User test data
INSERT INTO User(username, password, role_id)
VALUES ('admin', 'admin', 1);
INSERT INTO User(username, password, role_id)
VALUES ('user', 'user', 2);
-- Competency test data
INSERT INTO Competency(`name`)
VALUES ('Personal Performance'),
('Working With Others'),
('Setting Direction, Development and Accountability'),
('Supporting and Delivering the Strategy'),
('Commerciality and Risk'),
('Communication and Influence');
INSERT INTO Banding(level_of_band)
VALUES('Leadership Community'),
('Principal'),
('Manager' ),
('Consultant'),
('Senior Associate'),
('Associate'),
('Trainee'),
('Apprentice');
INSERT INTO Capability(`name`)
VALUES('Engineering Strategy and Planning'),
('Engineering'),
('Architecture'),
('Testing and Quality Assurance'),
('Product Specialist');
INSERT INTO Job_Roles(`name`, `description`, band_id, capability_id)
VALUES('Technology Leader', 'A technology leader is a key strategic role within the business making executive technology decisions on behalf of the business.',
1, 1),
('Principal Architect', 'A principal architect is accountable for successful delivery of large-scale high-quality solutions.',
2, 3),
('Principal Test Architect', 'A principal test architect is responsible for ensuring high quality solutions are delivered.',
2, 4),
('Solution Architect', 'A solution architect is responsible for leading multi-skilled agile teams to design and deliver high quality solutions.',
3, 3),
('Test Architect', 'A test architect is responsible for ensuring delivery of high quality solutions.',
3, 4);
-- Check the number of affected rows
GET DIAGNOSTICS @rows = ROW_COUNT;
IF @rows = 0 THEN ROLLBACK;
SELECT 'Transaction rolled back due to error.';
ELSE -- If no error occurred. commit the transaction
COMMIT;
SELECT 'Transaction committed successfully.';
END IF;
END $$ DELIMITER ;
CALL create_transaction();