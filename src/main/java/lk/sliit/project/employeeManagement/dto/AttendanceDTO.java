package lk.sliit.project.employeeManagement.dto;


import java.util.Date;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 09-Apr-20
 */
public class AttendanceDTO  {

    private int attendanceId;
    private double salary;
    private Date date;
    private String inTime;
    private String outTime;
    private double overtimeHours;
    private String employeeID;
    private String empName;
    private String position;
    private String pic;


    public AttendanceDTO(){}


    public AttendanceDTO(int attendanceId, double salary, Date date, String inTime, String outTime, double overtimeHours, String employeeID, String empName, String position, String pic) {
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
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getAttendanceId() {
        return attendanceId;
    }



    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getEmployee() {
        return employeeID;
    }

    public void setEmployee(String employeeID) {
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


