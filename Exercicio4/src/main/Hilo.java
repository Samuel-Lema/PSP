package main;

public class Hilo extends Thread {

    private Hilo hilo;
    private int numero = 0;
    private int modo; // Define que operacion se le asignara al hilo
    
    public Hilo(int modo){
            // Muestro por pantalla que el hilo se creo
        
            System.out.println("Creando el (" + this.getName() + ")");
            this.modo = modo;
            
            // Inicio el hilo
            
            this.start();
    }
    
    @Override public void run() {
        
        // Segun el nº pasado al constructor el hilo hara X operación
        
        switch(modo){
            case 1: sumPares(); break;
            case 2: sumImpares(); break;
            case 3: sumOtros(); break;
        }
        
        // Muestro por pantalla que acaba el hilo
        
        System.out.println("Acabando el (" + this.getName() + ")");
    }
    
    // Función para sumar los pares
    
    public void sumPares(){
        
        for(int i = 1; numero <= 1000; i++){
            
            if (i % 2 == 0) {
                
                numero += i;
            }
            
            System.out.println("Pares: " + numero);
            
            try {
                Thread.sleep((long) (Math.random() * 600 + 100));
            } catch (InterruptedException ex) {}
        }
    }
    
    // Función para sumar impares
    
    public void sumImpares(){
        
        for(int i = 1; numero <= 1000; i++){
            
            if (i % 2 != 0) {
                
                numero += i;
            }
            
            System.out.println("Impares: " + numero);
            
            try {
                Thread.sleep((long) (Math.random() * 600 + 100));
            } catch (InterruptedException ex) {}
        }
    }
    
    // Función para sumar los que acaben en 2 o 3
    
    public void sumOtros(){
        
        for(int i = 1; numero <= 1000; i++){
            String[] array = String.valueOf(i).split("");
            
            if (Integer.parseInt(array[array.length -1]) == 2 || Integer.parseInt(array[array.length -1]) == 3) {
                
                numero += i;
            }
            
            System.out.println("Otros: " + numero);
            
            try {
                Thread.sleep((long) (Math.random() * 600 + 100));
            } catch (InterruptedException ex) {}
        }
    }
}