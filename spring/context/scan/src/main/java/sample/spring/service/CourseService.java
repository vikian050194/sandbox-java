package sample.spring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import sample.spring.model.Course;
import sample.spring.repository.CourseRepository;

@Service
public class CourseService implements CrudService<Course> {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @Override
    public Course create(Course course) {
        return null;
    }

    @Override
    public Optional<Course> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Course course, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
