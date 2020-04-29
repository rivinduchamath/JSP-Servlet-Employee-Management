package lk.sliit.project.employeeManagement.service.custom.impl;

import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.entity.Employee;
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

    //Find Today attendance To load Today Attendance Table
    @Override
    public List<AttendanceDTO> findTodayAttendance() {
        DateFormat dateFormat = new SimpleDateFormat ("yyyy/MM/dd");
        Date date = new Date();
        Iterable <Attendance> attendances = attendanceDAO.findAttendanceByDateEquals (date );
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
                    employeeDAO.findName ( attendance.getEmployee ().getIdNo () ),
                    employeeDAO.findPos ( attendance.getEmployee ().getIdNo ()),
                    employeeDAO.findPic ( attendance.getEmployee ().getIdNo () )
            ) );
        }
        return dtos;
    }
    //Get Top Attendance ID (IF Delete SomeOne)
    @Override
    public AttendanceDTO getEmployeeAttCount() {
        Attendance employee = attendanceDAO.findTopByOrderByAttendanceIdDesc ();
        return new AttendanceDTO (
                employee.getAttendanceId ()
        );
    }

    //Save Attendance If Not Already Add Today
    @Override
    public void save(AttendanceDTO attendanceDTO) {
        attendanceDAO.save(new Attendance (
                attendanceDTO.getAttendanceId (),
                attendanceDTO.getSalary (),
                attendanceDTO.getDate (),
                attendanceDTO.getInTime (),
                attendanceDTO.getOutTime (),
                attendanceDTO.getOvertimeHours (),
                employeeDAO.findOne (attendanceDTO.getEmployeeID ())));

    }


    @Override
    public AttendanceDTO updateUser(String user) {
        return null;
    }

    @Override
    public void deleteUser(String id) {
        attendanceDAO.delete (id);
    }

    @Override
    public List <AttendanceDTO> findAllEmployees() {
        return null;
    }

    @Override
    public AttendanceDTO findUser(String userCode) {
        return null;
    }

    @Override
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
                    employeeDAO.findName ( attendance.getEmployee ().getIdNo () ),
                    employeeDAO.findPos ( attendance.getEmployee ().getIdNo ()),
                    employeeDAO.findPic ( attendance.getEmployee ().getIdNo () )
            ));
        }
        return dtos;
    }
}
