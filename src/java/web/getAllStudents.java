/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import métier.Etudiant;

/**
 *
 * @author e-boudhina
 */
public class getAllStudents extends HttpServlet {

    
    private static Model databaseOp;
    private static ArrayList<Etudiant> students;
   
    

   public getAllStudents(){
       students = new ArrayList<Etudiant>();
        
        databaseOp = new Model();
   }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    try{
            
         
        
       
        students = databaseOp.getAllStudents();
        
        request.setAttribute("Students", students);
        request.getRequestDispatcher("EtudiantVue.jsp").forward(request, response);
        
        
        
        }catch(Exception e){
            
            request.setAttribute("exception", e);
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }
        
    }

   
    @Override
    public String getServletInfo() {
        return "This servlet extracts all students from database and send them to JSP page";
    }// </editor-fold>

}
