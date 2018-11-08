package main;

public class Hilo extends Thread{
    
    private final String nombre;
    
    public Hilo(String nombre){
        
        this.nombre = nombre;
        this.start();
    }
    
    @Override public void run() {

        for(int i = 0; i < 5; i++){
            
            System.out.println(i + " - " + nombre);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
    }
}
