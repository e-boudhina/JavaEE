/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package métier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author e-boudhina
 */
public class EtudiantImpl implements IEtudiant {

    private Conn cnObject;
    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;
    private int nbrow;
    
     ArrayList<Etudiant> students;
     Etudiant student;
     
    
    public EtudiantImpl(){
        
        cnObject =  new Conn();
        //ps = null;
        //rs = null;
    }
    
    @Override
    public ArrayList Rechercher(String name) {
        cn =  cnObject.getConn();
        
        students = new ArrayList<Etudiant>();
        //student = new Etudiant(); 
        /*you must not declare students arraylist here , beacause later on it will cause problems when you add it to the array list 
        it will keep on adding the same student for unknow reasons even you make a student then override it later it does not change 
        so you must declare it right inside rs.next when you need it 
        */
        
        try {
            
            String x="select * from etudiant where nom = ?";
            ps=cn.prepareStatement(x,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //ps=cn.prepareStatement("select * from etudiant where nom like ?");
            
            
            ps.setString(1, name);
            rs = ps.executeQuery();
            rs.last();
             nbrow =rs.getRow();
            
            if ( nbrow!=0)
            {
                rs.beforeFirst();
                
                for (int i=0;i<nbrow;i++){
                   while(rs.next()){
                       student = new Etudiant();
                       student.setId(rs.getInt(1));
                       student.setNom(rs.getString(2));
                       student.setPrenom(rs.getString(3));
                       students.add(student);
                   } 
                   
                }
                 System.err.println("There are "+nbrow+" students under the name \""+name+"\"");
            }else {
                System.err.println("There is no students under the name \""+name+"\"");
                System.err.println(+nbrow+" Results found with that name !");
            }
            return students;
        }catch(Exception e){
            System.err.println("Something went wrong !");
            return null;
        }
      
    }
    
    public ArrayList Rechercher() {
        cn =  cnObject.getConn();
        
        students = new ArrayList<Etudiant>();
        //student = new Etudiant(); 
        /*you must not declare students arraylist here , beacause later on it will cause problems when you add it to the array list 
        it will keep on adding the same student for unknow reasons even you make a student then override it later it does not change 
        so you must declare it right inside rs.next when you need it 
        */
        
        try {
            
            String x="select * from etudiant";
            ps=cn.prepareStatement(x,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //ps=cn.prepareStatement("select * from etudiant where nom like ?");
            
            
            
            rs = ps.executeQuery();
            rs.last();
             nbrow =rs.getRow();
            
            if ( nbrow!=0)
            {
                rs.beforeFirst();
                
                for (int i=0;i<nbrow;i++){
                   while(rs.next()){
                       student = new Etudiant();
                       student.setId(rs.getInt(1));
                       student.setNom(rs.getString(2));
                       student.setPrenom(rs.getString(3));
                       students.add(student);
                   } 
                   
                }
                 
            }else {
                System.err.println("There is no students in your DataBase");
                
            }
            return students;
        }catch(Exception e){
            System.err.println("Something went wrong !");
            return null;
        }
      
    }
    
    public void ajouterEtudiant(Etudiant etudiant) {
       cn =  cnObject.getConn();
       
        try {
            ps=cn.prepareStatement("insert into etudiant(nom,prénom) values (?,?)");
            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.executeUpdate();
          System.out.println("Student Added Succesfully !");
            //ps.close();
           // cn.close();
            
        }
        catch(Exception e){
            System.err.println("Something went wrong !");
            
            
            
        }
    }
    
    public void modifierEtudiant(Etudiant etudiant) {
       cn =  cnObject.getConn();
       
        try {
            System.err.println("New Last Name : "+etudiant.getNom()+"\nNew First Name : "+etudiant.getPrenom()+" \nID : "+etudiant.getId());
            ps=cn.prepareStatement("update etudiant set nom=?,prénom=? where id like ?");
            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setInt(3,etudiant.getId());
            ps.executeUpdate();
            System.out.println("Student updated Succesfully !");
            //i don't know why but if you execute multiple updates closing preperaed statement and connection invokes database errors meaning that it fails to update sometimes 
            //for for now keep them turned off
            //ps.close();
            //cn.close();
            
        }
        catch(Exception e){
            System.err.println("Something went wrong !");
            System.err.println("here !");
            
            
        }
    }
    
    public void supprimerEtudiant(Etudiant etudiant) {
       cn =  cnObject.getConn();
       
        try {
            ps=cn.prepareStatement("delete from etudiant where id=?");
            ps.setInt(1, etudiant.getId());
            ps.executeUpdate();
            System.out.println("Student deleted Succesfully !");
            //ps.close();
            //cn.close();
            
        }
        catch(Exception e){
            System.err.println("Something went wrong !");
            
            
            
        }
    }
    
    
}
