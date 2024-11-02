package sample.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.spring.config.AppConfig;
import sample.spring.service.CourseService;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        var service = context.getBean("courseService", CourseService.class);
        System.out.println(service.list());
    }
}
