package lk.sliit.project.employeeManagement;

import lk.sliit.project.employeeManagement.dao.EmployeeDAO;
import lk.sliit.project.employeeManagement.dao.SalaryDAO;
import lk.sliit.project.employeeManagement.entity.Employee;
import lk.sliit.project.employeeManagement.entity.Salary;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * @author: Rivindu-Wijayarathna
 * Date: 01-Mar-20
 */
@SpringBootApplication
@EnableJpaRepositories
@ServletComponentScan
public class AppInitializer {
    public static void main(String[] args) {
        SpringApplication.run ( AppInitializer.class, args );
    }

    String str="2020-05-11";
    Date date= Date.valueOf(str);

    @Bean
    CommandLineRunner init2(EmployeeDAO employeeDAO) {
        return args -> {
            List <String> names = Arrays.asList ( "1");
            names.forEach ( name -> employeeDAO.save ( new Employee (

                            "1",
                            "Rivindu Wijayarathna",
                            0223123456,
                            "someOne@gmail.com",
                            "Galle",
                            "Admin",
                            "1",
                            date,
                            "Male",
                            date,
                            "img.jpg",
                            false)
                    )
            );
        };
}}