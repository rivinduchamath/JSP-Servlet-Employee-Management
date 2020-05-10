package lk.sliit.project.employeeManagement.entity;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 15-Apr-20
 */

 //Entity Class CustomEntity For COMMON Operations
public class CustomEntity implements SuperEntity {

    private String idNo;
    private String name;
    private double overtimeHours;

    //Add Full Arg Constructor
    public CustomEntity(String idNo, String name, double overtimeHours) {
        this.idNo = idNo;
        this.name = name;
        this.overtimeHours = overtimeHours;
    }
    //No arg constructor
    public CustomEntity() {
    }
    //Getters And Setters
    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
}//End Class
