package main;

public class Ascensor extends Thread {

    private final String nombre = "Ascensor";
    public int piso = 0;
    public boolean finalizado;

    // Parametros de cambio
    
    private int pisoDeseado;
    private boolean subir;
    
    // Constructor
    public Ascensor(int piso) {

        this.piso = piso;
        this.finalizado = true;
        Main.txtPiso.setText(String.valueOf(piso));
    }

    public synchronized void cambiarPiso(int pisoDeseado){
        
        // Muestro por pantalla a que piso ira el ascensor
        
        Main.txtPrincipal.setText(this.nombre + " en " + this.piso + " --> " + pisoDeseado);
        
        this.pisoDeseado = pisoDeseado;
        this.finalizado = false;
        
        // Define si hay que subir o bajar segun sea mayor o menor el piso al que se va.
        
        if (piso < pisoDeseado) {
            this.subir = true;
        } else {
            this.subir = false;
        }
        
        this.start();
    }
    
    @Override public void run() {
        
        // Mientras no llegue al piso sigue subiendo/bajando
        
        while(piso != pisoDeseado){
            if (subir) {
                piso++; 
            } else {
                piso--;
            }
            
            // Temporiza el piso en el que esta para que sea perceptible al ojo humano
            
            try {
                sleep(600);
            } catch (InterruptedException ex) {}
            
            // Muestra los pisos por los que esta avanzando
            
            Main.txtPiso.setText(String.valueOf(piso));
        }
        
        // Leggo al piso y lo muestra por pantalla
        
        this.finalizado = true;
        Main.txtPrincipal.setText(this.nombre + " a llegado al piso " + pisoDeseado);
    }
}
