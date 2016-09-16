package com.dinkark.androidtesting.unit.testdouble.withoutmockito;

import com.dinkark.androidtesting.unit.testdouble.Customer;
import com.dinkark.androidtesting.unit.testdouble.Employee;
import com.dinkark.androidtesting.unit.testdouble.EmployeeDAO;
import com.dinkark.androidtesting.unit.testdouble.EmployeeService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


/**
 * Created by dinkark on 13/09/16.
 */

public class EmployeeServiceTestSpy {

    EmployeeService employeeService;


    Employee employeeDummy = null;

    EmployeeDAO employeeDAOSpy;


    Customer customerDummy = null;

    @Before
    public void setup() {
        employeeDAOSpy = new EmployeeDAOSpy();
        employeeService = new EmployeeService(employeeDummy, employeeDAOSpy);

    }

    @Test
    public void checkCreateCustomer() {
        employeeService.createCustomer(customerDummy);
        assertTrue(employeeDAOSpy.isSaveCustomerCalled);
    }
    @Test
    public void checkIsEmployeeAuthorized() {

        assertFalse(employeeService.authorizedEmployee(employeeDummy));
    }
    @After
    public void cleanup() {
        employeeService = null;
    }
}