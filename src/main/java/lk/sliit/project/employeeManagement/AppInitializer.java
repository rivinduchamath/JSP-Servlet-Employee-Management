package lk.sliit.project.employeeManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 08-Mar-20
 */
@SpringBootApplication
@EnableJpaRepositories
@ServletComponentScan
public class AppInitializer {
    public static void main(String[] args) {
        SpringApplication.run ( AppInitializer.class, args );
    }
}
