package lk.sliit.project.employeeManagement.dto;

import java.sql.Date;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 03-May-20
 */

//Class NoticeDTO
public class NoticeDTO {

    private  String noticeId;
    private  String title;
    private  String description;
    private Date date;

    //Full Arg Constructor
    public NoticeDTO(String noticeId, String title, String description, Date date) {
        this.noticeId = noticeId;
        this.title = title;
        this.description = description;
        this.date = date;
    }
    //No Arg Constructor
    public NoticeDTO() {
    }
    //Getters And Setters
    public NoticeDTO(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override  // Override to-String Method
    public String toString() {
        return "NoticeDTO{" +
                "noticeId='" + noticeId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }//End to-String
}//End DTO
