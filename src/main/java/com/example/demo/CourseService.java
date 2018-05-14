package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CourseService {

    private CourseRepository courseRepository;

    private CurriculumRepository curriculumRepository;


    public Course get(String id) {
        return courseRepository.findById(id).get();
    }


    public Course create(Course course) {
        return courseRepository.save(course);
    }

//    public void delete(String id) {
//        if (timetableService.isProcessing() || timetableService.isFinalized()) {
//            throw new TimetableCannotModifyException();
//        }
//        User user = userService.getLoggedInUser();
//        Course course = get(id);
//        if (!hasPermission(user, course)) {
//            throw new UserPermissionDeniedException(String.format("User does not have permission to delete course with id: %s.", id));
//        }
//        timetableService.dataChanged();
//        courseRepository.delete(course);
//    }
//
//    public Course update(String id, Course course) {
//        if (timetableService.isProcessing() || timetableService.isFinalized()) {
//            throw new TimetableCannotModifyException();
//        }
//        User user = userService.getLoggedInUser();
//        course.setId(id);
//        if (!courseRepository.exists(id)) {
//            throw new CourseNotFoundException(String.format("Course with id: %s is not exist.", id));
//        }
//        if (!hasPermission(user, course)) {
//            throw new UserPermissionDeniedException(String.format("User does not have permission to update course with id: %s.", id));
//        }
//        if (user.getRole().equals(ADMIN)) {
//            course.setTeacher(teacherService.get(course.getTeacher().getId()));
//        } else {
//            course.setTeacher(user.getTeacher());
//        }
////        course.addCurricula(course.getCurricula().stream()
////                                  .map(curriculum -> curriculumService.get(curriculum.getId()))
////                                  .collect(Collectors.toList()));
//        timetableService.dataChanged();
//        return courseRepository.save(course);
//    }
}
