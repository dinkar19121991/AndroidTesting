package com.dinkark.androidtesting.unit.testdouble;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertNull;
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
    @Spy
    FakeEmployeeDAO fakeEmployeeDAOSpy;
    @Mock
    Customer customerDummy;

    @Test
    public void checkAuthorizedEmployeeWithoutFake(){
        when(employeeStub.getName()).thenReturn("dk");
        employeeService = new EmployeeService(employeeStub, employeeDAOSpy);
        employeeService.authorizedEmployee(employeeStub);

    }
    @Test
    public void checkAuthorizedEmployeeWithFake(){
        when(employeeStub.getName()).thenReturn("dk");
        employeeService = new EmployeeService(employeeStub, fakeEmployeeDAOSpy);
        employeeService.authorizedEmployee(employeeStub);

    }
    @After
    public void cleanup(){
        employeeService=null;
        assertNull(employeeService);
    }

}