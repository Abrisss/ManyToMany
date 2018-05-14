package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CurriculumServiceTest {

    @Autowired
    private CurriculumService curriculumService;

    @Test
    public void createTest() {
        Course course = course();
        Curriculum curriculum = curriculum();
        curriculum.addCourse(course);

        Curriculum savedCurriculum = curriculumService.create(curriculum);

        Curriculum returnedCurriculum = curriculumService.get(savedCurriculum.getId());

        assertThat(returnedCurriculum.getCourses())
            .hasSize(1)
            .containsExactly(course);
        assertThat(returnedCurriculum.getName()).isEqualTo(curriculum.getName());
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
