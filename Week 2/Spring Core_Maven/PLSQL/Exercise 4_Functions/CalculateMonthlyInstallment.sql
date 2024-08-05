-- Scenario 2: The bank needs to compute the monthly installment for a loan.
-- Question: Write a function CalculateMonthlyInstallment that takes the loan amount, interest rate, and loan duration in years as input and returns the monthly installment amount.

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (p_loanAmt NUMBER,p_iRate NUMBER,p_durInYears NUMBER) 
RETURN NUMBER
IS
    v_r NUMBER;
    v_n NUMBER;
    v_monthlyInstallment NUMBER;
BEGIN
    v_r := p_iRate / 12 / 100;	-- rate per month
    v_n := p_durInYears * 12;

	v_monthlyInstallment := p_loanAmt * v_r * ((1 + v_r) ** v_n) / ((1 + v_r) ** v_n - 1);
    RETURN v_monthlyInstallment;
END CalculateMonthlyInstallment;
/