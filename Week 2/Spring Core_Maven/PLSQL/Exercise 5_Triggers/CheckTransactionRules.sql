-- Scenario 3: Enforce business rules on deposits and withdrawals.
-- Question: Write a trigger CheckTransactionRules that ensures withdrawals do not exceed the balance and deposits are positive before inserting a record into the Transactions table.

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :NEW.AccountID;
    
    IF :NEW.TransactionType = 'Withdrawal' THEN
        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for withdrawal.');
        END IF;

    ELSIF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
        END IF;
        
    ELSE
        RAISE_APPLICATION_ERROR(-20003, 'Invalid transaction type.');
    END IF;
END CheckTransactionRules;
/