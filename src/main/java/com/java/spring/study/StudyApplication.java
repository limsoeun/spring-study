package com.java.spring.study;

// import com.java.spring.study.config.BeanConfig;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {
		// ApplicationContext app = new AnnotationConfigApplicationContext(BeanConfig.class);
		// System.out.println(app);

		// SpringApplication.run(StudyApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		System.out.println(context);
	}

}
