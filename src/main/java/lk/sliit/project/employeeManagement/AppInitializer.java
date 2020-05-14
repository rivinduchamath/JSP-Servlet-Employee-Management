package lk.sliit.project.employeeManagement;

import lk.sliit.project.employeeManagement.dao.EmployeeDAO;
import lk.sliit.project.employeeManagement.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by IntelliJ IDEA.
 * @author: Rivindu-Wijayarathna
 * Date: 01-Mar-20
 */
@SpringBootApplication
@EnableJpaRepositories
@ServletComponentScan
public class AppInitializer {
    //Main Methodas
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger("lk.sliit.project.employeeManagement");
        FileHandler fileHandler = new FileHandler("error.log",true);
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(Level.INFO);
        logger.addHandler(fileHandler);
        SpringApplication.run ( AppInitializer.class, args );
    }

    //Add Values
    String str="2020-05-17";
    Date date= Date.valueOf(str);

    //Add Admin Employee To the System When Server Start
    @Bean
    CommandLineRunner init2(EmployeeDAO employeeDAO) {
        return args -> {
            List <String> names = Arrays.asList ( "1");
            names.forEach ( name -> employeeDAO.save ( new Employee (//Add New Employee

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
                            true)
                    )
            );
        };
}//End init2
}//End Class