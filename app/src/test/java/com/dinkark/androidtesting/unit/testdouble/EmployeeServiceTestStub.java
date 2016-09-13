package com.dinkark.androidtesting.unit.testdouble;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNull;
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
    Employee employeeStub;
    @Mock
    EmployeeDAO employeeDAODummy;
    @Before
    public void setup(){
        employeeService = new EmployeeService(employeeStub, employeeDAODummy);
        customer= new Customer();
    }

    @Test
    public void checkIfCustomerPremium(){
        when(employeeStub.isAdmin()).thenReturn(true);
        assertFalse(customer.isPremium());
        employeeService.makeCustomerPremium(customer);
        assertTrue(customer.isPremium());
    }
    @After
    public void cleanup(){
        employeeService=null;
        customer=null;
        assertNull(employeeService);
        assertNull(customer);
    }
}