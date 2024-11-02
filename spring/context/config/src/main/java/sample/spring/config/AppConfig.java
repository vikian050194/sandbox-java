package sample.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sample.spring.repository.CourseRepository;
import sample.spring.service.CourseService;

@Configuration
public class AppConfig {

    @Bean("courseRepository")
    public CourseRepository getCourseRepository() {
        return new CourseRepository();
    }

    @Bean("courseService")
    public CourseService getCourseService() {
        return new CourseService(getCourseRepository());
    }
}
