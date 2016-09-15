package com.dinkark.androidtesting.unit.testdouble.mockito;

import com.dinkark.androidtesting.unit.testdouble.Customer;
import com.dinkark.androidtesting.unit.testdouble.Employee;
import com.dinkark.androidtesting.unit.testdouble.IEmployeeDAO;

/**
 * Created by dinkark on 13/09/16.
 */
public class FakeEmployeeDAO implements IEmployeeDAO {
    @Override
    public boolean isAuthorizedEmployee(Employee employee) {
        return employee.getName().equalsIgnoreCase("dk");
    }

    @Override
    public boolean isEmployeeAdmin(Employee employee) {
        return false;
    }

    @Override
    public void saveCustomer(Customer customer) {

    }
}
