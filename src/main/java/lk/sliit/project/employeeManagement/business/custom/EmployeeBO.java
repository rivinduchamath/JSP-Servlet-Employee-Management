package lk.sliit.project.employeeManagement.business.custom;

import lk.sliit.project.employeeManagement.business.CrudBO;
import lk.sliit.project.employeeManagement.entity.Employee;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 08-Mar-20
 */
public interface EmployeeBO extends CrudBO {
    String getLastUserCode() ;

    boolean exists(String i);

    public Employee findByIdNoAndPassword(String idNo, String password);

    Employee getEmployeeByIdNo(String idNo);
}
