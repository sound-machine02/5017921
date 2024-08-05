-- Scenario 3: Update the interest rate for all loans based on a new policy.
-- Question: Write a PL/SQL block using an explicit cursor UpdateLoanInterestRates that fetches all loans and updates their interest rates based on the new policy.

DECLARE
    CURSOR cur_loans IS SELECT LoanID, InterestRate FROM Loans;
        
    v_loanID Loans.LoanID%TYPE;
    v_interestRate Loans.InterestRate%TYPE;
    v_newInterestRate CONSTANT NUMBER := 6.5;
    
BEGIN
    OPEN cur_loans;
    LOOP
        FETCH cur_loans INTO v_loanID, v_interestRate;
        EXIT WHEN cur_loans%NOTFOUND;
        
        UPDATE Loans
        SET InterestRate = v_newInterestRate WHERE LoanID = v_loanID;
    END LOOP;
    CLOSE cur_loans;
END;
/