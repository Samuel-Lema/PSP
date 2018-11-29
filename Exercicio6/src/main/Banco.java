package main;

public class Banco {
    
    private int dinero; // Guarda el dinero actual en el banco
    
    public Banco(int capitalIni){
    
        // Crea el banco con un dinero inicial dado
        
        this.dinero = capitalIni;
    }
    
    public synchronized void ingresar(int i){
        
        // Ingresan dinero
        dinero += i;
        
        // Muestra por pantalla el dinero del banco, y el dinero que se ingreso
        System.out.println("Saldo Actual: " + dinero + " - Ingreso: " + i);
        
        try{

            if (Main.hilo2.finalizado == true) {
               
            } else {
                notify();
                wait();
            }
            
        } catch(InterruptedException ex){}
    }
    
    public synchronized void extraer(int i){
        
        // Retiran dinero
        dinero -= i;
        
        // Muestra por pantalla el dinero del banco, y el dinero que se retiro
        System.out.println("Saldo Actual: " + dinero + " - Extración: " + i);
        
        try{
            if (Main.hilo1.finalizado == true) {
                
            } else {
                notify();
                wait(); 
            }
        } catch(InterruptedException ex){}
    }
}
