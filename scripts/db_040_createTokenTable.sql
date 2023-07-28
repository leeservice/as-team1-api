USE Team1_RyanB;
DELIMITER $$
DROP PROCEDURE IF EXISTS create_TokenTable_040 $$
CREATE PROCEDURE create_TokenTable_040()
BEGIN

CREATE TABLE IF NOT EXISTS Token (
    token VARCHAR(150) NOT NULL,
    user_id SMALLINT NOT NULL,
    expires_at DATETIME NOT NULL,
    CONSTRAINT FOREIGN KEY (user_id) REFERENCES `User`(id)
);

END $$
DELIMITER ;
-- Runs the Procedure
CALL create_TokenTable_040();