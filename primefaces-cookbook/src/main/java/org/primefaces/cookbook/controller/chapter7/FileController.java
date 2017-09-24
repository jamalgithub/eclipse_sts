package org.primefaces.cookbook.controller.chapter7;

import org.primefaces.cookbook.utils.FacesUtil;
import org.primefaces.cookbook.utils.MessageUtil;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * User: mertcaliskan
 * Date: 9/5/12
 */
@ManagedBean
@ViewScoped
public class FileController implements Serializable {

    private UploadedFile file;
    private StreamedContent downloadFile;
    private String destination;
    
    public FileController() {
        InputStream stream = this.getClass().getResourceAsStream("/chapter7/PFSamplePDF.pdf");
        downloadFile = new DefaultStreamedContent(stream, "application/pdf", "PFSample.pdf");
        //destination=FacesUtil.getUploadFolder("upload.folder");
        ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
        destination = servletContext.getRealPath("") +  File.separator + "resources" + File.separator + "upload";
    }

    public UploadedFile getFile() {
        return file;
    }
    
    public void setFile(UploadedFile file) {
        this.file = file;
    }    

    public String handleFileUpload2() {
        MessageUtil.addInfoMessage("upload.successful", file.getFileName() + " is uploaded.");
        // Do what you want with the file        
        try {
            copyFile(file.getFileName(), file.getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    
	public void handleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        MessageUtil.addInfoMessage("upload.successful", file.getFileName() + " is uploaded.");
        // Do what you want with the file        
        try {
            copyFile(file.getFileName(), file.getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StreamedContent getDownloadFile() {
        return downloadFile;
    }
    
    public void copyFile(String fileName, InputStream in) {
        try {
             // write the inputStream to a FileOutputStream
             OutputStream out = new FileOutputStream(new File(destination, fileName));
           
             int read = 0;
             byte[] bytes = new byte[1024];
           
             while ((read = in.read(bytes)) != -1) {
                 out.write(bytes, 0, read);
             }
           
             in.close();
             out.flush();
             out.close();
           
             System.out.println("New file created!");
         } catch (IOException e) {
        	 System.out.println(e.getMessage());
         }
    }
}