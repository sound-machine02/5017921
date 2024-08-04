-- Scenario 2: A customer can be promoted to VIP status based on their balance.
-- Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.

ALTER TABLE Customers ADD (IsVIP CHAR(1) DEFAULT 'F');
BEGIN
    UPDATE Customers
    SET IsVIP = 'Y', LastModified = SYSDATE
    WHERE Balance > 10000;
    
    COMMIT;
END;
/