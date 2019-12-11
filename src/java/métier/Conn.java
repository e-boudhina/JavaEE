/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package métier;

import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author e-boudhina
 */
public class Conn{ 
        
    private Connection conn ;

    public Connection getConn() {
        return conn;
    }
    
    //note if you to not put the connection inside try and catch you must use => throws SQLException <= or else it woudln't work 
     public Conn() {
         
  //public static void main(String[] args)
    try {
        //omg i wasted 3 hours serching for this one ,Class.forName loads mysql Driver with out it the connection to MySQL woudln't work 
        Class.forName("com.mysql.jdbc.Driver"); 
    this.conn =   DriverManager.getConnection("jdbc:mysql://localhost:3306/db_gestion?zeroDateTimeBehavior=convertToNull","root","07219567");
    
    System.out.println("Successfull Connection To Your DataBase : \n");
    System.out.println("Current database is : \"db_gestion\" => 'etudiant' .");
    
    
         }catch(Exception e)
         {
             System.err.println(e);    
             
         }
    
     }
     
     
                }
