package com.dinkark.androidtesting.unit.testdouble.withoutmockito;

import com.dinkark.androidtesting.unit.testdouble.Employee;
import com.dinkark.androidtesting.unit.testdouble.EmployeeDAO;

/**
 * Created by dinkark on 15/09/16.
 */
public class EmployeeDAOSpy extends EmployeeDAO {

    @Override
    public boolean isAuthorizedEmployee(Employee employee) {
        return false;

    }

}
