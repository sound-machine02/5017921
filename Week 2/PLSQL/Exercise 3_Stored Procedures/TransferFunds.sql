-- Scenario 3: Customers should be able to transfer funds between their accounts.
-- Question: Write a stored procedure TransferFunds that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.

CREATE OR REPLACE PROCEDURE TransferFunds 
    (p_fromAccountID IN NUMBER,p_toAccountID IN NUMBER,p_amount IN NUMBER) 
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_fromAccountID;
    
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
    END IF;
    
    UPDATE Accounts
    SET Balance = Balance - p_amount,LastModified = SYSDATE WHERE AccountID = p_fromAccountID;
    
    UPDATE Accounts
    SET Balance = Balance + p_amount,LastModified = SYSDATE WHERE AccountID = p_toAccountID;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END TransferFunds;
/