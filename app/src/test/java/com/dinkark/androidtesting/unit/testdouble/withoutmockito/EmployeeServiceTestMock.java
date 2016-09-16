package com.dinkark.androidtesting.unit.testdouble.withoutmockito;

import com.dinkark.androidtesting.unit.testdouble.Customer;
import com.dinkark.androidtesting.unit.testdouble.Employee;
import com.dinkark.androidtesting.unit.testdouble.EmployeeService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


/**
 * Created by dinkark on 13/09/16.
 */

public class EmployeeServiceTestMock {
    EmployeeService employeeService;

    Employee employeeDummy=null;

    EmployeeDAOMock employeeDAOMock;

    Customer customerDummy=null;
    @Before
    public void setup(){
        employeeDAOMock= new EmployeeDAOMock();
        employeeService = new EmployeeService(employeeDummy, employeeDAOMock);
    }
    @Test
    public void checkCreateCustomer(){

         employeeService.createCustomer(customerDummy);
        assertTrue(employeeDAOMock.isSaveCustomerCalled());

        assertFalse(employeeDAOMock.isAutorizedEmployeeCalled());

    }

    @After
    public void cleanup(){
        employeeService=null;
    }

}