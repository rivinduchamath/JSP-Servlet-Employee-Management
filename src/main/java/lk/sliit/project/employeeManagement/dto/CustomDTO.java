package lk.sliit.project.employeeManagement.dto;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 25-Apr-20
 */

//Class CustomDTO For Common Works
public class CustomDTO {
    private String idNo;
    private String name;
    private double overtimeHours;

    //Full Arg Constructor
    public CustomDTO(String idNo, String name, double overtimeHours) {
        this.idNo = idNo;
        this.name = name;
        this.overtimeHours = overtimeHours;
    }
    //No Arg Constructor
    public CustomDTO() {
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

}//End DTO

