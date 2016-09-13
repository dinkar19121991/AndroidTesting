package com.dinkark.androidtesting.unit.testdouble;

/**
 * Created by dinkark on 13/09/16.
 */
public class EmployeeService {
    Employee employee;
    IEmployeeDAO employeeDAO;

    public EmployeeService(Employee employee, IEmployeeDAO employeeDAO) {
        this.employee = employee;
        this.employeeDAO = employeeDAO;
    }
    public void makeCustomerPremium(Customer customer){
        if(employee.isAdmin()){
            customer.setPremium(true);
        }

    }
    public void makeCustomerLocal(Customer customer){

            customer.setLocal(true);


    }
    public void createCustomer(Customer customer){
      employeeDAO.saveCustomer(customer);

    }
    public boolean authorizedEmployee(Employee employee){
        return employeeDAO.isAuthorizedEmployee(employee);
    }
}
