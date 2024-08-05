-- Scenario 2: Apply annual fee to all accounts.
-- Question: Write a PL/SQL block using an explicit cursor ApplyAnnualFee that deducts an annual maintenance fee from the balance of all accounts.

DECLARE
    CURSOR cur_accounts IS SELECT AccountID, Balance FROM Accounts;
    
    v_accountID Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_annualFee CONSTANT NUMBER := 50; -- Annual maintenance fee
    
BEGIN
    OPEN cur_accounts;
    LOOP
        FETCH cur_accounts INTO v_accountID, v_balance;
        EXIT WHEN cur_accounts%NOTFOUND;
        
        UPDATE Accounts
        SET Balance = v_balance - v_annualFee, LastModified = SYSDATE
        WHERE AccountID = v_accountID;
    END LOOP;
    CLOSE cur_accounts;
    
END;
/