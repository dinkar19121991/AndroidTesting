package com.dinkark.androidtesting.unit.testdouble.withoutmockito;

import com.dinkark.androidtesting.unit.testdouble.Customer;
import com.dinkark.androidtesting.unit.testdouble.Employee;
import com.dinkark.androidtesting.unit.testdouble.EmployeeService;
import com.dinkark.androidtesting.unit.testdouble.IEmployeeDAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by dinkark on 13/09/16.
 */

public class EmployeeServiceTestStub {
    Customer customer;
    EmployeeService employeeService;

    Employee employeeDummy=null;

    IEmployeeDAO employeeDAOStub;

    @Before
    public void setup(){
        employeeDAOStub= new EmployeeDAOStub();
        employeeService = new EmployeeService(employeeDummy, employeeDAOStub);
        customer= new Customer();
    }

    @Test
    public void checkIfCustomerPremium(){

        assertFalse(customer.isPremium());
        employeeService.makeCustomerPremium(customer);
        assertTrue(customer.isPremium());
    }
    @After
    public void cleanup(){
        employeeService=null;
        customer=null;

    }
}