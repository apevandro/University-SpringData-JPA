package br.com.university.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component("uniClassRepository")
public class UniClassRepositoryImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public Object[] findMinMaxGradeByDisciplineNameAndSemester(String discipline, String semester) {
		
		String query = "select min(c.grade), max(c.grade) from UniClass c, Discipline d " + 
				       "where d.name = :name and " + 
				             "d.discId = c.id.discId and " + 
				             "c.id.semester = :semester";

		Object[] result = entityManager.createQuery(query, Object[].class)
                                       .setParameter("name", discipline)
                                       .setParameter("semester", semester)
                                       .getResultList().get(0);

		return result;
	}
	
    public Object[] findStudentNameMaxGradeByDisciplineNameAndSemester(String discipline, String semester) {
		
    	String query = "select s.name, c.grade from Student s, UniClass c, Discipline d " +
		               "where c.id.studentId = s.studentId and " +
			                 "c.id.discId = d.discId and " +
			                 "d.name = :name and " +
			                 "c.id.semester = :semester and " +
			                 "c.grade in ( select max(c.grade) from Student s, UniClass c, Discipline d " +
			                              "where c.id.studentId = s.studentId and " +
			                                    "c.id.discId = d.discId and " +
			                                    "d.name = :name and " +
			                                    "c.id.semester = :semester )";

		Object[] result = entityManager.createQuery(query, Object[].class)
                                       .setParameter("name", discipline)
                                       .setParameter("semester", semester)
                                       .getResultList().get(0);

		return result;
	}
    
    public Object[] findAvgGradeAndNumberOfClassesByStudentAndSemester(String student, String semester) {

    	String query = "select avg(c.grade), count(c.id.studentId) from Student s, UniClass c " +
		               "where s.name = :name and " +
			                 "s.studentId = c.id.studentId and " +
		                     "c.id.semester = :semester";

    	Object[] result = entityManager.createQuery(query, Object[].class)
                                       .setParameter("name", student)
                                       .setParameter("semester", semester)
                                       .getResultList().get(0);

    	return result;
    }

}