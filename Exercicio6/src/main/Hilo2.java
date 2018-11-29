package main;

public class Hilo2 extends Thread {

    private final Banco banco;
    public boolean finalizado = false;

    public Hilo2(Banco banco) {

        this.banco = banco;
    }

    @Override public void run() {

        // Simula una extraccion 5 veces
        
        for (int i = 0; i < 5; i++) {

            if (i == 4) {
               finalizado = true; 
            }
            banco.extraer((int) (Math.random() * 100 + 0));
        }

        try {
            finalize();
        } catch (Throwable ex) {}
    }
}
