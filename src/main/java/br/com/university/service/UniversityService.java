package br.com.university.service;

import java.time.LocalDate;
import java.util.List;

import br.com.university.Course;
import br.com.university.Discipline;
import br.com.university.Professor;
import br.com.university.Student;

public interface UniversityService {
	public abstract List<Course> questionA();
	public abstract List<Student> questionB(String city);
	public abstract List<Professor> questionC(LocalDate admission);
	public abstract List<Student> questionD(String letter);
	public abstract List<Discipline> questionE(String course);
	public abstract List<Course> questionF(String discipline);
	public abstract List<Discipline> questionG(String student, String semester);
	public abstract List<Discipline> questionH(String student, double grade);
	public abstract List<Student> questionI(String discipline, String semester, double grade);
	public abstract List<Discipline> questionJ(String professor);
	public abstract List<Professor> questionK(String discipline);
	public abstract Object[] questionL(String discipline, String semester);
	public abstract Object[] questionM(String discipline, String semester);
	public abstract List<Object[]> questionN(String semester);
	public abstract List<Object[]> questionO(String course, String semester);
	public abstract Double questionP(String professor);
	public abstract List<Object[]> questionQ(Double min, Double max);
	public abstract Double questionR(String discipline, String semester);
	public abstract Long questionS(String professor, String semester);
	public abstract Object[] questionT(String student, String semester);
	public abstract List<Object[]> questionU(String semester);
	public abstract List<Object[]> questionV(String semester);
	public abstract List<Object[]> questionW(String course, String semester);
	public abstract Long questionX(String student);
	public abstract List<Object[]> questionY(long totalCredits);
	public abstract List<Object[]> questionZ(String course, String semester);
}