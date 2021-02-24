package com.buta;

import com.buta.dao.inter.DepartmentDaoInter;
import com.buta.dao.inter.UserDaoInter;
import com.buta.entity.Department;
import com.buta.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VtpSpringApplication {
    @Autowired
    @Qualifier("userDao1")
    private UserDaoInter userDao;

    @Autowired
    @Qualifier("departmentDao1")
    private DepartmentDaoInter departmentDao;

    public static void main(String[] args) {
        SpringApplication.run(VtpSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<Department> list = departmentDao.findByName("IT");
                System.out.println(list.get(0).getDepartmentName());
//                User u = userDao.findById(1);
//                System.out.println(u);

            }

        };
        return clr;
    }

}
