package com.dinkark.androidtesting.unit.testdouble.withoutmockito;

import com.dinkark.androidtesting.unit.testdouble.Customer;
import com.dinkark.androidtesting.unit.testdouble.Employee;
import com.dinkark.androidtesting.unit.testdouble.IEmployeeDAO;

/**
 * Created by dinkark on 15/09/16.
 */
public class EmployeeDAOMock implements IEmployeeDAO {
    boolean isSaveCustomerCalled=false;
    boolean isIsAutorizedEmployeeCalled=false;

    @Override
    public boolean isAuthorizedEmployee(Employee employee) {
        isIsAutorizedEmployeeCalled=true;
        return false;
    }

    @Override
    public boolean isEmployeeAdmin(Employee employee) {

        return false;
    }

    @Override
    public void saveCustomer(Customer customer) {
        isSaveCustomerCalled=true;
        System.out.println("saveCustomer is called");
    }

    public boolean isSaveCustomerCalled() {
        return isSaveCustomerCalled;
    }

    public void setSaveCustomerCalled(boolean saveCustomerCalled) {
        isSaveCustomerCalled = saveCustomerCalled;
    }

    public boolean isAutorizedEmployeeCalled() {
        return isIsAutorizedEmployeeCalled;
    }

    public void setIsAutorizedEmployeeCalled(boolean isAutorizedEmployeeCalled) {
        isIsAutorizedEmployeeCalled = isAutorizedEmployeeCalled;
    }
}
