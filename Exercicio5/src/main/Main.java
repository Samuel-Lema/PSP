package main;

public class Main {

    public static void main(String[] args) {
        
        Hilo h1 = new Hilo("Hilo 1");
        Hilo h2 = new Hilo("Hilo 2");
        
        // Le doy prioridad al hilo 2
        h1.setPriority(Thread.MIN_PRIORITY);
        h2.setPriority(Thread.MAX_PRIORITY);
        
        // Inicio los hilos
        
        h1.start();        
        h2.start();
        
        try {
            // Tiempo para dormir
            h1.join(100);
        } catch (InterruptedException ex) {}
    }
    
}
