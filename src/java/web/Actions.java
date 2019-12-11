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
public class Actions extends HttpServlet {

   private static Model studentOp;
            
   public Actions(){
       
       studentOp = new Model(); 
   }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        if (request.getParameter("delete") != null) {
            
           int id =Integer.parseInt(request.getParameter("id"));
           
           studentOp.setStudentId(id);
           studentOp.deleteStudent();
           System.out.println("You just removed the Student with ID : "+id+" from your datebase !");
           
           
        } else if (request.getParameter("edit") != null) {
                   int id =Integer.parseInt(request.getParameter("id"));
                    request.setAttribute("StoU", id);
                     System.out.println("You are going to Edit the Student Under ID :"+id);
         }
        
        request.getRequestDispatcher("EtudiantVue.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         
    }

    
    @Override
    public String getServletInfo() {
        return "This servlet updates or deletes the selected student based on the selected ID and the user choice";
    }// </editor-fold>

}
