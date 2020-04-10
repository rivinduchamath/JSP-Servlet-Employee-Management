package lk.sliit.project.employeeManagement.business.custom.impl;

import lk.sliit.project.employeeManagement.business.custom.AttendanceBO;
import lk.sliit.project.employeeManagement.dao.AttendanceDAO;
import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.entity.Attendance;
import lk.sliit.project.employeeManagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 09-Apr-20
 */
@Service
@Transactional
public class AttendanceBOImpl implements AttendanceBO {
    @Autowired
    AttendanceDAO attendanceDAO;
    @Override
    public List<AttendanceDTO> findtodayAttendence() {

        Iterable <Attendance> attendances = attendanceDAO.findAll ( );
        List <AttendanceDTO> dtos = new ArrayList <> ( );
        for (Attendance attendance : attendances) {
            dtos.add ( new AttendanceDTO (
                attendance.getPid (),
                    attendance.getSalary (),
                    attendance.getDate (),
                    attendance.getInTime (),
                    attendance.getOutTime (),
                    attendance.getOvertimeHours (),
                    attendance.getEmployee ()
            ) );
        }
        return dtos;
    }
    @Override
    public Attendance getEmployeeAttCount() {
        return attendanceDAO.findTopByOrderByAttendanceIdDesc();
    }

    @Override
    public void save(AttendanceDTO attendanceDTO) {
        attendanceDAO.save(new Attendance (
                attendanceDTO.getAttendanceId (),
                attendanceDTO.getSalary (),
                attendanceDTO.getDate (),
                attendanceDTO.getInTime (),
                attendanceDTO.getOutTime (),
                attendanceDTO.getOvertimeHours (),
                attendanceDTO.getEmployee ()
        ));
    }


    @Override
    public AttendanceDTO updateUser(String user) {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public List <AttendanceDTO> findAllEmployees() {
        return null;
    }

    @Override
    public AttendanceDTO findUser(String userCode) {
        return null;
    }
}
