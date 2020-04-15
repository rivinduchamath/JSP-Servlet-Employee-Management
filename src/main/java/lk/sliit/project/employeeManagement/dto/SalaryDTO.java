package lk.sliit.project.employeeManagement.dto;


/**
 * @author: Rivindu-Wijayarathna
 * Date: 14-Apr-20
 */
public class SalaryDTO {
    private int salaryId;
    private double salary;
    private double totalOtHours;
    private String fullPayment;
    private String employeeName;
    private String employee;

    public SalaryDTO(int salaryId, double salary, double totalOtHours, String fullPayment, String employee) {
        this.salaryId = salaryId;
        this.salary = salary;
        this.totalOtHours = totalOtHours;
        this.fullPayment = fullPayment;
        this.employee = employee;
    }

    public SalaryDTO() {}

    public SalaryDTO(int salaryId, String fullPayment, double salary, double totalOtHours, String employeeID, String employeeName) {
        this.salaryId = salaryId;
        this.salary = salary;
        this.totalOtHours = totalOtHours;
        this.fullPayment = fullPayment;
        this.employee = employeeID;
        this.employeeName =employeeName;
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

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "SalaryDTO{" +
                "salaryId=" + salaryId +
                ", salary=" + salary +
                ", totalOtHours=" + totalOtHours +
                ", fullPayment='" + fullPayment + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employee=" + employee +
                '}';
    }
}
