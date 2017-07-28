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
    static ArrayList<Solicitudes> solicitudes = new ArrayList();
    static int opcion;
    static boolean resp;
    static String Nombre, password, hometown, username, confirmacion;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
                    + "2. Solicitudes \n"
                    + "3. Enviar Mensajes \n"
                    + "4. Buzón \n"
                    + "5. Eliminar Mensajes \n"
                    + "6. Eliminar amigo \n"
                    + "7. Salir\n "
                    + "Ingrese opcion: ");
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println(" --Lista de Usuarios registrados--\n");
                    for (Usuario amigo : users) {
                        if (!amigo.getNombre().equalsIgnoreCase(users.get(user).getNombre())) {
                            System.out.println(amigo);
                        }
                    }
                    System.out.print("\n1. Enviar Solicitud\n"
                            + "2. Salir\n"
                            + "Ingrese: ");
                    numero = sc.nextInt();
                    if (numero==1) {
                        System.out.print("Ingrese nombre o username: ");
                        Nombre = sc.next();
                        while (enviar_solicitud(Nombre, user)==false){
                            System.out.print("Probablemente ingreso mal el nombre de usuario\n"
                                    + "Ingrese de nuevo: ");
                            Nombre = sc.next(); 
                        }
                        System.out.println(" ¡Solicitud enviada con exito!");
                    }
                    System.out.println("Menu... ");
                    break;
                case 2:
                    System.out.println(" --Lista de solicitudes--\n ");
                    for (Solicitudes s : solicitudes) {
                        if (s.getReceptor().equalsIgnoreCase(users.get(user).getUsername())  || s.getReceptor().equalsIgnoreCase(users.get(user).getNombre()) && s.getEstado()==2) {
                            System.out.println(s);
                        }
                    }
                    System.out.print("¿Confirmar, rechazar o nada?: ");
                    confirmacion = sc.next();
                    if (confirmacion.equalsIgnoreCase("Confirmar")) {
                        System.out.print("Ingrese el nombre de quien mando la solicitud: ");
                        nombre = sc.next();
                        for (Solicitudes s : solicitudes) {
                            if (s.getEmisor().equalsIgnoreCase(nombre) && s.getEmisor().equalsIgnoreCase(users.get(user).getNombre())) {
                                s.setEstado(1);
                            }
                        }
                    }else if (confirmacion.equalsIgnoreCase("rechazar")) {
                        System.out.print("Ingrese el nombre de quien mando la solicitud: ");
                        nombre = sc.next();
                        for (Solicitudes s : solicitudes) {
                            if (s.getEmisor().equalsIgnoreCase(nombre) && s.getEmisor().equalsIgnoreCase(users.get(user).getNombre())) {
                                solicitudes.remove(s);
                            }
                        }
                    }else if (confirmacion.equalsIgnoreCase("nada")) {
                        System.out.println("Okay :'v");
                    }else {
                        System.out.println("¡Probablemente puso algo erroneo!");
                    }
                    System.out.println("Menu... ");
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
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
    
    
    static public boolean enviar_solicitud(String nombre, int pos){
        boolean conf = false;
        for (Usuario user : users) {
            if (user.getUsername().equalsIgnoreCase(nombre) || user.getNombre().equals(nombre)) {
                conf = true;
            }
        }       
        if (conf) {
            solicitudes.add(new Solicitudes(nombre, users.get(pos).getNombre(), 2));
        }
        return conf;
    }
    
}
