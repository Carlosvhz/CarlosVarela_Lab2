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
public class CarlosVarela_Lab2 {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Usuario> users = new ArrayList();
    static int opcion;
    static boolean resp;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        String Nombre, password, hometown, username;
        int edad, posicion;
        do {
            resp=true;
            System.out.println("= = = = = Menu Principal = = = = =");
            System.out.print("1. Agregar usuarios\n"
                    + "2. Eliminar Usuarios\n"
                    + "3. Modificar Usuarios\n"
                    + "4. Ingresar\n"
                    + "5. Salir\n"
                    + "Ingrese opcion: ");
            opcion = sc.nextInt();
            while(opcion>5){
                System.out.print("Ingrese una opcion valida porfavor: ");
                opcion = sc.nextInt();
            }
            
            switch(opcion){
                case 1:
                    System.out.println("\n - - - - Agegar Usuario - - - -");
                    System.out.print("Ingrese nombre: ");
                    Nombre = sc.next();
                    System.out.print("Lugar de nacimiento: ");
                    hometown = sc.next();
                    System.out.print("edad: ");
                    edad = sc.nextInt();
                    System.out.print("Username: ");
                    username = sc.next();
                    System.out.print("Password: ");
                    password = sc.next();
                    users.add(new Usuario( Nombre,  username,  hometown,  password,  edad));
                    break;
                case 2:
                    System.out.println(" - - - - Eliminar Usuario - - - -");
                    System.out.print("¿Que usuario desea eliminar?: ");
                    posicion = sc.nextInt();
                    while(posicion>users.size()||posicion<users.size()){
                        System.out.println("\n###Porfavor, ingrese un numero de usuario existente###\n");
                        System.out.print("Ingrese: ");
                        posicion = sc.nextInt();
                    }
                    users.remove(posicion);
                    break;
                case 3:
                    
                    break;
                case 4:
                    System.out.println(" - - - - LogIn - - - -");
                    System.out.print("Ingrese username: ");
                    username = sc.next();
                    System.out.print("Ingrese password: ");
                    password = sc.next();
                    int user = evalua(username, password);
                    while(user==-1){
                        System.out.println("##Error, ingrese usuario y password correctos##");
                        System.out.print("Ingrese username: ");
                        username = sc.next();
                        System.out.print("Ingrese password: ");
                        password = sc.next();
                        user = evalua(username, password);
                    }
                    MenuLogin(user);
                    resp=true;
                    break;
                default:
                    System.out.println("Gracias :3");
                    resp=false;
                    break;
            }
        } while (resp==true);
        
    }
    
    /**
     * Menu que despliega cuando el usuario ha entrado
     *@param user 
     */
    static public void MenuLogin (int user){
        int numero;
        String nombre;
        System.out.println("\n= = = = = Bienvenido: "+users.get(user).getUsername()+" = = = = ");
        do{
            System.out.print("1. Agregar amigos\n"
                    + "2. Agregar amigos\n"
                    + "3. Solicitudes \n"
                    + "4. Enviar Mensajes \n"
                    + "5. Buzón \n"
                    + "6. Eliminar Mensajes \n"
                    + "7. Eliminar amigo \n"
                    + "8. Salir\n "
                    + "Ingrese opcion: ");
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println(" --Lista de Usuarios registrados--");
                    for (Usuario amigo : users) {
                        System.out.println(amigo);
                    }
                    System.out.print("1. Enviar Solicitud\n"
                            + "2. Salir\n"
                            + "Ingrese: ");
                    numero = sc.nextInt();
                    if (numero==1) {
                        System.out.print("Ingrese nombre: ");
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Que tenga lindo día ;v");
                    resp = false;
                    break;    
            }
        }while(resp==true);
    }
    
    
    /**
     * Metodo que evalua si el usuario es correcto
     * @param username
     * @param password
     * @return 
     */
    static public int evalua (String username, String password){
        int confirmado = -1;
        for (Usuario U : users) {
            if (U.getUsername().equalsIgnoreCase(username) && U.getPassword().equalsIgnoreCase(password)) {
                confirmado = users.indexOf(U);
            }
        }
        return confirmado;
    }
    
}
