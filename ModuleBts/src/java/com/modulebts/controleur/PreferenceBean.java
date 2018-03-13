/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modulebts.controleur;

import com.modulebts.javabeans.Preference;
import com.modulebts.ejb.PreferenceBeanEJB;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author drack
 */
public class PreferenceBean {

    @EJB
    private PreferenceBeanEJB ejb;

    @PersistenceContext
    EntityManager em;
    
    private Preference preference = new Preference();
}
