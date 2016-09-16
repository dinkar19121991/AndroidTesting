package com.dinkark.androidtesting.unit.testdouble.withoutmockito;

import com.dinkark.androidtesting.unit.testdouble.Customer;
import com.dinkark.androidtesting.unit.testdouble.Employee;
import com.dinkark.androidtesting.unit.testdouble.IEmployeeDAO;

/**
 * Created by dinkark on 15/09/16.
 */
public class EmployeeDAOStub implements IEmployeeDAO {
    @Override
    public boolean isAuthorizedEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean isEmployeeAdmin(Employee employee) {
        return true;
    }

    @Override
    public void saveCustomer(Customer customer) {

    }
}
