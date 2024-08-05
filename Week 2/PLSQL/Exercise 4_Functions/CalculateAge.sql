-- Scenario 1: Calculate the age of customers for eligibility checks.
-- Question: Write a function CalculateAge that takes a customer's date of birth as input and returns their age in years.

CREATE OR REPLACE FUNCTION CalculateAge (p_dob DATE) RETURN NUMBER 
IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END CalculateAge;

BEGIN
	DBMS_OUTPUT.PUT_LINE('Age is ' || CalculateAge('20-JUL-1990'));
END;
/