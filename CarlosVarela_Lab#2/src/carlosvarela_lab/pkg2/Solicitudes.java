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
public class Solicitudes {
    
    String receptor, emisor;
    int estado;
    
    public Solicitudes(String receptor, String emisor, int estado){
        this.receptor = receptor;
        this.emisor = emisor;
        this.estado = estado;
    }
    
    public void setEstado(int estado){
        this.estado = estado;
    }
    
    public int getEstado(){
        return estado;
    }
    
}
