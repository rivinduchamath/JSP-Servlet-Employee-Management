package lk.sliit.project.employeeManagement.business.custom.impl;

import lk.sliit.project.employeeManagement.business.custom.AttendanceBO;
import lk.sliit.project.employeeManagement.dao.AttendanceDAO;
import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.entity.Attendance;
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
}
