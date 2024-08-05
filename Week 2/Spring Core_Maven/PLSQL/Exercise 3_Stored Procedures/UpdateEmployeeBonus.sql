-- Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
-- Question: Write a stored procedure UpdateEmployeeBonus that updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (p_department IN VARCHAR2, p_bonusPercentage IN NUMBER) 
IS
    v_newSalary NUMBER;
BEGIN
    FOR emp_rec IN (SELECT EmployeeID, Salary FROM Employees WHERE Department = p_department) LOOP
        v_newSalary := emp_rec.Salary * (1 + p_bonusPercentage / 100);
        
        UPDATE Employees
        SET Salary = v_newSalary 
        WHERE EmployeeID = emp_rec.EmployeeID;
    END LOOP;
END UpdateEmployeeBonus;
/