package lk.sliit.project.employeeManagement.dto;

import lk.sliit.project.employeeManagement.entity.Employee;

/**
 * @author: Chanuka
 * Date: 14-Apr-20
 */

//Class SalaryDTO
public class SalaryDTO {

    private String SalaryId;
    private double basicSalary;
    private double otHours;
    private double otRate;
    private double bonus;
    private double incomeTax;
    private Employee employeeID;

    //No Arg Constructor
    public SalaryDTO() {}

    //Full Arg Constructor
    public SalaryDTO(String salaryId, double basicSalary, double otHours, double otRate, double bonus, double incomeTax, Employee employeeID) {
        SalaryId = salaryId;
        this.basicSalary = basicSalary;
        this.otHours = otHours;
        this.otRate = otRate;
        this.bonus = bonus;
        this.incomeTax = incomeTax;
        this.employeeID = employeeID;
    }//End Full Arg

    //Getters And Setters
    public String getSalaryId() {
        return SalaryId;
    }

    public void setSalaryId(String salaryId) {
        SalaryId = salaryId;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getOtHours() {
        return otHours;
    }

    public void setOtHours(double otHours) {
        this.otHours = otHours;
    }

    public double getOtRate() {
        return otRate;
    }

    public void setOtRate(double otRate) {
        this.otRate = otRate;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
    }

    @Override  // Override to-String Method
    public String toString() {
        return "Salary{" +
                "SalaryId='" + SalaryId + '\'' +
                ", basicSalary=" + basicSalary +
                ", otHours=" + otHours +
                ", otRate=" + otRate +
                ", bonus=" + bonus +
                ", incomeTax=" + incomeTax +
                ", employeeID=" + employeeID +
                '}';
    }//End to-String
}//End DTO
