/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robinsjolundinlamning4.businesslogic;

import com.mycompany.robinsjolundimlamning4.entities.Studenter;
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
public class StudenterFacade extends AbstractFacade<Studenter> {

    @PersistenceContext(unitName = "com.mycompany_RobinSjolundImlamning4_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public StudenterFacade() {
        super(Studenter.class);
    }
    
    public List<Studenter> findLazyStudents(){
        TypedQuery<Studenter> q = em.createNamedQuery("Studenter.findLazyStudents", Studenter.class);
        return q.getResultList();
    }
    
   
   
}
