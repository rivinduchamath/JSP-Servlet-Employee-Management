package lk.sliit.project.employeeManagement.dto;


/**
 * @author: Rivindu-Wijayarathna
 * Date: 14-Apr-20
 */
//Class SalaryDTO
public class SalaryDTO {
    private int salaryId;
    private double salary;
    private double totalOtHours;
    private String fullPayment;
    private String employeeName;
    private String employeeID;

    //Constructor
    public SalaryDTO(int salaryId, double salary, double totalOtHours, String fullPayment, String employee) {
        this.salaryId = salaryId;
        this.salary = salary;
        this.totalOtHours = totalOtHours;
        this.fullPayment = fullPayment;
        this.employeeID = employee;
    }

    //Default Constructor
    public SalaryDTO() {}

    //Full-arg  Constructor
    public SalaryDTO(int salaryId, String fullPayment, double salary, double totalOtHours, String employeeID, String employeeName) {
        this.salaryId = salaryId;
        this.salary = salary;
        this.totalOtHours = totalOtHours;
        this.fullPayment = fullPayment;
        this.employeeID = employeeID;
        this.employeeName =employeeName;
    }//End Full Arg

    //Getters And Setters
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
        return employeeID;
    }

    public void setEmployee(String employee) {
        this.employeeID = employee;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    // Override to String
    @Override
    public String toString() {
        return "SalaryDTO{" +
                "salaryId=" + salaryId +
                ", salary=" + salary +
                ", totalOtHours=" + totalOtHours +
                ", fullPayment='" + fullPayment + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeID=" + employeeID +
                '}';
    }//End ToString
}//End Class DTO
