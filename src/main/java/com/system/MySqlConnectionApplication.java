package com.system;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MySqlConnectionApplication implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args){
        SpringApplication.run(MySqlConnectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //todo auto-generated method stub
        String sql = "INSERT INTO login(email, password) VALUES (value-1 ,value-2) ";
        int result =jdbcTemplate.update(sql, "sudip.neupane@gmail.com", "sudip2022");
        if(result > 0){
            System.out.println("A new row has been inserted");
        }

    }
}
