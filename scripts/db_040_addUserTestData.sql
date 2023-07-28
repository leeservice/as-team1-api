USE Team1_RyanB;
DELIMITER $$
DROP PROCEDURE IF EXISTS add_userTestData_040 $$
CREATE PROCEDURE add_userTestData_040()
BEGIN

START TRANSACTION;

INSERT INTO User(id, email, `password`, role_id)
VALUES (1, 'admin@kainos.com', 'admin', 1),
(2, 'user@kainos.com', 'user', 2);

-- Check the number of affected rows
GET DIAGNOSTICS @rows = ROW_COUNT;
IF @rows = 0 THEN ROLLBACK;
SELECT 'Transaction rolled back due to error.';
ELSE -- If no error occurred. commit the transaction
COMMIT;
SELECT 'Transaction committed successfully.';
END IF;

END $$
DELIMITER ;

-- Runs the Procedure
CALL add_userTestData_040();