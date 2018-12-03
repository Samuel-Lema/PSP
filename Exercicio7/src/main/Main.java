package main;

public class Main {
    
    public static Buzon buzon1; // Buzon de Samuel
    public static Buzon buzon2; // Buzon de Alberto
    
    public synchronized static void main(String[] args) {
        
        // Creo un buzon
        
        buzon1 = new Buzon("Buzon 1");
        
        // Creo varios Usuarios (Hilos) que son los que envia / leen los correos
        // Parametros: (Nombre Identificador, Buzon al que acceden, buzon al que envian, mensaje que enviaran)
        
        Usuario usuario1 = new Usuario("Samuel", buzon1, buzon1, "Hola buenas, soy Samuel.");
        Usuario usuario2 = new Usuario("Alejandro", buzon1, buzon1, "Hola buenas, soy Alejandro");
        Usuario usuario3 = new Usuario("Alberto", buzon1, buzon1, "Hola buenas, soy Alberto"); 
        
                
        // Aqui dejo el la parte del ejercicio que hice con varios buzones
        
        /* buzon1 = new Buzon("Buzon 1");
        buzon2 = new Buzon("Buzon 2");
        
        Usuario usuario1 = new Usuario("Samuel", buzon1, buzon2, "Hola buenas, soy Samuel.");
        Usuario usuario2 = new Usuario("Alejandro", buzon2, buzon1, "Hola buenas, soy Alejandro");
        Usuario usuario3 = new Usuario("Alberto", buzon1, buzon2, "Hola buenas, soy Alberto"); */
        
    }   
    
}