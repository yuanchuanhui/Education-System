package org.thealphalab.education;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.thealphalab.education.mapper")
public class EducationApplication {

    private static Logger log = LoggerFactory.getLogger(EducationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EducationApplication.class, args);
    }

}