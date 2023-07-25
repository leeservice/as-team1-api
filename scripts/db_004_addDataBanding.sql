USE Team1_RyanB;
DELIMITER $$
DROP PROCEDURE IF EXISTS add_capabilityTestData_003 $$
CREATE PROCEDURE add_capabilityTestData_003()
BEGIN

START TRANSACTION;

-- Insert test data into Capability table
INSERT INTO Banding(`level_of_band`)
VALUES('Manager'),
('Executive');
INSERT INTO Banding(`training_available`)
VALUES('Yes'),
('No');

-- Insert Capability IDs into Job_Roles table
UPDATE Job_Roles
SET band_id = 1
WHERE id > 0 AND id <= 15;

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
CALL add_capabilityTestData_003();