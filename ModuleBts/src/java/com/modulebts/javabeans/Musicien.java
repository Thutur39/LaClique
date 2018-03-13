/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modulebts.javabeans;

/**
 *
 * @author Maxence
 */


public class Musicien {
    
private int idMusicien;
private String nom;
private Boolean laser;
private Boolean camera;
private String image;

//Construc
public Musicien(int idMusicien, String nom, Boolean laser, Boolean camera, String image) {
        this.idMusicien = idMusicien;
        this.nom = nom;
        this.laser = laser;
        this.camera = camera;
        this.image = image;
    }

//Getter and Setter Musicien (Auto gen)
    public int getIdMusicien() {
        return idMusicien;
    }

    public void setIdMusicien(int idMusicien) {
        this.idMusicien = idMusicien;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getLaser() {
        return laser;
    }

    public void setLaser(Boolean laser) {
        this.laser = laser;
    }

    public Boolean getCamera() {
        return camera;
    }

    public void setCamera(Boolean camera) {
        this.camera = camera;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    
    
}
