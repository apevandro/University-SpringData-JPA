package br.com.university.repository;

public interface UniClassRepositoryCustom {	
	public abstract Object[] findMinMaxGradeByDisciplineNameAndSemester(String discipline, String semester);
	public abstract Object[] findStudentNameMaxGradeByDisciplineNameAndSemester(String discipline, String semester);
	public abstract Object[] findAvgGradeAndNumberOfClassesByStudentAndSemester(String student, String semester);
}