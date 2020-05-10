package lk.sliit.project.employeeManagement.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 19-Mar-20
 */
@Entity//Entity Class Attendance
public class Attendance implements SuperEntity {

    @Id
    private String attendanceId;
    @Column(nullable = true)
    private double salary;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String inTime;
    private String outTime;
    @Column(columnDefinition = "double default 0")
    private double overtimeHours;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "employeeId", referencedColumnName = "idNo", nullable = true)
    private Employee employeeID;

    //No arg constructor
    public Attendance() {}

    //Add Full Arg Constructor
    public Attendance(String attendanceId, double salary, Date date,
                       String inTime, String outTime, double overtimeHours,
                       Employee employeeID) {
        this.attendanceId = attendanceId;
        this.salary = salary;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.overtimeHours = overtimeHours;
        this.employeeID = employeeID;
    }


//Getters And Setters
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public Employee getEmployee() { return employeeID; }

    public void setEmployee(Employee employeeID) {
        this.employeeID = employeeID;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
    }

    @Override//Override toString
    public String toString() {
        return "Attendance{" +
                "attendanceId=" + attendanceId +
                ", salary=" + salary +
                ", date=" + date +
                ", inTime='" + inTime + '\'' +
                ", outTime='" + outTime + '\'' +
                ", overtimeHours=" + overtimeHours +
                ", employeeID=" + employeeID +
                '}';
    }//End toString Method
}//End Class
