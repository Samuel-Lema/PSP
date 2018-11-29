package main;

public class Hilo extends Thread {
    
    private static int numero = 0; // Cuenta el número de hilos que se generara en el programa
    private Hilo hilo;
    
    public Hilo(){
        // Muestro que el hilo se esta creando
        
        System.out.println("Creando el (" + this.getName() + ")");
        
        // Aumento el contador de hilos generados
        // Inicio en hilo actual
        
        numero++;
        this.start();
            
        // Compruebo si se han generado menos de 5 hilos
        // Si son menos genera hilo otro nuevo
        if (numero < 5){
                    
            hilo = new Hilo();
        }
    }
    
    @Override public void run() {
        
        // Se muestra 10 veces por pantalla con un delay de 0,6s
        
        for(int i = 0; i < 10; i++){
            
            System.out.println(i + " - " + this.getName());
            
            try {
                Thread.sleep((long) (Math.random() * 600 + 100));
            } catch (InterruptedException ex) {}
        }
        
        // Comprueba si el hilo actual es el Thread 4 (Hilo nº5)
        // Ya que si es llega 4 deja de generar nuevos hilos
        
        try {
            if(this.getName().equalsIgnoreCase("Thread-4")){
                
            } else {
                hilo.join();
            }
        } catch (InterruptedException ex) {}
        
        // Muestra por pantalla cuendo se finaliza el hilo
        
        System.out.println("Acabando el (" + this.getName() + ")");
    }
}