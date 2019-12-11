/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package métier;

import java.util.ArrayList;

/**
 *
 * @author e-boudhina
 */
public class Test {
   private static ArrayList<Etudiant> students;
   private static EtudiantImpl test;
   private static Etudiant student;
    public static void main(String[] args)
    {
     /*/   students = new ArrayList<Etudiant>();
         test = new EtudiantImpl();
        students = test.Rechercher("elyes");
        System.out.println("there is "+students.size()+" students with that name");
         System.out.println("the first student found with that first name is called : "+students.get(0).getPrenom());
*/
        test = new EtudiantImpl();
        student = new Etudiant();
       /*
        student.setNom("test");
        student.setPrenom("test");
        test.ajouterEtudiant(student);
        */
        student.setId(9);
        test.supprimerEtudiant(student);
    }
    
}
