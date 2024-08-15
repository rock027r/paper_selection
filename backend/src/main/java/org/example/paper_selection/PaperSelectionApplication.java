package org.example.paper_selection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.example.paper_selection.mapper")
@SpringBootApplication
public class PaperSelectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaperSelectionApplication.class, args);
    }

}
