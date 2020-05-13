package lk.sliit.project.employeeManagement.service.custom.impl;


import lk.sliit.project.employeeManagement.service.custom.AttendanceBO;
import lk.sliit.project.employeeManagement.dao.AttendanceDAO;
import lk.sliit.project.employeeManagement.dao.EmployeeDAO;
import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import lk.sliit.project.employeeManagement.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 09-Apr-20
 */
@Service
@Transactional
public class AttendanceBOImpl implements AttendanceBO {
    //Automate Object Creation
    @Autowired
    AttendanceDAO attendanceDAO;
    @Autowired
    EmployeeDAO employeeDAO;

    //Find Only Today attendance To load Today Attendance Table
    @Override
    @Transactional(readOnly = true)
    public List<AttendanceDTO> findTodayAttendance() {
        DateFormat dateFormat = new SimpleDateFormat ("yyyy/MM/dd");
        Date date = new Date();
        Iterable <Attendance> attendances = null;
        try {
               attendances = attendanceDAO.findAttendanceByDateEquals (date );
        }catch (Exception e){
            Logger.getLogger("lk.sliit.project.employeeManagement.service.custom.impl").log(Level.SEVERE, null,e); //Add Logger To Catch Exception
        }
        List <AttendanceDTO> dtos = new ArrayList <> ( );
        for (Attendance attendance : attendances) {
            dtos.add ( new AttendanceDTO (
                attendance.getAttendanceId (),
                    attendance.getSalary (),
                    attendance.getDate (),
                    attendance.getInTime (),
                    attendance.getOutTime (),
                    attendance.getOvertimeHours (),
                    attendance.getEmployee ().getIdNo (),
                    employeeDAO.findOne ( attendance.getEmployee ().getIdNo () )
            ) );
        }
        return dtos;
    }//End findTodayAttendance Method

    //Get Top Attendance ID (IF Delete SomeOne)
    @Override
    @Transactional(readOnly = true)
    public AttendanceDTO findTopByOrderByAttendanceIdDesc() {
        Attendance attendance = null;
        try {
         attendance = attendanceDAO.findTopByOrderByAttendanceIdDesc ();
    }catch (Exception e){
        Logger.getLogger("lk.sliit.project.employeeManagement.service.custom.impl").log(Level.SEVERE, null,e); //Add Logger To Catch Exception
    }
        return new AttendanceDTO (
                attendance.getAttendanceId ()
        );
    }//End Get Total Emp

    //Save Attendance If Not Already Add Today
    @Override
    public void saveOrUpdate(AttendanceDTO attendanceDTO) {
        attendanceDAO.save(new Attendance (
                attendanceDTO.getAttendanceId (),
                attendanceDTO.getSalary (),
                attendanceDTO.getDate (),
                attendanceDTO.getInTime (),
                attendanceDTO.getOutTime (),
                attendanceDTO.getOvertimeHours (),
                employeeDAO.findOne (attendanceDTO.getEmployeeID ())));
    }//End attendance save method

    @Override//Delete Attendance
    public void deleteAttendance(String id) {
        attendanceDAO.delete (id);
    }

    @Override//Get All Attendance in the attendance table
    @Transactional(readOnly = true)
    public List <AttendanceDTO> findAllAtendance() {
        Iterable <Attendance> allItems = attendanceDAO.findAll();
        List <AttendanceDTO> dtos = new ArrayList <> ();
        for (Attendance attendance : allItems) {
            dtos.add(new AttendanceDTO (
                    attendance.getAttendanceId (),
                    attendance.getSalary (),
                    attendance.getDate (),
                    attendance.getInTime (),
                    attendance.getOutTime (),
                    attendance.getOvertimeHours (),
                    attendance.getEmployee ().getIdNo (),
                    employeeDAO.findOne ( attendance.getEmployee ().getIdNo () )
            ));
        }
        return dtos;
    }////End Get All Attendance  Method

}//End Class
