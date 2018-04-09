package com.robotson.ejb;

import com.robotson.javabeans.Preference;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@LocalBean
@Stateless
public class PreferenceEjb {

    
    
    @PersistenceContext
    private EntityManager em;

    //liste de preference
    public List<Preference> getListerPreference() {
        Query query = em.createQuery("SELECT p FROM Preference p");   
        return query.getResultList();
    }
    
    //ajouter et editer une Preference
    public void editerPreferenceEjb(Preference p) {
        em.merge(p);      
    }

    
      //supprimer 
     public void supprimer(Preference p) {
        em.remove(em.merge(p));     
    }
    
    //supprimer Rest
    public Preference getPreferenceById(int id) {
        Preference p;
        p = em.find(Preference.class, id);
        return p;
    }
   
    
  
}