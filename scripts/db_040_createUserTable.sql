USE Team1_RyanB;
DELIMITER $$
DROP PROCEDURE IF EXISTS create_UserTable_040 $$
CREATE PROCEDURE create_UserTable_040()
BEGIN

CREATE TABLE IF NOT EXISTS `User` (
    id SMALLINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(50) NOT NULL,
    role_id TINYINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (role_id) REFERENCES Role(id)
);

END $$
DELIMITER ;
-- Runs the Procedure
CALL create_UserTable_040();