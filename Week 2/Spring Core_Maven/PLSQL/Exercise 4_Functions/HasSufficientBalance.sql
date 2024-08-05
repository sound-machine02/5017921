-- Scenario 3: Check if a customer has sufficient balance before making a transaction.
-- Question: Write a function HasSufficientBalance that takes an account ID and an amount as input and returns a boolean indicating whether the account has at least the specified amount.

CREATE OR REPLACE FUNCTION HasSufficientBalance(p_accID NUMBER,p_amt NUMBER)
RETURN BOOLEAN
IS
    v_balance NUMBER;
BEGIN
	SELECT balance INTO v_balance FROM Accounts WHERE accountid = p_accID;

	RETURN v_balance >= p_amt;
EXCEPTION
	WHEN no_data_found THEN
		RETURN FALSE;
	WHEN others THEN
		RETURN FALSE;
END HasSufficientBalance;
/