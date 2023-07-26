USE Team1_RyanB;
DELIMITER $$
DROP PROCEDURE IF EXISTS add_capabilityTestData_003 $$
CREATE PROCEDURE add_capabilityTestData_003()
BEGIN

START TRANSACTION;

-- Insert test data into Capability table
INSERT INTO Capability(`name`)
VALUES('Engineering'),
('Workday'),
('Operations'),
('Commercial and Financial Management'),
('Platforms'),
('Experience Design'),
('Business Development and Marketing'),
('Business Services Support'),
('Data and Artificial Intelligence'),
('Product'),
('Organisational Strategy and Planning'),
('Cyber Security'),
('Delivery'),
('People');

-- Insert Capability IDs into Job_Roles table
UPDATE Job_Roles
SET capability_id = 1
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