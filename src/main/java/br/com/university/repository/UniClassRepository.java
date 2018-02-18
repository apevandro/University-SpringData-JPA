package br.com.university.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;

import br.com.university.UniClass;

@RepositoryDefinition(domainClass=UniClass.class, idClass=UniClass.Id.class)
public interface UniClassRepository extends UniClassRepositoryCustom, PagingAndSortingRepository<UniClass, UniClass.Id> {

	public abstract List<UniClass> findAll(Sort sort);
	
    @Query("select s.name, d.name, p.name from Student s, Discipline d, Professor p, UniClass c " +
           "where c.id.studentId = s.studentId and " +
	             "c.id.discId = d.discId and " +
	             "c.id.profId = p.profId and " +
	             "c.id.semester = ?1 " +
	             "ORDER BY s.name ASC")
	public abstract List<Object[]> findStudentDisciplineProfessorBySemesterAscOrder(String semester);
	
	
	@Query("select s.name, d.name, c.grade from Student s, Discipline d join d.courses co, UniClass c " +
	       "where co.name = ?1 and " +
		         "c.id.semester = ?2 and " +
		         "s.studentId = c.id.studentId and " +
		         "c.id.discId = d.discId and " + 
		         "co.courseId = s.course.courseId")
	public abstract List<Object[]> findStudentDisciplineGradeByCourseAndSemester(String course, String semester);


	@Query("select avg(c.grade) from UniClass c, Professor p " +
	       "where c.id.profId = p.profId and " +
		         "p.name = ?1")
	public abstract Double findAvgGradeByProfessor(String professor);


	@Query("select s.name, d.name, c.grade from Student s, Discipline d, UniClass c " +
	       "where c.id.discId = d.discId and " +
		         "c.id.studentId = s.studentId and " +
	             "c.grade between ?1 and ?2 " +
		         "order by d.name asc")
	public abstract List<Object[]> findStudentDisciplineGradeByIntervalGradeAscOrder(Double mim, Double max);
	
	
	@Query("select avg(c.grade) from Discipline d, UniClass c " +
	       "where d.name = ?1 and " +
		         "d.discId = c.id.discId and " +
	             "c.id.semester = ?2")
	public abstract Double findAvgGradeByDisciplineAndSemester(String discipline, String semester);
	
	
	@Query("select count(c.id.studentId) from UniClass c, Professor p " +
	       "where p.name = ?1 and " +
	             "p.profId = c.id.profId and " +
                 "c.id.semester = ?2")
	public abstract Long findNumberStudentsByProfessorAndSemester(String professor, String semester);

	
	@Query("select d.name, avg(c.grade) from  Discipline d, UniClass c " +
	       "where d.discId = c.id.discId and " +
		         "c.id.semester = ?1 " +
	             "group by d.name " +
		         "order by d.name asc")
	public abstract List<Object[]> findAvgOfDisciplineAllCoursesBySemesterAscOrder(String semester);
	
	
	@Query("select p.name, avg(c.grade), count(c.grade) from Professor p, Discipline d, UniClass c " +
	       "where c.id.profId = p.profId and " +
		         "c.id.discId = d.discId and " +
	             "c.id.semester = ?1 " +
		         "group by p.name")
	public abstract List<Object[]> findAvgAndNumberOfGradesBySemesterGroupByProfessor(String semester);
	
	
	@Query("select d.name, avg(c.grade) from Discipline d join d.courses co, UniClass c " +
	       "where co.name = ?1 and " +
		         "d.discId = c.id.discId and " +
	             "c.id.semester = ?2 " +
		         "group by d.name")
	public abstract List<Object[]> findAvgGradesByCourseAndSemesterGroupByDiscipline(String course, String semester);


	@Query("select sum(d.credits) from Discipline d, Student s, UniClass c " +
	       "where d.discId = c.id.discId and " +
		         "c.id.studentId = s.studentId and " +
	             "s.name = ?1 and " +
		         "c.grade >= 7")
	public abstract Long findCreditsByStudent(String student);
	
	
	@Query("select s.name, sum(d.credits) from Discipline d, Student s, UniClass c " +
	       "where c.id.discId = d.discId and " +
		         "c.id.studentId = s.studentId and " +
		         "c.grade >= 7 " +
		         "group by s.name " +
		         "having sum(d.credits) >= ?1")
	public abstract List<Object[]> findStudentAndCreditsGroupByStudentByTotalCredits(long totalCredits);
	
	
	@Query("select s.name, d.name, p.name from Student s, Discipline d join d.courses co, Professor p, UniClass c " +
	       "where c.id.studentId = s.studentId and " +
		         "c.id.profId = p.profId and " +
		         "c.id.discId = d.discId and " +
		         "s.course.courseId = co.courseId and " +
		         "c.id.semester = ?2 and " +
		         "c.grade > 8 and " +
		         "co.name = ?1")
	public abstract List<Object[]> findStudentDisciplineProfessorByCourseAndSemester(String course, String semester);

}