USE Team1_RyanB;
DELIMITER $$
DROP PROCEDURE IF EXISTS create_TokenTable_040 $$
CREATE PROCEDURE create_TokenTable_040()
BEGIN

CREATE TABLE IF NOT EXISTS Token (
    id INT NOT NULL AUTO_INCREMENT,
    token VARCHAR(50) NOT NULL,
    user_id INT NOT NULL,
    expires_at DATETIME NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (user_id) REFERENCES User(id)
);

END $$
DELIMITER ;
-- Runs the Procedure
CALL create_TokenTable_040();