package com.dinkark.androidtesting.unit.testdouble;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.verify;

/**
 * Created by dinkark on 13/09/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTestSpy {

    EmployeeService employeeService;
    
    @Mock
    Employee employeeDummy;
    @Spy
    EmployeeDAO employeeDAOSpy;

    @Mock
    Customer customerDummy;

    @Before
    public void setup(){
        employeeService = new EmployeeService(employeeDummy, employeeDAOSpy);

    }

    @Test
    public void checkCreateCustomer(){
        employeeService.createCustomer(customerDummy);
        verify(employeeDAOSpy).saveCustomer(customerDummy);
        assertTrue(employeeDAOSpy.isSaveCustomerCalled);
    }
    @After
    public void cleanup(){
        employeeService=null;
        assertNull(employeeService);
    }
}