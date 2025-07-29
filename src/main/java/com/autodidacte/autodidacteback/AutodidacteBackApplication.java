package com.autodidacte.autodidacteback;

import com.autodidacte.autodidacteback.services.FormationService;
import com.autodidacte.autodidacteback.services.ParcoursService;
import com.autodidacte.autodidacteback.services.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AutodidacteBackApplication {
    @Autowired
    private ProgrammeService programService;
    @Autowired
    private ParcoursService parcoursService;
    @Autowired
    private FormationService formationService;
    public static void main(String[] args) {
        SpringApplication.run(AutodidacteBackApplication.class, args);
    }

    @Bean
    CommandLineRunner start() {
        return args -> {

            System.out.println("STARTED !!!");

        };
    }

}
