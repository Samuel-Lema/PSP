package main;

public class Hilo1 extends Thread {

    private final Banco banco;
    public boolean finalizado = false;
        
    public Hilo1(Banco banco) {
        
        this.banco = banco;
    }
    
    @Override public void run(){
        
        // Simular un ingreso 15 veces
        
        for (int i = 0; i < 15; i++) {
            
            if (i == 14) {
               finalizado = true; 
            }
            banco.ingresar((int)(Math.random() * 100 + 0));
        }
        
        try {
            finalize();
        } catch (Throwable ex) {}
    }
}
