/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robinsjolundinlamning4.businesslogic;

import com.mycompany.robinsjolundimlamning4.entities.Betyg;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Robin_000
 */
@Stateless
public class BetygFacade extends AbstractFacade<Betyg> {

    @PersistenceContext(unitName = "com.mycompany_RobinSjolundImlamning4_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public BetygFacade() {
        super(Betyg.class);
    }
    
    public List<Betyg> findStudentsByCourse(int id){
        TypedQuery<Betyg> q = em.createNamedQuery("Betyg.findByKursid", Betyg.class);
        q.setParameter("kursid", id);
       
        return q.getResultList(); 
    }
    
    public Betyg findStudentByIdAndCourse(int studentid, int courseid){
        TypedQuery<Betyg> q = em.createNamedQuery("Betyg.findByKursAndStudentId", Betyg.class);
        q.setParameter("studentid", studentid);
        q.setParameter("kursid", courseid);
        return q.getSingleResult();
    }
    
}
