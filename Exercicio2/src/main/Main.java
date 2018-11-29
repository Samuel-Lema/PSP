package main;

public class Main {

    public static void main(String[] args) {
        
        // Genero 4 hilos
        Hilo hilo1 = new Hilo("Hilo 1");
        Hilo hilo2 = new Hilo("Hilo 2");
        Hilo hilo3 = new Hilo("Hilo 3");
        Hilo hilo4 = new Hilo("Hilo 4");
        
        // Paro la ejecución del programa en este bucle hasta que los hilos generados terminen
        while(hilo1.isAlive() || hilo2.isAlive() || hilo3.isAlive() || hilo4.isAlive()){
            
        }
        
        // Muestra el estado de los hilos (Deberian mostrar TERMINATED) debido a que finalizaron
        System.out.println(hilo1.getNombre() + " -> " + hilo1.getState());
        System.out.println(hilo2.getNombre() + " -> " + hilo2.getState());
        System.out.println(hilo3.getNombre() + " -> " + hilo3.getState());
        System.out.println(hilo4.getNombre() + " -> " + hilo4.getState());
    }
    
}
