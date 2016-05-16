package com.mycompany.robinsjolundinlamning4.businesslogic;

import com.mycompany.robinsjolundimlamning4.entities.Betyg;
import com.mycompany.robinsjolundimlamning4.entities.BetygPK;
import com.mycompany.robinsjolundimlamning4.entities.Kurser;
import com.mycompany.robinsjolundimlamning4.entities.Studenter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

/**
 *
 * @author Robin_000
 */
@Stateless
public class Boundry {

    @Inject
    BetygFacade betygFacade;

    @Inject
    KurserFacade kurserFacade;

    @Inject
    StudenterFacade studenterFacade;

    public List<Kurser> findAllCourses() {
        return new ArrayList<Kurser>(kurserFacade.findAll());
    }

    public Kurser findCourseById(int id) {
        return kurserFacade.find(id);
    }

    public List<Betyg> findStudentsByCourse(int id) {
        return betygFacade.findStudentsByCourse(id);
    }

    public Studenter findStudentById(int id) {
        return studenterFacade.find(id);
    }

    public void gradeStudent(int student, int course, String grade) {
        Betyg b = betygFacade.findStudentByIdAndCourse(student, course);
        b.setBetyg(grade);
        betygFacade.edit(b);
    }

    public List<Studenter> findAllStudents() {
        return new ArrayList<Studenter>(studenterFacade.findAll());
    }

    public List<Betyg> findAllGrades() {
        return new ArrayList<Betyg>(betygFacade.findAll());
    }

    public List<Studenter> findLazyStudents() {
        return studenterFacade.findLazyStudents();
    }

    public List<Kurser> findStudentlessCourses() {
        return kurserFacade.findStudentLessCourses();
    }

    public void deleteStudent(int id) {
        studenterFacade.remove(studenterFacade.find(id));
    }

    public void deleteCourse(int id) {
        kurserFacade.remove(kurserFacade.find(id));
    }
    
    public void addStudent(String namn) {
        Studenter s = new Studenter();
        s.setNamn(namn);
        studenterFacade.create(s);
    }
    
    public void addCourse(String namn) {
        Kurser k = new Kurser();
        k.setNamn(namn);
        kurserFacade.create(k);
    }
            
}
