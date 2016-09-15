package com.dinkark.androidtesting.unit.testdouble.mockito;

import com.dinkark.androidtesting.unit.testdouble.Customer;
import com.dinkark.androidtesting.unit.testdouble.Employee;
import com.dinkark.androidtesting.unit.testdouble.EmployeeDAO;
import com.dinkark.androidtesting.unit.testdouble.EmployeeService;
import com.dinkark.androidtesting.unit.testdouble.IEmployeeDAO;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by dinkark on 13/09/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTestFake {
    EmployeeService employeeService;
    @Mock
    Employee employeeStub;
    @Spy
    EmployeeDAO employeeDAOSpy;

    IEmployeeDAO fakeEmployeeDAO;

    @Mock
    Customer customerDummy;

    @Test
    public void checkAuthorizedEmployeeWithoutFake() {
        when(employeeStub.getName()).thenReturn("dk");
        employeeService = new EmployeeService(employeeStub, employeeDAOSpy);
        assertTrue(employeeService.authorizedEmployee(employeeStub));
    }

    @Test
    public void checkAuthorizedEmployeeWithFake() {
        fakeEmployeeDAO= new FakeEmployeeDAO();
        when(employeeStub.getName()).thenReturn("dk");
        employeeService = new EmployeeService(employeeStub, fakeEmployeeDAO);
        assertTrue(employeeService.authorizedEmployee(employeeStub));

    }
    @Test
    public void checkAuthorizedEmployeeWithoutFakeFalse() {
        when(employeeStub.getName()).thenReturn("pk");
        employeeService = new EmployeeService(employeeStub, employeeDAOSpy);
        assertFalse(employeeService.authorizedEmployee(employeeStub));
    }

    @Test
    public void checkAuthorizedEmployeeWithFakeFalse() {
        fakeEmployeeDAO= new FakeEmployeeDAO();
        when(employeeStub.getName()).thenReturn("pk");
        employeeService = new EmployeeService(employeeStub, fakeEmployeeDAO);
        assertFalse(employeeService.authorizedEmployee(employeeStub));

    }

    @After
    public void cleanup() {
        employeeService = null;

    }

}