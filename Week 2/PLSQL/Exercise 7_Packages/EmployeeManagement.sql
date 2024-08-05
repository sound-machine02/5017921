-- Scenario 2: Create a package to manage employee data.
-- Question: Write a package EmployeeManagement with procedures to hire new employees, update employee details, and a function to calculate annual salary.

CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(
        p_employeeID IN NUMBER,
        p_name IN VARCHAR2,
        p_position IN VARCHAR2,
        p_salary IN NUMBER,
        p_department IN VARCHAR2,
        p_hireDate IN DATE
    );

    PROCEDURE UpdateEmployeeDetails(
        p_employeeID IN NUMBER,
        p_name IN VARCHAR2,
        p_position IN VARCHAR2,
        p_salary IN NUMBER,
        p_department IN VARCHAR2,
        p_hireDate IN DATE
    );

    FUNCTION CalculateAnnualSalary(p_employeeID IN NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee(
        p_employeeID IN NUMBER,
        p_name IN VARCHAR2,
        p_position IN VARCHAR2,
        p_salary IN NUMBER,
        p_department IN VARCHAR2,
        p_hireDate IN DATE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_employeeID, p_name, p_position, p_salary, p_department, p_hireDate);
        
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_customerID || ' already exists.');

    END HireEmployee;

    PROCEDURE UpdateEmployeeDetails(
        p_employeeID IN NUMBER,
        p_name IN VARCHAR2,
        p_position IN VARCHAR2,
        p_salary IN NUMBER,
        p_department IN VARCHAR2,
        p_hireDate IN DATE
    ) IS
    BEGIN
        UPDATE Employees
        SET Name = p_name,
            Position = p_position,
            Salary = p_salary,
            Department = p_department,
            HireDate = p_hireDate,
            LastModified = SYSDATE
        WHERE EmployeeID = p_employeeID;
        
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);

    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary(p_employeeID IN NUMBER) RETURN NUMBER 
    IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_employeeID;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
        WHEN OTHERS THEN
            RETURN NULL;
    END CalculateAnnualSalary;
END EmployeeManagement;
/