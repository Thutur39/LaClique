/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Maxence
 */
@Named
@SessionScoped
public class FileUploadControl implements Serializable {

    private final String destination = "C:\\upload\\";
    private UploadedFile file;
   

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public FileUploadControl() {
    }

    public void TransferFile(String fileName, InputStream in) throws FileNotFoundException, IOException {
        try {
            
            OutputStream out = new FileOutputStream(new File(destination + fileName));
            int reader = 0;
            byte[] bytes = new byte[(int) getFile().getSize()];
            while ((reader = in.read(bytes)) != -1) {
                out.write(bytes, 0, reader);
            }
            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void upload() {
        String extValidate;

        if (getFile() != null) {
            String ext = getFile().getFileName();
            
            if (ext != null) {
                extValidate = ext.substring(ext.indexOf(".") + 1);

            } else {
                extValidate = "null";
            }
            if (getFile().getSize() >= 500000) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Erreur votre fichier est trop volumineux", getFile().getSize() + " Ko."));
            } else if (extValidate.equals("jpg") || extValidate.equals("png")) {
                try {
                   
                    TransferFile(getFile().getFileName(), getFile().getInputstream());

                } catch (IOException ex) {
                    Logger.getLogger(FileUploadControl.class.getName());

                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("erreur d'upload"));

                }
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Succès", getFile().getFileName() + " is uploaded."));
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Erreur", "votre fichier n'a pas un format valide"));
            }

        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erreur", "S'il vous plaît selectionnez une photo"));
        }

    }
    
    

}
