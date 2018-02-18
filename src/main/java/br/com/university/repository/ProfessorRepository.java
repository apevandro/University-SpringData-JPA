package br.com.university.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

import br.com.university.Professor;

@RepositoryDefinition(domainClass=Professor.class, idClass=Integer.class)
public interface ProfessorRepository {
	public abstract List<Professor> findByAdmissionBefore(LocalDate admission);
	public abstract List<Professor> findDistinctByUniClassesDisciplineName(String discipline);
}