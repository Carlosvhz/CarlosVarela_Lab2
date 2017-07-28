/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlosvarela_lab.pkg2;

import java.util.*;
/**
 *
 * @author carlo
 */
public class Usuario {
    
    String nombre, username, hometown, password;
    int edad;
    
    public Usuario (String nombre, String username, String hometown, String password, int edad){
        this.nombre = nombre;
        this.hometown = hometown;
        this.username = username;
        this.password = password;
        this.edad = edad;
    }
    
    //Sets
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setHometown(String hometown){
        this.hometown = hometown;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setOld(int edad){
        this.edad = edad;
    }
    
    
    //Gets
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    @Override
    public String toString() {
        return "{ "+"Nombre: "+nombre+"| Username: "+username+"| hometown: "+hometown+" | edad: "+edad+" }";
    }
    
    
}
