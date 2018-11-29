package main;

public class Hilo extends Thread{
    
    private final String nombre;
    
    public Hilo(String nombre){
        
        this.nombre = nombre;
        this.start();
    }
    
    // Get's

    public String getNombre() {
        return nombre;
    }
    
    @Override public void run() {

        // Ejecuta 5 veces el hilo mostrandose por pantalla, 
        // entre cada ejecución de bucle hay un 1 segundo de delay
        
        for(int i = 0; i < 5; i++){
            
            System.out.println(i + " - " + nombre);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
    }
}
