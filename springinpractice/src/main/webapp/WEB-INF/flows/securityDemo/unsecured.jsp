<%@ include file="/WEB-INF/jsp/taglibs.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html  xmlns:jsp="http://java.sun.com/JSP/Page">

  <head><title>Unsecured Page</title></head>

  <body>
    <h2>Unsecured</h2>

    <p>
      This page is unsecured.  Please click the button below 
      to visit the secured page.
    </p>


      <input type="button" value="Go To Secured View" onClick="window.location.href='${flowExecutionUrl}&_eventId=next';"/>
  </body>
</html>
