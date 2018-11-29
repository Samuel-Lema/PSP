package main;

public class Hilo extends Thread {
    
    private String nombre; // Nombre`para identificar al hilo

    public Hilo(String nombre) {
        this.nombre = nombre;
    }

    @Override public void run() {
        
        // Muestra por pantalla el nombre del hilo
        System.out.println("Ola, son o " + nombre);
    }

}
