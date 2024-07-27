package com.example.Empregados;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmpregadoConfig {


    @Bean
    CommandLineRunner commandLineRunner(EmpregadoRepository repo) {
        return args -> {
            Empregado Jorge = new Empregado(
                    "Jorge",
                    "jorgemateus@gmail.com",
                    3000,
                    LocalDate.of(2000, Month.DECEMBER,26)
            );
            Empregado maria = new Empregado(
                    "Maria",
                    "maria@gmail.com",
                    3500,
                    LocalDate.of(1998, Month.MARCH, 15)
            );
            Empregado ana = new Empregado(
                    "Ana",
                    "ana@gmail.com",
                    3200,
                    LocalDate.of(1999, Month.JULY, 9)
            );
            Empregado pedro = new Empregado(
                    "Pedro",
                    "pedro@gmail.com",
                    3100,
                    LocalDate.of(2001, Month.JUNE, 22)
            );
            Empregado carlos = new Empregado(
                    "Carlos",
                    "carlos@gmail.com",
                    2900,
                    LocalDate.of(2000, Month.APRIL, 30)
            );
            repo.saveAll(
                    List.of(Jorge, maria, ana, pedro, carlos)
            );

        };
    }
}
