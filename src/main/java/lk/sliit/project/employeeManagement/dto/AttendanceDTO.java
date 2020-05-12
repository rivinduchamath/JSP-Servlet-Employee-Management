package lk.sliit.project.employeeManagement.dto;
import lk.sliit.project.employeeManagement.entity.Employee;

import java.util.Date;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 09-Apr-20
 */

//Class AttendanceDTO
public class AttendanceDTO {

    private String attendanceId;
    private double salary;
    private Date date;
    private String inTime;
    private String outTime;
    private double overtimeHours;
    private String employeeID;
    private String empName;
    private String position;
    private String pic;

    //Default Constructor
    public AttendanceDTO() {
    }

    //Full Arg Constructor
    public AttendanceDTO(String attendanceId, double salary, Date date, String inTime, String outTime, double overtimeHours, String employeeID, String empName, String position, String pic) {
        this.attendanceId = attendanceId;
        this.salary = salary;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.overtimeHours = overtimeHours;
        this.employeeID = employeeID;
        this.empName = empName;
        this.position = position;
        this.pic = pic;
    }//End Full arg

    public AttendanceDTO(String attendanceId, double salary, Date date, String inTime, String outTime, double overtimeHours, String employeeID) {
        this.attendanceId = attendanceId;
        this.salary = salary;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.overtimeHours = overtimeHours;
        this.employeeID = employeeID;
    }

    //Constructor
    public AttendanceDTO(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public AttendanceDTO(String attendanceId, double salary, Date date, String inTime, String outTime, double overtimeHours, String employeeID, Employee one) {
        this.attendanceId = attendanceId;
        this.salary = salary;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.overtimeHours = overtimeHours;
        this.employeeID = employeeID;
        this.empName = one.getName();
        this.position = one.getOccupation();
        this.pic = one.getPic();
    }


    //Getters And Setters
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getEmployee() {
        return employeeID;
    }

    public void setEmployee(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getPid() {
        return attendanceId;
    }

    public void setPid(String attendanceId) {
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

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Override To String
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
    }//End To String
}//End Class Attendance DTO


