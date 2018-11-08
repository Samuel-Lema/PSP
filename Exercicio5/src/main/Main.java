package main;

public class Main {

    public static void main(String[] args) {
        
        Hilo1 h1 = new Hilo1("fio1");
        Hilo1 h2 = new Hilo1("fio2");
        
        h1.setPriority(1);
        h2.setPriority(10);
        
        h2.start();
        h1.start();        
        
        try {
            // Tiempo para dormir
            h1.join(10);
        } catch (InterruptedException ex) {}
    }
    
}
