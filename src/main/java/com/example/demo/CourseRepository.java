package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Abris on 2018. 05. 14..
 */
public interface CourseRepository extends JpaRepository<Course, String> {
}
