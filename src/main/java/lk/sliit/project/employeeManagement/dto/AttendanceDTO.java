package lk.sliit.project.employeeManagement.dto;

import lk.sliit.project.employeeManagement.entity.Employee;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 09-Apr-20
 */
public class AttendanceDTO {

    private int attendanceId;
    private double salary;
    private Date date;
    private Date inTime;
    private Date outTime;
    private double overtimeHours;
    private Employee employee;

    public AttendanceDTO(){}

    public AttendanceDTO(int attendanceId, double salary, Date date, Date inTime, Date outTime, double overtimeHours, Employee employee) {
        this.attendanceId = attendanceId;
        this.salary = salary;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.overtimeHours = overtimeHours;
        this.employee = employee;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }


    @Override
    public String toString() {
        return "AttendanceDTO{" +
                "attendanceId=" + attendanceId +
                ", salary=" + salary +
                ", date=" + date +
                ", inTime=" + inTime +
                ", outTime=" + outTime +
                ", overtimeHours=" + overtimeHours +
                ", employee=" + employee +
                '}';
    }
}

