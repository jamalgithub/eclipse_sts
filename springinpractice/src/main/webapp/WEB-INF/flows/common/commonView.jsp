<%@ include file="/WEB-INF/jsp/taglibs.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns:jsp="http://java.sun.com/JSP/Page">

  <head><title>Common View</title></head>

  <body>
    <h2>Common View</h2>
    <p>
      This is a demo of a view that is inherited from a
      another flow.  
    </p>
    <a href="${flowExecutionUrl}&_eventId=${previousEventId}">Back</a>    
      
     <br/>
     <c:out value="${flowExecutionContext.viewScope['joshTest']}"/>
             
  </body>
</html>
