package br.com.university.repository;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

import br.com.university.Student;

@RepositoryDefinition(domainClass=Student.class, idClass=Integer.class)
public interface StudentRepository {
	public abstract List<Student> findByAddressCityOrderByNameDesc(String city);
	public abstract List<Student> findByNameStartingWith(String letter);
	public abstract List<Student> findByUniClassesDisciplineNameAndUniClassesIdSemesterAndUniClassesGradeLessThan
	                                  (String discipline, String semester, double grade);
}