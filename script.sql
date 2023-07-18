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
	`name` VARCHAR(64) NOT NULL,
	PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS `User` (
	username VARCHAR(64) NOT NULL,
	`password` VARCHAR(64) NOT NULL,
	role_id TINYINT NOT NULL,
	PRIMARY KEY (username),
	INDEX role_id (role_id ASC) VISIBLE,
	CONSTRAINT FOREIGN KEY (role_id) REFERENCES `Role`(id)
);
CREATE TABLE IF NOT EXISTS Token (
	username VARCHAR(64) NOT NULL,
	token VARCHAR(64) NOT NULL,
	expiry DATETIME NOT NULL,
	INDEX username(username ASC) VISIBLE,
	CONSTRAINT FOREIGN KEY (username) REFERENCES `User`(username)
);
CREATE TABLE IF NOT EXISTS Competency (
	id TINYINT AUTO_INCREMENT NOT NULL,
	ability VARCHAR(150) NOT NULL,
	PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS Banding (
	id TINYINT NOT NULL AUTO_INCREMENT,
	level_of_band VARCHAR(64) NOT NULL,
	training_available VARCHAR(64) NOT NULL,
	competency_id TINYINT NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FOREIGN KEY (competency_id) REFERENCES Competency(id)
);
CREATE TABLE IF NOT EXISTS Capability (
	id TINYINT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(150) NOT NULL,
	PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS Job_Roles (
	id TINYINT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(64) NOT NULL,
	description VARCHAR(64) NOT NULL,
	band_id TINYINT NOT NULL,
	capability_id TINYINT NOT NULL,
	INDEX `name` (`name` ASC) VISIBLE,
	PRIMARY KEY (id),
	CONSTRAINT FOREIGN KEY (band_id) REFERENCES Banding(id),
	CONSTRAINT FOREIGN KEY (capability_id) REFERENCES Capability(id)
);
-- INSERT test data
INSERT INTO Role(id, name)
VALUES (1, 'Admin');
INSERT INTO Role(id, name)
VALUES (2, 'User');
INSERT INTO User(username, password, role_id)
VALUES ('admin', 'admin', 1);
INSERT INTO User(username, password, role_id)
VALUES ('user', 'user', 2);

-- Check the number of affected rows
GET DIAGNOSTICS @rows = ROW_COUNT;
IF @rows = 0 THEN 
ROLLBACK;
SELECT 'Transaction rolled back due to error.';
ELSE -- If no error occurred. commit the transaction
COMMIT;
SELECT 'Transaction committed successfully.';
END IF;
END $$ DELIMITER ;
CALL create_transaction();