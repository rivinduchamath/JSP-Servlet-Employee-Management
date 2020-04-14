package lk.sliit.project.employeeManagement.dto;

import lk.sliit.project.employeeManagement.entity.Employee;

import javax.persistence.Column;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 14-Apr-20
 */
public class SalaryDTO {
    private int salaryId;
    private double salary;
    private double totalOtHours;
    private String fullPayment;
    private EmployeeDTO employee;
    public SalaryDTO(){}
    public SalaryDTO(int salaryId, double salary, double totalOtHours, String fullPayment, EmployeeDTO employee) {
        this.salaryId = salaryId;
        this.salary = salary;
        this.totalOtHours = totalOtHours;
        this.fullPayment = fullPayment;
        this.employee = employee;
    }



    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTotalOtHours() {
        return totalOtHours;
    }

    public void setTotalOtHours(double totalOtHours) {
        this.totalOtHours = totalOtHours;
    }

    public String getFullPayment() {
        return fullPayment;
    }

    public void setFullPayment(String fullPayment) {
        this.fullPayment = fullPayment;
    }


    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "SalaryDTO{" +
                "salaryId=" + salaryId +
                ", salary=" + salary +
                ", totalOtHours=" + totalOtHours +
                ", fullPayment='" + fullPayment + '\'' +
                ", employee=" + employee +
                '}';
    }

}
