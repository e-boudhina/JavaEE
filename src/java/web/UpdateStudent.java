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

/**
 *
 * @author e-boudhina
 */
public class UpdateStudent extends HttpServlet {

   public static Model studentOp;
   
   public UpdateStudent()
{
   
    studentOp = new Model();
    
}
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
           
        int id = Integer.parseInt(request.getParameter("id"));
         
        String nn =request.getParameter("newnom");
        
        String np =request.getParameter("newprenom");
        
        
        studentOp.setStudentId(id);
        studentOp.setStudentName(nn);
        studentOp.setStudentPrenom(np);
        //the student object is passed in the model 
        studentOp.updateStudent();
        request.getRequestDispatcher("EtudiantVue.jsp").forward(request, response);
        
    }catch(Exception e){
            request.setAttribute("exception", e);
            request.getRequestDispatcher("error.jsp").forward(request, response);
    }
    }
    

   
    @Override
    public String getServletInfo() {
        return "This servlet updates the select student with new inputs.";
    }// </editor-fold>

}
