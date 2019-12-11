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
public interface IEtudiant {
    
    public ArrayList Rechercher(String name);
    public ArrayList Rechercher() ;
    public void ajouterEtudiant(Etudiant etudiant);
    public void modifierEtudiant(Etudiant etudiant) ;
    public void supprimerEtudiant(Etudiant etudiant);
    
}
