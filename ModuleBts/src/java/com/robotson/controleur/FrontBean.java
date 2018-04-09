/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robotson.controleur;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

/**
 *
 * @author Maxence
 */
@Named
@RequestScoped
public class FrontBean {

     
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            images.add("musique" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        System.out.println("Dans getter image");
        return images;
    }

    
}
