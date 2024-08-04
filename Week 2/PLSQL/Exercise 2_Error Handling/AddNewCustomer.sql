-- Scenario 3: Ensure data integrity when adding a new customer.
-- Question: Write a stored procedure AddNewCustomer that inserts a new customer into the Customers table. If a customer with the same ID already exists, handle the exception by logging an error and preventing the insertion.

CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customerID IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
) IS
BEGIN
    INSERT INTO Customers VALUES (p_customerID, p_name, p_dob, p_balance, SYSDATE);
    
	EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
        	DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_customerID || ' already exists.');
        WHEN OTHERS THEN
        	DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END AddNewCustomer;
/