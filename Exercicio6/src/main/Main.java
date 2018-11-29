package main;

public class Main {

    public static Hilo1 hilo1;
    public static Hilo2 hilo2;
    
    public static void main(String[] args) {
        
        // Creo un banco con un saldo inicial
        
        Banco bancoSamuel = new Banco(110);
        
        // Creo dos hilos asignandole un banco
        
        hilo1 = new Hilo1(bancoSamuel); // Este hilo simula ingresos
        hilo2 = new Hilo2(bancoSamuel); // Este hilo simula extracciones
        
        // Inicio los hilos
        
        hilo1.start();
        hilo2.start();
    }
    
}
