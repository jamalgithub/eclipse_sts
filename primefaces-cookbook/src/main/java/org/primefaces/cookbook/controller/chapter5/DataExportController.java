package org.primefaces.cookbook.controller.chapter5;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.cookbook.model.chapter5.CountryList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.List;

/**
 * User: mertcaliskan
 * Date: 8/28/12
 */
@ManagedBean
@ViewScoped
public class DataExportController implements Serializable {

    private String[] selectedCountries;
    
    public List<String> getCountries() {
        return CountryList.countries;
    }

    public void preProcessPDF(Object document) throws BadElementException, MalformedURLException, DocumentException, IOException {
        Document pdf = (Document) document;         
        HeaderFooter footer = new HeaderFooter(new Phrase("This is page: "), true);        
        pdf.setFooter(footer);
        ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
		String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + File.separator + "images" + File.separator + "logo.png";
		pdf.open();
		pdf.add(Image.getInstance(logo));
    }
    
    public void postProcessXLS(Object document) {
    	HSSFWorkbook wb = (HSSFWorkbook) document;
    	HSSFSheet sheet = wb.getSheetAt(0);
    	HSSFRow header = sheet.getRow(0);
    	HSSFCellStyle cellStyle = wb.createCellStyle();  
    	cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
    	cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    	for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
    		header.getCell(i).setCellStyle(cellStyle);
    	}
    }

    public String[] getSelectedCountries() {
        return selectedCountries;
    }

    public void setSelectedCountries(String[] selectedCountries) {
        this.selectedCountries = selectedCountries;
    }
}