package main;

public class Hilo extends Thread {
    
    private static int numero = 0;
    private Hilo hilo;
    
    public Hilo(){
            System.out.println("Creando el (" + this.getName() + ")");
            numero++;
            this.start();
            
            
            if (numero < 5){
                    
                hilo = new Hilo();
            }
    }
    
    @Override public void run() {
        
        for(int i = 0; i < 10; i++){
            
            System.out.println(i + " - " + this.getName());
            
            try {
                Thread.sleep((long) (Math.random() * 600 + 100));
            } catch (InterruptedException ex) {}
        }
        
        try {
            if(this.getName().equalsIgnoreCase("Thread-4")){
                
            } else {
                hilo.join();
            }
        } catch (InterruptedException ex) {}
        
        System.out.println("Acabando el (" + this.getName() + ")");
    }
}