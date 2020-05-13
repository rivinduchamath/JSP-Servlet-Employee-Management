package lk.sliit.project.employeeManagement.service.custom.impl;

import lk.sliit.project.employeeManagement.dao.NoticeDAO;
import lk.sliit.project.employeeManagement.dao.ProjectDAO;
import lk.sliit.project.employeeManagement.dto.NoticeDTO;
import lk.sliit.project.employeeManagement.dto.ProjectDTO;
import lk.sliit.project.employeeManagement.entity.Employee;
import lk.sliit.project.employeeManagement.entity.Notice;
import lk.sliit.project.employeeManagement.entity.Project;
import lk.sliit.project.employeeManagement.service.custom.DashboardBO;
import lk.sliit.project.employeeManagement.dao.AttendanceDAO;
import lk.sliit.project.employeeManagement.dao.EmployeeDAO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 16-Mar-20
 */
@Service
@Transactional
public class DashboardBOImpl implements DashboardBO {
    //Automate Object Creation
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private ProjectDAO projectDAO;
    @Autowired
    NoticeDAO noticeDAO;
    @Autowired
    private AttendanceDAO attendanceDAO;

    //Find Total Count Manual Query Method
    @Override
    public long  getAllEmployeeCount() { return employeeDAO.count (); }

    //Find Male Count To Dashboard
    @Override
    public long getMaleCount() {
        return employeeDAO.countByGender("male");
    }

    //Find Female Count To Dashboard
    @Override
    public long getFemaleCount() {
        return employeeDAO.countByGender("female");
    }

    //UpComing Birthdays Up to 1 month
    @Override
    public List <ProjectDTO> projectsExp() {
        DateFormat dateFormat = new SimpleDateFormat ("yyyy/MM/dd");
        Date todaydate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        java.util.Date afterOneMonth = cal.getTime();
        Iterable <Project> projects = projectDAO.findProjectsByExpDateBetween (todaydate ,afterOneMonth);
        List <ProjectDTO> dtos = new ArrayList<> ( );
        for (Project project : projects) {
            dtos.add ( new ProjectDTO (
                    project.getProjectId (),
                    project.getProjectName (),
                    project.getProgress (),
                    project.getExpDate (),
                    project.getClient ()
            ) );
        }
        return dtos;
    }

    @Override//Get Total Worked time According to Attendance
    public double getTotalTime() {
        Iterable <Attendance> allItems = attendanceDAO.findAll ();
    double tot =0;
    double t =0;
    double count = 0;
        for (Attendance attendance : allItems) {
            tot= attendance.getOvertimeHours ();
            t++;
            count += tot;
        }
        count += (t *8);
        return count;
    }
    @Override//Check logged id and Password is match
    public EmployeeDTO findByIdNoAndPassword(String idNo, String password) {
        Employee employee = employeeDAO.findByIdNoAndPassword(idNo, password);
        return new EmployeeDTO (
                employee.getIdNo (),
                employee.getPassword ());
    }

    @Override//Get Total No Of Project
    public double getTotalProjects() {
        return projectDAO.count ();
    }

    @Override//Get All Notice Between Today And Before 1 month
    public List <NoticeDTO> findResentNoticeDesc() { //
        Date todaydate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        java.util.Date dt = cal.getTime();
        Iterable <Notice> allItems = noticeDAO.findAllByDateBetweenOrderByDateDesc( dt, todaydate);
        List <NoticeDTO> dtos = new ArrayList<> ();
        for (Notice notice : allItems) {
            dtos.add(new NoticeDTO (
                    notice.getNoticeId (),
                    notice.getTitle (),
                    notice.getDescription (),
                    notice.getDate ()
            ));
        }
        return dtos;
    }

    @Override
    public boolean isAdmin(String idNo) {
        return employeeDAO.isAdmin(idNo);
    }
}//End Class
