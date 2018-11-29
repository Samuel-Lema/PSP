package main;

public class Usuario extends Thread {
    
    private final String nombre; // Nombre del Usuario
    private Buzon buzon; // Buzon del Usuario (Desde donde lee y envia los correos)
    private Buzon destinatario; // Buzon de envio del Usuario (Hacia donde envia los correos)
    private String mensaje; // Mensaje que enviara
    
    public Usuario(String nombre, Buzon buzon, Buzon destinatario, String mensaje){
        
        this.nombre = nombre;
        this.buzon = buzon;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        start();
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override public void run(){
        
        // Pimero envia un correo a su destinatario
        // Parametros (Usuario actual, El mensaje a enviar, el buzon a donde lo quiere enviar)
        
        buzon.enviarCorreo(this, mensaje, destinatario);
        
        // Hace que el destinatario lea el correo
        
        destinatario.leerCorreo();
        
    }
}
