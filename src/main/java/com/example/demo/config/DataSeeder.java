package com.example.demo.config;

import com.example.demo.usecase.CreateStudent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedData(CreateStudent createStudent) {
        return args -> {
            try {
                createStudent.execute(
                        "A001",
                        "Vincent",
                        "1",
                        LocalDate.of(2002, 5, 10)
                );

                createStudent.execute(
                        "A002",
                        "Vincent",
                        null,
                        LocalDate.of(2004, 1, 20)
                );

                createStudent.execute(
                        "A003",
                        "Vincent",
                        "Ta",
                        LocalDate.of(2003, 8, 15)
                );

                System.out.println("✅ Sample data seeded successfully!");
            } catch (Exception e) {
                System.out.println("⚠️  Data already seeded, skipping...");
            }
        };
    }
}