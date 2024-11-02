package sample.spring;

import sample.spring.repository.CourseRepository;
import sample.spring.service.CourseService;

public class Application {

    public static void main(String[] args) {
        var repository = new CourseRepository();
        var service = new CourseService(repository);
        System.out.println(service.list());
    }
}
