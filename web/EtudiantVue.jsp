<%-- 
    Document   : EtudiantVue.jsp
    Created on : Nov 17, 2019, 1:38:08 PM
    Author     : e-boudhina
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="métier.Etudiant"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! ArrayList<Etudiant> students = new ArrayList<Etudiant>();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search/Read | Add | Update | Delete | Students</title>
    </head>
    <body>
        <br>
        <h1 style="text-align: center;">Search/Read | Add | Update | Delete => Students <=</h1>
        <br><br>
        <form action="getStudentsByname" method="POST">
            <b>Nom :</b>
            <input type="text" maxlength="20" placeholder="Student Name" name="Sname"/>
            <input type="submit" value="Chercher"/>
        </form>
        <br>
        <br>
        <form action="getAllStudents" method="POST">
            <b>Afficher la liste complete des étudiants</b>
            
            <input type="submit" value="Chercher"/>
        </form>
        <br>
        <form action="AddStudent" method="POST">
            <br><br>
            <b>Ajouter un étudiant :</b>
            
            <br><br>
            <table border="1">
                <tr>
                    <td>Nom : </td>
                    <td><input type="text" maxlength="20" placeholder="Nom" name="nom"/></td>
                </tr>
                <tr>
                    <td>Prénom</td>
                    <td><input type="text" maxlength="20" placeholder="Prénom" name="prenom"/></td>
                </tr>
                <tfooter>
                    <td align="margin: 20px auto;"><input type="submit" value="Save"/></td>
                </tfooter>
            </table>
            
        </form>
        <br>
        
        <% 
            //not that this is not necessary to recover the attribute sending it from the servlet is enough 
                 request.getAttribute("Students");
        %>
        <% if (request.getAttribute("Students") !=null){%>
        
        <b>You have </b> <em style="color:green; font-size: 1.5em;">${Students.size()} </em>  <b style="color:red;">results</b>
        
        <table border="1">
            <caption>Students List</caption>
            <thead>
                
                <tr>
                    <th style="width:150px">ID</th>
                    <th style="width:150px">Nom</th>
                    <th style="width:150px">Prénom</th>
                    <th style="width:150px;">Actions</th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach items="${Students}" var="student">
                <tr>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.nom}"/></td>
                <td><c:out value="${student.prenom}"/></td>
                <td style="margin-left: 50%;">
                    <form action="Actions" method="get" >
                    <input type="submit" name="edit" value="Edit" />
                    <input type="submit" name="delete" value="Delete" />
                    <input type="hidden"  name="id" value="${student.id}">
                    
                    </form>
                </td>
                </tr>
                </c:forEach>
              
                
            </tbody>
        </table>
        
        <% } %>

               
       
        
        <br><br>
        <% 
            //not that this is not necessary to recover the attribute sending it from the servlet is enough 
                 request.getAttribute("StoU");
        %>
        <% if (request.getAttribute("StoU") !=null){%>
        <b>Modifier les information d'étudiant sous  <em style="color:green; font-size: 1.5em;">ID </em> <b style="color:red;font-size: 2em;"><%=request.getAttribute("StoU") %></b> :</b>
        <br><br>
        <form action="UpdateStudent" method="POST">
            <table border="1">
                <tr>
                    <td>Nouveau Nom : </td>
                    <td><input type="text" maxlength="20" placeholder="Nouveau Nom" name="newnom"/></td>
                </tr>
                <tr>
                    <td>Nouveau Prénom</td>
                    <td><input type="text" maxlength="20" placeholder="Nouveau Prénom" name="newprenom"/></td>
                </tr>
                <tfooter>
                    <td align="margin: 20px auto;"><input type="submit" value="Save"/></td>
                    <td><input type="hidden"  name="id" value="<%=request.getAttribute("StoU")%>"></td>
                </tfooter>
            </table>
        </form>
        <% } %>
        
        
        
        
        
        
      

    </body>
</html>
