/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
public class ImagesView {
    
private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            images.add("musicien" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }    
    
}
