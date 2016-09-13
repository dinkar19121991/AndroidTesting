package com.dinkark.androidtesting.unit.testdouble;

/**
 * Created by dinkark on 13/09/16.
 */
public class FakeEmployeeDAO implements IEmployeeDAO {
    @Override
    public boolean isAuthorizedEmployee(Employee employee) {
        if(employee.getName().equalsIgnoreCase("dk")){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void saveCustomer(Customer customer) {

    }
}
