package com.dinkark.androidtesting.unit.testdouble.mockito;

import com.dinkark.androidtesting.unit.testdouble.Customer;
import com.dinkark.androidtesting.unit.testdouble.Employee;
import com.dinkark.androidtesting.unit.testdouble.EmployeeDAO;
import com.dinkark.androidtesting.unit.testdouble.EmployeeService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by dinkark on 13/09/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTestDummy {
    Customer customer;
    EmployeeService employeeService;
    @Mock
    Employee employeeDummy;
    @Mock
    EmployeeDAO employeeDAODummy;

    @Before
    public void setup(){
        employeeService = new EmployeeService(employeeDummy, employeeDAODummy);
        customer= new Customer();
    }

    @Test
    public void checkIfCustomerLocal(){
         assertFalse(customer.isLocal());
        employeeService.makeCustomerLocal(customer);
        assertTrue(customer.isLocal());
    }
    @After
    public void cleanup(){
        employeeService=null;
        customer=null;

    }

}
