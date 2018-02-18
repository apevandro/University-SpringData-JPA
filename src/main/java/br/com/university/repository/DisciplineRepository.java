package br.com.university.repository;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

import br.com.university.Discipline;

@RepositoryDefinition(domainClass=Discipline.class, idClass=Integer.class)
public interface DisciplineRepository {
	public abstract List<Discipline> findByCoursesName(String course);
	public abstract List<Discipline> findByUniClassesStudentNameAndUniClassesIdSemester(String student, String semester);
	public abstract List<Discipline> findByUniClassesStudentNameAndUniClassesGradeLessThan(String student, double grade);
	public abstract List<Discipline> findDistinctByUniClassesProfessorName(String professor);
}