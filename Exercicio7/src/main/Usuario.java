package main;

public class Usuario extends Thread {
    
    private final String nombre;
    private Buzon buzon;
    private Buzon destinatario;
    private String mensaje;
    
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
        
        buzon.enviarCorreo(this, mensaje, destinatario);
        destinatario.leerCorreo();
        
    }
}
