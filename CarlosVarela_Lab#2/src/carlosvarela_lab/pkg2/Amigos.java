/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlosvarela_lab.pkg2;

/**
 *
 * @author carlo
 */
public class Amigos {
    
    String Minombre, amigo;
    
    public Amigos(String Minombre, String amigo){
        this.Minombre = Minombre;
        this.amigo = amigo;
    }
    
    public String toString(){
        return amigo;
    }
    
    public String getMinombre(){
        return Minombre;
    }
    
    public String getNomAmigo(){
        return amigo;
    }
}
