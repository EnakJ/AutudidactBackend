package com.autodidacte.autodidacteback;

import com.autodidacte.autodidacteback.entities.Cours;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.services.CoursService;
import com.autodidacte.autodidacteback.services.ParcoursService;
import com.autodidacte.autodidacteback.services.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;


@SpringBootApplication
public class AutodidacteBackApplication {
    @Autowired
    private ProgrammeService programService;
    @Autowired
    private ParcoursService parcoursService;
    @Autowired
    private CoursService coursService;
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
