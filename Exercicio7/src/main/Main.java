package main;

import java.util.ArrayList;

public class Main {
    
    public static Buzon buzon1; // Buzon de Samuel
    public static Buzon buzon2; // Buzon de Alberto
    
    public synchronized static void main(String[] args) {
        
        buzon1 = new Buzon("Buzon 1");
        buzon2 = new Buzon("Buzon 2");
        
        Usuario usuario1 = new Usuario("Samuel", buzon1, buzon2, "Hola buenas, soy Samuel.");
        Usuario usuario2 = new Usuario("Alejandro", buzon2, buzon1, "Hola buenas, soy Alejandro");
        Usuario usuario3 = new Usuario("Alberto", buzon1, buzon2, "Hola buenas, soy Alberto");
    }   
    
}