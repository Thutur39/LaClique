package com.modulebts.javabeans;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Stateless
public class Preference implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPreference;
    private String nomPreference;

//get set
    public String getNomPreference() {
        return nomPreference;
    }

    public void setNomPreference(String nomPreference) {
        this.nomPreference = nomPreference;
    }

    public int getIdPreference() {
        return idPreference;
    }

    public void setIdPreference(int idPreference) {
        this.idPreference = idPreference;
    }
}
