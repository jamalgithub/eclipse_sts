package com.jamal.jsf.i18n;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class LocalBean {
	
   private String locale="fr";
   private static Map<String,Object> countries;
   
   static{
      countries = new LinkedHashMap<String,Object>();      
      countries.put("fr", Locale.FRENCH);
      countries.put("en", Locale.ENGLISH);
   }

   public Map<String, Object> getCountries() {
      return countries;
   }

   public String getLocale() {
      return locale;
   }

   public void setLocale(String locale) {
      this.locale = locale;
   }

   //value change event listener
   public void localeChanged(ValueChangeEvent e){
      String newLocaleValue = e.getNewValue().toString();
      for (Map.Entry<String, Object> entry : countries.entrySet()) {
         if(entry.getValue().toString().equals(newLocaleValue)){
            FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale)entry.getValue());         
         }
      }
   }
}
