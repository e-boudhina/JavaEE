/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
public class getStudentsByname extends HttpServlet {
    private static String studentName;
   private static Model databaseOp;
    private static ArrayList<Etudiant> students;
    
    public getStudentsByname(){
        studentName ="";
        
        students = new ArrayList<Etudiant>();
        
        databaseOp = new Model();
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // response.setContentType("text/html;charset=UTF-8");
        try{
            
        // PrintWriter out = response.getWriter();
        studentName  = request.getParameter("Sname");
        databaseOp.setStudentName(studentName);
        
        students = databaseOp.getStudentsByName();
        
        request.setAttribute("Students", students);
        request.getRequestDispatcher("EtudiantVue.jsp").forward(request, response);
        //out.println(students.get(0).getPrenom());
       // out.println("Name to search is "+studentName+"<br>");
        
       // out.println("there is "+students.size()+" students with that name");
       // out.println("his last name is  "+students.get(0).getPrenom());
        
        
        }catch(Exception e){
            
            request.setAttribute("exception", e);
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet extracts the student name from the JSP then parse that "
                + "to model which search the student name and returns "
                + "the results that is then fowarded to the JSP in an Arraylist form to be further ajusted";
    }// </editor-fold>

}
