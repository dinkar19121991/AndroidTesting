package com.dinkark.androidtesting.unit.testdouble;

/**
 * Created by dinkark on 13/09/16.
 */
public interface IEmployeeDAO {
    public boolean isAuthorizedEmployee(Employee employee);
    public void saveCustomer(Customer customer);
}
