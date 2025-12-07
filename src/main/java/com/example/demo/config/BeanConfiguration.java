package com.example.demo.config;

import com.example.demo.adapter.persistence.StudentGatewayImpl;
import com.example.demo.adapter.persistence.StudentJpaRepository;
import com.example.demo.domain.gateway.StudentGateway;
import com.example.demo.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public StudentGateway studentGateway(StudentJpaRepository jpaRepository) {
        return new StudentGatewayImpl(jpaRepository);
    }

    @Bean
    public CreateStudent createStudent(StudentGateway gateway) {
        return new CreateStudent(gateway);
    }

    @Bean
    public GetStudent getStudent(StudentGateway gateway) {
        return new GetStudent(gateway);
    }

    @Bean
    public ListStudents listStudents(StudentGateway gateway) {
        return new ListStudents(gateway);
    }

    @Bean
    public UpdateStudent updateStudent(StudentGateway gateway) {
        return new UpdateStudent(gateway);
    }

    @Bean
    public DeleteStudent deleteStudent(StudentGateway gateway) {
        return new DeleteStudent(gateway);
    }
}