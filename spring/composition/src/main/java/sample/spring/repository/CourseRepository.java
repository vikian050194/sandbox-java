package sample.spring.repository;

import java.util.ArrayList;
import java.util.List;
import sample.spring.model.Course;

public class CourseRepository implements CrudRepository<Course> {

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        Course spring6 = new Course(1,
                "Getting Started with Spring 6",
                "Learn how to build a real application using Spring Framework 6",
                "https://www.example.com");
        courses.add(spring6);
        return courses;
    }

}
