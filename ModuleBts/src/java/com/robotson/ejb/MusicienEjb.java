package com.robotson.ejb;

import com.robotson.javabeans.Musicien;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@LocalBean
@Stateless
public class MusicienEjb {

    
    
    @PersistenceContext
    private EntityManager em;

    //liste de musicien
    public List<Musicien> getListerMusicien() {
        Query query = em.createQuery("SELECT m FROM Musicien m");
        return query.getResultList();
    }
    
    //ajouter un musicien
    public void editerMusicienEjb(Musicien m) {
        em.merge(m);
    }
   
      //supprimer 
     public void supprimer(Musicien m) {
        em.remove(em.merge(m));
    }
    
    //supprimer Rest
    public Musicien getMusicienById(int id) {
        Musicien m;
        m = em.find(Musicien.class, id);
        return m;
    }
   

}