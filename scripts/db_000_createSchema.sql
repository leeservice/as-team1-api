DELIMITER $$ 
DROP PROCEDURE IF EXISTS create_schema_000 $$ 
CREATE PROCEDURE create_schema_000() 
BEGIN
START TRANSACTION;
-- Drop if exists
DROP DATABASE IF EXISTS Team1_RyanB;
-- Create database
CREATE DATABASE Team1_RyanB;

-- Check the number of affected rows
GET DIAGNOSTICS @rows = ROW_COUNT;
IF @rows = 0 THEN ROLLBACK;
SELECT '000 Create Schema - rolled back due to error.';
ELSE -- If no error occurred. commit the transaction
COMMIT;
SELECT '000 Create Schema - committed successfully.';
END IF;
END $$ 
DELIMITER ;

-- Runs the Procedure
CALL create_schema_000();