<%-- Source project: sip05, branch: 03 (Maven Project) --%>
<%@ include file="/WEB-INF/jsp/taglibs.jspf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns:jsp="http://java.sun.com/JSP/Page">
  
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  	<title>Find Existing Player(s)</title>
  </head>
  
  <body>
    <h2>Find Existing Player(s)</h2>          
    <p>
      Has anyone in your family registered with us in the past?  If so, enter your information below:
    </p>
      
    <form:form modelAttribute="playerSearchCriteria" action="${flowExecutionUrl}">         
      <label for="firstname">Player First Name</label>
      <form:input path="firstName" /><br/>
                      
      <label for="lastName">Player Last Name</label>
      <form:input path="lastName" /><br/>
    
      <label for="birthDate">Birth Date</label>
      <form:input path="birthDate" /><br/>  
          
      <label for="homePhone">Home Phone:</label>
      <form:input path="homePhone" /><br/>
    
      <input type="submit" name="_eventId_skip" value="Skip"/>
      <input type="submit" name="_eventId_find" value="Find"/>            
    </form:form>
      
  </body>
</html>