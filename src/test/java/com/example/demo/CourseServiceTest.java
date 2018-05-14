package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void createTest() {
        Course course = course();
        Curriculum curriculum = curriculum();
        curriculum.addCourse(course);

        Course savedCourse = courseService.create(course);

        Course returnedCourse = courseService.get(savedCourse.getId());

        assertThat(returnedCourse.getCurricula())
            .hasSize(1)
            .containsExactly(curriculum);
        assertThat(returnedCourse.getName()).isEqualTo(course.getName());
    }

    private Course course() {
        Course course = new Course();
        course.setName("Course Name");
        return course;
    }

    private Curriculum curriculum() {
        return new Curriculum()
            .setName("Curriculum Name");
    }

}
