package br.com.university.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.university.Course;
import br.com.university.Discipline;
import br.com.university.Professor;
import br.com.university.Student;
import br.com.university.repository.CourseRepository;
import br.com.university.repository.DisciplineRepository;
import br.com.university.repository.ProfessorRepository;
import br.com.university.repository.StudentRepository;
import br.com.university.repository.UniClassRepository;

@Service(value="universityService")
public class UniversityServiceImpl implements UniversityService {

	@Autowired private CourseRepository courseRepository;
	
	@Autowired private StudentRepository studentRepository;
	
	@Autowired private ProfessorRepository professorRepository;
	
	@Autowired private DisciplineRepository disciplineRepository;
	
	@Autowired private UniClassRepository uniClassRepository;

	@Override
	public List<Course> questionA() {
		return courseRepository.findAll();
	}
	
	@Override
	public List<Student> questionB(String city) {
		return studentRepository.findByAddressCityOrderByNameDesc(city);
	}

	@Override
	public List<Professor> questionC(LocalDate admission) {
		return professorRepository.findByAdmissionBefore(admission);
	}

	@Override
	public List<Student> questionD(String letter) {
		return studentRepository.findByNameStartingWith(letter);
	}

	@Override
	public List<Discipline> questionE(String course) {
		return disciplineRepository.findByCoursesName(course);
	}

	@Override
	public List<Course> questionF(String discipline) {
		return courseRepository.findByDisciplinesName(discipline);
	}

	@Override
	public List<Discipline> questionG(String student, String semester) {
		return disciplineRepository.findByUniClassesStudentNameAndUniClassesIdSemester(student, semester);
	}
	
	@Override
	public List<Discipline> questionH(String student, double grade) {
		return disciplineRepository.findByUniClassesStudentNameAndUniClassesGradeLessThan(student, grade);
	}
	
	@Override
	public List<Student> questionI(String discipline, String semester, double grade) {
		return studentRepository
			       .findByUniClassesDisciplineNameAndUniClassesIdSemesterAndUniClassesGradeLessThan
			           (discipline, semester, grade);
	}
	
	@Override
	public List<Discipline> questionJ(String professor) {
		return disciplineRepository.findDistinctByUniClassesProfessorName(professor);
	}
	
	@Override
	public List<Professor> questionK(String discipline) {
		return professorRepository.findDistinctByUniClassesDisciplineName(discipline);
	}

	@Override
	public Object[] questionL(String discipline, String semester) {
		return uniClassRepository.findMinMaxGradeByDisciplineNameAndSemester(discipline, semester);
	}
	
	@Override
	public Object[] questionM(String discipline, String semester) {
		return uniClassRepository.findStudentNameMaxGradeByDisciplineNameAndSemester(discipline, semester);
	}
	
	@Override
	public List<Object[]> questionN(String semester) {
		return uniClassRepository.findStudentDisciplineProfessorBySemesterAscOrder(semester);
	}
	
	@Override
	public List<Object[]> questionO(String course, String semester) {
		return uniClassRepository.findStudentDisciplineGradeByCourseAndSemester(course, semester);
	}

	@Override
	public Double questionP(String professor) {
		return uniClassRepository.findAvgGradeByProfessor(professor);
	}
	
	@Override
	public List<Object[]> questionQ(Double min, Double max) {
		return uniClassRepository.findStudentDisciplineGradeByIntervalGradeAscOrder(min, max);
	}
	
	@Override
	public Double questionR(String discipline, String semester) {
		return uniClassRepository.findAvgGradeByDisciplineAndSemester(discipline, semester);
	}
	
	@Override
	public Long questionS(String professor, String semester) {
		return uniClassRepository.findNumberStudentsByProfessorAndSemester(professor, semester);
	}
	
	@Override
	public Object[] questionT(String student, String semester) {
		return uniClassRepository.findAvgGradeAndNumberOfClassesByStudentAndSemester(student, semester);
	}
	
	@Override
	public List<Object[]> questionU(String semester) {
		return uniClassRepository.findAvgOfDisciplineAllCoursesBySemesterAscOrder(semester);
	}
	
	@Override
	public List<Object[]> questionV(String semester) {
		return uniClassRepository.findAvgAndNumberOfGradesBySemesterGroupByProfessor(semester);
	}
	
	@Override
	public List<Object[]> questionW(String course, String semester) {
		return uniClassRepository.findAvgGradesByCourseAndSemesterGroupByDiscipline(course, semester);
	}

	@Override
	public Long questionX(String student) {
		return uniClassRepository.findCreditsByStudent(student);
	}

	@Override
	public List<Object[]> questionY(long totalCredits) {
		return uniClassRepository.findStudentAndCreditsGroupByStudentByTotalCredits(totalCredits);
	}

	@Override
	public List<Object[]> questionZ(String course, String semester) {
		return uniClassRepository.findStudentDisciplineProfessorByCourseAndSemester(course, semester);
	}

}