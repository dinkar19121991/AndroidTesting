package com.dinkark.androidtesting.unit.testdouble;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by dinkark on 13/09/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTestMock {
    EmployeeService employeeService;
    @Mock
    Employee employeeDummy;
    @Mock
    EmployeeDAO employeeDAODummy;
    @Mock
    Customer customerDummy;
    @Before
    public void setup(){
        employeeService = new EmployeeService(employeeDummy, employeeDAODummy);
    }
    @Test
    public void checkCreateCustomer(){

         employeeService.createCustomer(customerDummy);
        verify(employeeDAODummy).saveCustomer(customerDummy);
        verify(employeeDAODummy,never()).isAuthorizedEmployee(employeeDummy);
    }

    @After
    public void cleanup(){
        employeeService=null;
        assertNull(employeeService);
    }

}