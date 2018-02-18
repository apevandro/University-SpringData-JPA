package br.com.university.app;

import java.time.LocalDate;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.university.service.UniversityService;

public class App {

	public static void main(String[] args) {

		Object[] res;
		
		String configLocation = "classpath:META-INF/spring/applicationContext.xml";

		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(configLocation)) {

			UniversityService service = context.getBean(UniversityService.class);

			service.questionA().forEach(c -> System.out.println(c.getName()));

			service.questionB("Sao Carlos-SP").forEach(student -> System.out.println(student.getName()));

			service.questionC(LocalDate.of(1993, 01, 01))
			       .forEach(professor -> System.out.println(professor.getName()));

			service.questionD("J").forEach(student -> System.out.println(student.getName()));

			service.questionE("Ciencia da Computacao").forEach(discipline -> System.out.println(discipline.getName()));

			service.questionF("Calculo Numerico").forEach(discipline -> System.out.println(discipline.getName()));

			service.questionG("Marcos Joao Casanova", "01/1998")
			       .forEach(discipline -> System.out.println(discipline.getName()));

			service.questionH("Ailton Castro", 7.0)
			       .forEach(discipline -> System.out.println(discipline.getName()));

			service.questionI("Calculo Numerico", "01/1998", 7.0)
			       .forEach(student -> System.out.println(student.getName()));
			
			service.questionJ("Ramon Travanti").forEach(discipline -> System.out.println(discipline.getName()));
			
			service.questionK("Banco de Dados").forEach(professor -> System.out.println(professor));

			res = service.questionL("Calculo Numerico", "01/1998");
			System.out.println("Minimun grade: " + res[0]);
			System.out.println("Maximun grade: " + res[1]);

			res = service.questionM("Engenharia de Software", "01/1998");
			System.out.println("Student name: " + res[0]);
			System.out.println("Grade: " + res[1]);

			service.questionN("01/1998")
				   .forEach(result -> System.out.println("Student: " + result[0] + "   " +
						                                 "Discipline: " + result[1] + "   " +
						                                 "Professor: " + result[2]));

			service.questionO("Ciencia da Computacao", "01/1998")
			       .forEach(result -> System.out.println("Student: " + result[0] + "   " +
			    		                                 "Discipline: " + result[1] + "   " +
			    		                                 "Grade: " + result[2]));

			Double grade = service.questionP("Marcos Salvador");
			System.out.println(grade);

			service.questionQ(5.0, 7.0)
			       .forEach(result -> System.out.println("Student: " + result[0] + "   " + 
			                                             "Discipline: " + result[1] + "   " + 
			    		                                 "Grade: " + result[2]));

			Double average = service.questionR("Calculo Numerico", "01/1998");
		    System.out.println("Average: " + average);

			Long quantity = service.questionS("Abgair Simon Ferreira", "01/1998");
	        System.out.println("Number of students: " + quantity);

			res = service.questionT("Edvaldo Carlos Silva", "01/1998");
			System.out.println("Grade average: " + res[0] + "   Number of classes: " + res[1]);

			service.questionU("01/1998")
			       .forEach(result -> System.out.println("Discipline: " + result[0] + "   Average: " + result[1]));

			service.questionV("01/1998")
			   	   .forEach(result -> System.out.println("Professor: " + result[0] + "   " + 
			                                             "Average: " + result[1] + "   " + 
			   			                                 "Quantity: " + result[2]));

			service.questionW("Ciencia da Computacao", "01/1998")
			       .forEach(result -> System.out.println("Discipline: " + result[0] + "   Average: " + result[1]));

			Long credits = service.questionX("Edvaldo Carlos Silva");
		    System.out.println("Credits: " + credits);

			service.questionY(70)
			       .forEach(result -> System.out.println("Student: " + result[0] + "   Credits: " + result[1]));

			service.questionZ("Ciencia da Computacao", "01/1998")
			       .forEach(result -> System.out.println("Student: " + result[0] + "   " + 
			                                             "Discipline: " + result[1] + "   " + 
					                                     "Professor: " + result[2]));
		}
	}

}