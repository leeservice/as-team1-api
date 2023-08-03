USE Team1_RyanB;
DELIMITER $$
DROP PROCEDURE IF EXISTS add_roleTestData_040 $$
CREATE PROCEDURE add_roleTestData_040()
BEGIN

START TRANSACTION;

INSERT INTO Role(id, `name`)
VALUES (1, 'Administrator'),
(2, 'User');


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
CALL add_roleTestData_040();