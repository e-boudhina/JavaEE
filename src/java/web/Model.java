/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.ArrayList;
import métier.Etudiant;
import métier.EtudiantImpl;

/**
 *
 * @author e-boudhina
 */
public class Model {
    private Etudiant student;
    private ArrayList<Etudiant> students;
    private EtudiantImpl studentMethods ;
    
    
    public Model(){
         student = new Etudiant();
         students = new ArrayList<Etudiant>();
         studentMethods = new EtudiantImpl();
    }


    public void setStudentName(String student) {
        this.student.setNom(student);
    }
    
    
    public void setStudentNom(String student) {
        this.student.setNom(student);
    }
    
    public void setStudentPrenom(String student) {
        this.student.setPrenom(student);
    }
    
     public void setStudentId(int student) {
        this.student.setId(student);
    }

    public ArrayList<Etudiant> getStudentsByName() {
        return studentMethods.Rechercher(student.getNom());
    }

   public ArrayList<Etudiant> getAllStudents(){
       return studentMethods.Rechercher();
   }
   
   public void addStudent()
   { studentMethods.ajouterEtudiant(student);}
   
    public void deleteStudent()
   { studentMethods.supprimerEtudiant(student);}
    
    public void updateStudent()
   { studentMethods.modifierEtudiant(student);}
    
    
    
        /*
            "This class contains all Model to Database Operations that can be performed";
    */
    
}
