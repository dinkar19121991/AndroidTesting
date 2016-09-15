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
import static org.mockito.Mockito.when;

/**
 * Created by dinkark on 13/09/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTestStub {
    Customer customer;
    EmployeeService employeeService;
    @Mock
    Employee employeeDummy;
    @Mock
    EmployeeDAO employeeDAOStub;
    @Before
    public void setup(){
        employeeService = new EmployeeService(employeeDummy, employeeDAOStub);
        customer= new Customer();
    }

    @Test
    public void checkIfCustomerPremium(){
        when(employeeDAOStub.isEmployeeAdmin(employeeDummy)).thenReturn(true);
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