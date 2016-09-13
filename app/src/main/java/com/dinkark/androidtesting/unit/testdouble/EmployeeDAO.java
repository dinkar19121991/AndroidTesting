package com.dinkark.androidtesting.unit.testdouble;

/**
 * Created by dinkark on 13/09/16.
 */
public class EmployeeDAO implements IEmployeeDAO{

    boolean isSaveCustomerCalled=false;

    @Override
    public void saveCustomer(Customer customer){

        isSaveCustomerCalled=true;
    }
    @Override
    public boolean isAuthorizedEmployee(Employee employee){
        try {
            Thread.sleep(10000);
            if(employee.getName().equalsIgnoreCase("dk")){
                return true;
            }
            else{
                return false;
            }
        } catch (InterruptedException e) {

            return false;
        }

    }
}
