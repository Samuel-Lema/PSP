package main;

public class Main {

    public static void main(String[] args) {
        
        Hilo hilo1 = new Hilo("Hilo 1");
        Hilo hilo2 = new Hilo("Hilo 2");
        Hilo hilo3 = new Hilo("Hilo 3");
        Hilo hilo4 = new Hilo("Hilo 4");
        
        while(hilo1.isAlive() || hilo2.isAlive() || hilo3.isAlive() || hilo4.isAlive()){
            
        }
        System.out.print(hilo1.getState());
    }
    
}
