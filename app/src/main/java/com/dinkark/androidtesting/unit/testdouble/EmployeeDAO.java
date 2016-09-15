package com.dinkark.androidtesting.unit.testdouble;

/**
 * Created by dinkark on 13/09/16.
 */
public class EmployeeDAO implements IEmployeeDAO {

    public boolean isSaveCustomerCalled=false;

    @Override
    public void saveCustomer(Customer customer){

        isSaveCustomerCalled=true;
    }
    @Override
    public boolean isAuthorizedEmployee(Employee employee){
        try {
            Thread.sleep(10000);
            return employee.getName().equalsIgnoreCase("dk");
        } catch (InterruptedException e) {

            return false;
        }

    }

    @Override
    public boolean isEmployeeAdmin(Employee employee) {
        return employee.isAdmin();
    }
}
