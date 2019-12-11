<%-- 
    Document   : error
    Created on : Nov 17, 2019, 2:10:14 PM
    Author     : e-boudhina
--%>

<%@page import="java.io.PrintStream"%>
<%@page isErrorPage="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
       
            
      <h1>Opps...</h1>
      <p>Sorry, an error occurred.</p>
      <p>Here is the exception stack trace: </p>
      <p>Make sure that <b>"Student name"</b> is valid "String" not a "Number"</p>
      <%=request.getAttribute("exception") %>
   </body>
</html>

