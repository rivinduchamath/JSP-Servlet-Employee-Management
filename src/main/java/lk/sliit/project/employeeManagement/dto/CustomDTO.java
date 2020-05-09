package lk.sliit.project.employeeManagement.dto;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 25-Apr-20
 */
public class CustomDTO {
    private String idNo;
    private String name;
    private double overtimeHours;

    public CustomDTO(String idNo, String name, double overtimeHours) {
        this.idNo = idNo;
        this.name = name;
        this.overtimeHours = overtimeHours;
    }

    public CustomDTO() {
    }

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
}

