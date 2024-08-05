-- Scenario 1: Generate monthly statements for all customers.
-- Question: Write a PL/SQL block using an explicit cursor GenerateMonthlyStatements that retrieves all transactions for the current month and prints a statement for each customer.

DECLARE
    CURSOR cur_customers IS
        SELECT CustomerID, Name
        FROM Customers;
        
    CURSOR cur_transactions (p_customerID NUMBER) IS
        SELECT TransactionID, AccountID, TransactionDate, Amount, TransactionType
        FROM Transactions
        WHERE AccountID IN (SELECT AccountID FROM Accounts WHERE CustomerID = p_customerID)
          AND TRUNC(TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');
          
    v_customerID Customers.CustomerID%TYPE;
    v_customerName Customers.Name%TYPE;
    v_transactionID Transactions.TransactionID%TYPE;
    v_accountID Transactions.AccountID%TYPE;
    v_transactionDate Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_transactionType Transactions.TransactionType%TYPE;
    
BEGIN
    OPEN cur_customers;
    LOOP
        FETCH cur_customers INTO v_customerID, v_customerName;
        EXIT WHEN cur_customers%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Monthly Statement for Customer: ' || v_customerName);
        DBMS_OUTPUT.PUT_LINE('-------------------------------------------');
        
        OPEN cur_transactions(v_customerID);
        LOOP
            FETCH cur_transactions INTO v_transactionID, v_accountID, v_transactionDate, v_amount, v_transactionType;
            EXIT WHEN cur_transactions%NOTFOUND;
            
            DBMS_OUTPUT.PUT_LINE('Transaction ID: ' || v_transactionID || 
                                 ', Account ID: ' || v_accountID || 
                                 ', Date: ' || TO_CHAR(v_transactionDate, 'DD-MON-YYYY') || 
                                 ', Amount: ' || v_amount || 
                                 ', Type: ' || v_transactionType);
        END LOOP;
        CLOSE cur_transactions;
        
        DBMS_OUTPUT.PUT_LINE('-------------------------------------------');
    END LOOP;
    CLOSE cur_customers;
END;
/