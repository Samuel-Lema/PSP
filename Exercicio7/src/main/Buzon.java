package main;

public class Buzon {

    private static int contador = 0;
    private final String nombre;
    public String correo; // Guarda el mensaje del correo

    // Constructor
    public Buzon(String nombre) {

        this.nombre = nombre;
    }

    // Metodos
    
    public synchronized void leerCorreo() {

        // Muestra el correo por pantalla
        
        System.out.println(correo);
        
        // Gestiona los tiempos de espera entre hilos sincronizados
        
        if (contador >= 3) {
            
            notify();
        } else {
            contador++;
            
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
    }

    public synchronized void enviarCorreo(Usuario user, String mensaje, Buzon destinatario) {
        
        try {
            // Escribe el correo al destinatario (Buzon definido como destinatario)
            
            destinatario.correo = destinatario.nombre + ": " + mensaje + " -> Enviado por ( " + user.getNombre() + " )";
            System.out.println("Correo enviado al " + destinatario.nombre + " por " + user.getNombre());
            
            // Hace que el destinatario lea el correo (DESCOMENTARLO EN CASO DE ACTIVAR UN SOLO BUZON)
            destinatario.leerCorreo();
            
            // Gestiona los tiempos de espera entre hilos sincronizados
            
            if (contador >= 2) {
                notify();
            } else {
                contador++;
                wait();
            }
        } catch (InterruptedException ex) {}
    }

}
