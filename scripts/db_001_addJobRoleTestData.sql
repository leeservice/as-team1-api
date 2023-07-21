USE Team1_RyanB;
DELIMITER $$ 
DROP PROCEDURE IF EXISTS add_jobRoleTestData_001 $$ 
CREATE PROCEDURE add_jobRoleTestData_001() 
BEGIN

START TRANSACTION;

INSERT INTO Job_Roles(`name`)
VALUES('Technology Leader'),
('Principal Architect'),
('Principal Test Architect'),
('Solution Architect'),
('Test Architect');




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
CALL add_jobRoleTestData_001();