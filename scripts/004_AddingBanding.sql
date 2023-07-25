USE Team1_RyanB;
DELIMITER $$
DROP PROCEDURE IF EXISTS create_bandingTable_004 $$
CREATE PROCEDURE create_bandingTable_004()
BEGIN

-- Creates Job_Roles table
CREATE TABLE IF NOT EXISTS Banding (
    id TINYINT NOT NULL AUTO_INCREMENT,
    level_of_band VARCHAR(50) NOT NULL,
    training_available VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

-- Adds capability column to Job_Roles table
ALTER TABLE Job_Roles
ADD COLUMN band_id TINYINT  ,
ADD CONSTRAINT FOREIGN KEY (band_id) REFERENCES Banding(id);
END $$
DELIMITER ;

-- Runs the Procedure
CALL create_bandingTable_004();