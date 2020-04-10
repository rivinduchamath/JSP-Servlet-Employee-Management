package lk.sliit.project.employeeManagement.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 19-Mar-20
 */
@Entity
public class Attendance implements SuperEntity {

    @Id
    private int attendanceId;
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

    public Attendance() {}

    public Attendance(int attendanceId, double salary, Date date, String inTime, String outTime, double overtimeHours, Employee employeeID) {
        this.attendanceId = attendanceId;
        this.salary = salary;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.overtimeHours = overtimeHours;
        this.employeeID = employeeID;
    }




    public int getPid() {
        return attendanceId;
    }

    public void setPid(int attendanceId) {
        this.attendanceId = attendanceId;
    }

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

    public Employee getEmployee() {
        return employeeID;
    }

    public void setEmployee(Employee employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "AttendanceBOImpl{" +
                "attendanceId=" + attendanceId +
                ", salary=" + salary +
                ", date=" + date +
                ", inTime=" + inTime +
                ", outTime=" + outTime +
                ", overtimeHours=" + overtimeHours +
                ", employeeID=" + employeeID +
                '}';
    }
}
