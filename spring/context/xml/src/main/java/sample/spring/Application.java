package sample.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import sample.spring.service.CourseService;

public class Application {

    public static void main(String[] args) {
        BeanFactory factory = new FileSystemXmlApplicationContext("spring.xml");
        // TODO FileSystemXmlApplicationContext vs ClassPathXmlApplicationContext
        var service = factory.getBean("courseService", CourseService.class);
        System.out.println(service.list());
    }
}
