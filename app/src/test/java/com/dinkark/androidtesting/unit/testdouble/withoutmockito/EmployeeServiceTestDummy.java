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

public class EmployeeServiceTestDummy {
    Customer customer;
    EmployeeService employeeService;

    Employee employeeDummy = null;

    EmployeeDAO employeeDAODummy = null;

     @Before
    public void setup() {
        employeeService = new EmployeeService(employeeDummy, employeeDAODummy);
        customer = new Customer();
    }

    @Test
    public void checkMakeCustomerLocal() {
        assertFalse(customer.isLocal());
        employeeService.makeCustomerLocal(customer);
        assertTrue(customer.isLocal());
    }

    @Test
    public void checkifCustomerLocal() {
        assertFalse(customer.isLocal());

    }

    @After
    public void cleanup() {
        employeeService = null;
        customer = null;

    }


}
