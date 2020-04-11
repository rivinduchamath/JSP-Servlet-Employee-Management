package lk.sliit.project.employeeManagement.dto;

import lk.sliit.project.employeeManagement.entity.Employee;

import java.util.Date;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 09-Apr-20
 */
public class AttendanceDTO {

    private int attendanceId;
    private double salary;
    private Date date;
    private String inTime;
    private String outTime;
    private double overtimeHours;
    private Employee employeeID;


    public AttendanceDTO() {
    }

    public AttendanceDTO(int attendanceId, double salary, Date date, String inTime, String outTime, double overtimeHours, Employee employeeID) {
        this.attendanceId = attendanceId;
        this.salary = salary;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.overtimeHours = overtimeHours;
        this.employeeID = employeeID;

    }

    public int getAttendanceId() {
        return attendanceId;
    }



    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Employee getEmployee() {
        return employeeID;
    }

    public void setEmployee(Employee employeeID) {
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

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "AttendanceDTO{" +
                "attendanceId=" + attendanceId +
                ", salary=" + salary +
                ", date=" + date +
                ", inTime='" + inTime + '\'' +
                ", outTime='" + outTime + '\'' +
                ", overtimeHours=" + overtimeHours +
                ", employeeID=" + employeeID +
                '}';
    }
}


