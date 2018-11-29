package main;

public class Hilo extends Thread{
    
    private final String nombre; // Nombre para identificar el hilo
    private final int tiempo; // tiempo de delay que se le asigna al hilo
    
    public Hilo(String nombre, int tiempo){
        
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.start();
    }
    
    @Override public void run() {

        // Ejecuta 10 veces el hilo mostrandose por pantalla, 
        // entre cada ejecución de bucle hay un tiempo de delay
        
        for(int i = 0; i < 10; i++){
            
            System.out.println(i + " - " + nombre);
            
            try {
                Thread.sleep((long) (Math.random() * tiempo + 100));
            } catch (InterruptedException ex) {}
        }
    }
}
