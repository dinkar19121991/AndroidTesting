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
    EmployeeDAO employeeDAOMock;
    @Mock
    Customer customerDummy;
    @Before
    public void setup(){
        employeeService = new EmployeeService(employeeDummy, employeeDAOMock);
    }
    @Test
    public void checkCreateCustomer(){

         employeeService.createCustomer(customerDummy);
        verify(employeeDAOMock).saveCustomer(customerDummy);
        verify(employeeDAOMock,never()).isAuthorizedEmployee(employeeDummy);
    }

    @After
    public void cleanup(){
        employeeService=null;

    }

}