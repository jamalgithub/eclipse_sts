package org.primefaces.cookbook.controller.chapter7;

import org.primefaces.event.CaptureEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;

/**
 * User: mertcaliskan
 * Date: 9/10/12
 */
@ManagedBean
@SessionScoped
public class PhotoCamController implements Serializable {

    private StreamedContent capturedImage;

    public StreamedContent getCapturedImage() {
        return capturedImage;
    }

    public void setCapturedImage(StreamedContent capturedImage) {
        this.capturedImage = capturedImage;
    }

    public void onCapture(CaptureEvent captureEvent) {
        byte[] data = captureEvent.getData();
        capturedImage = new DefaultStreamedContent(new ByteArrayInputStream(data));
    }
    
    public void onCaptureWithSave(CaptureEvent captureEvent) {
		byte[] data = captureEvent.getData();
		capturedImage = new DefaultStreamedContent(new ByteArrayInputStream(data));
		ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
		String newFileName = servletContext.getRealPath("") +  File.separator + "resources" + 
				File.separator + "images" +  File.separator + "captured.png";
		FileImageOutputStream imageOutput;
		try {
		    imageOutput = new FileImageOutputStream(new File(newFileName));
		    imageOutput.write(data, 0, data.length);
		    imageOutput.close();
		}
		catch(Exception e) {
		    throw new FacesException("Error in writing captured image.", e);
		}
	}
}