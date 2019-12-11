/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import métier.Etudiant;

/**
 *
 * @author e-boudhina
 */
public class AddStudent extends HttpServlet {

   
    public static Model studentOp;
    
public AddStudent()
{
   
    studentOp = new Model();
    
}
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       try{
           
        String n =request.getParameter("nom");
        String p =request.getParameter("prenom");
        
        studentOp.setStudentName(n);
        studentOp.setStudentPrenom(p);
        //the student object is passed in the model 
        studentOp.addStudent();
        request.getRequestDispatcher("EtudiantVue.jsp").forward(request, response);
        }catch(Exception e){
            request.setAttribute("exception", e);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        }
    
    @Override
    public String getServletInfo() {
        return "This servlet gets the user student input info and add it to database";
    }// </editor-fold>

}
