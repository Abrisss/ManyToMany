package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CurriculumService {

    private CurriculumRepository curriculumRepository;


    public Curriculum get(String id) {
        return curriculumRepository.findById(id).get();
    }


    public Curriculum create(Curriculum course) {
        return curriculumRepository.save(course);
    }

//    public void delete(String id) {
//        if (timetableService.isProcessing() || timetableService.isFinalized()) {
//            throw new TimetableCannotModifyException();
//        }
//        if (!curriculumRepository.exists(id)) {
//            throw new CurriculumNotFoundException(String.format("Curriculum with id: %s does not exist.", id));
//        }
//        curriculumRepository.delete(id);
//    }

//    public Curriculum update(String id, Curriculum curriculum) {
//        if (timetableService.isProcessing() || timetableService.isFinalized()) {
//            throw new TimetableCannotModifyException();
//        }
//        if (!curriculumRepository.exists(id)) {
//            throw new CurriculumNotFoundException(String.format("Curriculum with id: %s does not exist.", id));
//        }
//        curriculum.setId(id);
//        curriculum.setCourses(curriculum.getCourses().stream()
//                                        .map(course -> courseService.get(course.getId()))
//                                        .collect(Collectors.toList()));
//        return curriculumRepository.save(curriculum);
//    }
}
