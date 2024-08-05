-- Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
-- Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.

DECLARE
	v_age NUMBER;
BEGIN
	FOR cus IN (SELECT customerID, DOB FROM Customers) LOOP
		v_age := TRUNC(MONTHS_BETWEEN(sysdate,cus.DOB)/12);
		IF v_age > 60 THEN
			UPDATE Loans
			SET interestrate = interestrate * 0.99
			WHERE customerID = cus.CustomerID;
		END IF;
	END LOOP;
COMMIT;
END;
/