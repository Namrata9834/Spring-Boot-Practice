package com.codekul.Spring6DecBatch.config;

import com.codekul.Spring6DecBatch.di.Principle;
import com.codekul.Spring6DecBatch.di.Teacher;
import com.codekul.Spring6DecBatch.ioc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration          // this class provides information to the ioc container
public class AppConfig {

    @Bean
    public Principle principle() {
        return new Principle();
    }

    @Bean
    public Teacher teacher() {
        Teacher teacher = new Teacher();
        teacher.setPrinciple(principle());
        return teacher;

    }

    @Bean
    public Teacher getTeacher() {
        return new Teacher(principle());
    }

    @Bean
    public SortingTechniques bubbleSort() {
        return new BubbleSort();
    }

    @Bean
    public SortingTechniques insertionSort() {
        return new InsertionSort();
    }

    @Bean
    public Sim vodaphone() {
        return new Vodaphone();
    }

    @Bean
    public Sim airtel() {
        return new Airtel();
    }



}
