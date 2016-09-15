package com.dinkark.androidtesting.unit.testdouble;

/**
 * Created by dinkark on 13/09/16.
 */
public interface IEmployeeDAO {
     boolean isAuthorizedEmployee(Employee employee);

     boolean isEmployeeAdmin(Employee employee);

     void saveCustomer(Customer customer);
}
