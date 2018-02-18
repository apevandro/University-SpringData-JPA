package br.com.university.repository;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

import br.com.university.Course;

@RepositoryDefinition(domainClass=Course.class, idClass=Integer.class)
public interface CourseRepository {
	public abstract List<Course> findAll();
	public abstract List<Course> findByDisciplinesName(String discipline);
}