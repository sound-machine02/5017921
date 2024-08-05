-- Scenario 1: Handle exceptions during fund transfers between accounts.
-- Question: Write a stored procedure SafeTransferFunds that transfers funds between two accounts. Ensure that if any error occurs (e.g., insufficient funds), an appropriate error message is logged and the transaction is rolled back.

CREATE OR REPLACE PROCEDURE SafeTransferFunds 
(p_fromAccountID IN NUMBER,p_toAccountID IN NUMBER,p_amount IN NUMBER) 
IS
    v_balance NUMBER;
BEGIN
    -- Check balance of fromAccount
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_fromAccountID;
    
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
    END IF;
    
    -- Deduct amount from fromAccount
    UPDATE Accounts SET Balance = Balance - p_amount, LastModified = SYSDATE
    WHERE AccountID = p_fromAccountID;
    
    -- Add amount to toAccount
    UPDATE Accounts SET Balance = Balance + p_amount, LastModified = SYSDATE
    WHERE AccountID = p_toAccountID;
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
        RAISE;
END SafeTransferFunds;
/