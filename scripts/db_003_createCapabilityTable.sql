USE Team1_RyanB;
DELIMITER $$
DROP PROCEDURE IF EXISTS create_capabilityTable_003 $$
CREATE PROCEDURE create_capabilityTable_003()
BEGIN
-- Creates Capability table
CREATE TABLE IF NOT EXISTS Capability (
    id TINYINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

-- Adds capability column to Job_Roles table
ALTER TABLE Job_Roles
ADD COLUMN capability_id TINYINT,
ADD CONSTRAINT FOREIGN KEY (capability_id) REFERENCES Capability(id);

END $$
DELIMITER ;

-- Runs the Procedure
CALL create_capabilityTable_003();