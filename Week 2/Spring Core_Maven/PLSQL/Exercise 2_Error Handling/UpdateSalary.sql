-- Scenario 2: Manage errors when updating employee salaries.
-- Question: Write a stored procedure UpdateSalary that increases the salary of an employee by a given percentage. If the employee ID does not exist, handle the exception and log an error message.

CREATE OR REPLACE PROCEDURE UpdateSalary (emp_ID NUMBER,per NUMBER)  
IS 
BEGIN  
    UPDATE Employees  
    SET Salary = Salary * (1 + per / 100) WHERE EmployeeID = emp_id; 
    DBMS_OUTPUT.PUT_LINE('Updated salary of Employee ID '||emp_id); 
	
	IF SQL%ROWCOUNT = 0 THEN
        RAISE no_data_found;
	END IF;

	EXCEPTION
        WHEN no_data_found THEN
        	DBMS_OUTPUT.PUT_LINE('Employee ID '||emp_id ||' could not be found');
	WHEN OTHERS THEN
        	DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END UpdateSalary;
/