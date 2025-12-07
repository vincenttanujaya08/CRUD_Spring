package com.example.demo.config;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedStudents(StudentRepository repo) {
        return args -> {
            // biar nggak dobel insert saat restart
            if (repo.count() > 0) return;

            Student s1 = new Student();
            s1.setNim("A001");
            s1.setNamaDepan("Budi");
            s1.setNamaBelakang("Santoso");
            s1.setTanggalLahir(LocalDate.of(2002, 5, 10));

            Student s2 = new Student();
            s2.setNim("A002");
            s2.setNamaDepan("Siti");
            s2.setNamaBelakang(null); // contoh optional
            s2.setTanggalLahir(LocalDate.of(2004, 1, 20));

            repo.save(s1);
            repo.save(s2);
        };
    }
}
