USE Team1_RyanB;
DELIMITER $$ 
DROP PROCEDURE IF EXISTS create_jobRoleTable_001 $$ 
CREATE PROCEDURE create_jobRoleTable_001() 
BEGIN

-- Creates Job_Roles Table
CREATE TABLE IF NOT EXISTS Job_Roles (
    id TINYINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

END $$ 
DELIMITER ;

-- Runs the Procedure
CALL create_jobRoleTable_001();