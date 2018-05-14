package com.example.demo;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@ToString(of = {"id", "name", "courses"})
public class Curriculum {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column
    private String name;

    @JoinTable(name = "CURRICULA_GROUP",
        joinColumns = @JoinColumn(name = "curriculum_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    @ManyToMany(targetEntity = Course.class, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Course> courses = new ArrayList<>();

    public Curriculum addCourse(Course course) {
        if (!this.courses.contains(course)) {
            this.courses.add(course);
            if (!course.getCurricula().contains(this)) {
                course.getCurricula().add(this);
            }
        }
        return this;
    }
}
