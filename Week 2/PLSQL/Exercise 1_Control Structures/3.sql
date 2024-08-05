-- Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
-- Question: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.

DECLARE
    v_customerName Customers.Name%TYPE;
BEGIN
    FOR loan_rec IN (
        SELECT LoanID, CustomerID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        SELECT Name INTO v_customerName
        FROM Customers
        WHERE CustomerID = loan_rec.CustomerID;
        
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_customerName || ', your loan (ID: ' || loan_rec.LoanID || ') is due on ' || TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY') || '.');
    END LOOP;
END;
/