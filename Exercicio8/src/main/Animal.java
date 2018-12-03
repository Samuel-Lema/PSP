package main;

public class Animal extends Thread {

    public final String nombre;
    public final int tipoAnimal; // 0 -> Tortuga, 1 -> Liebre
    public int casilla = 1;

    // Constructor
     public  Animal(String nombre, int tipoAnimal) {

        this.nombre = nombre;
        this.tipoAnimal = tipoAnimal;
        this.start();
    }

    // Gestiona los porcentajes de movimiento de cada turno. 
     
    public synchronized void turno() {

        int mov = (int) (Math.random() * 100);

        if (tipoAnimal == 0) { // Tortuga
            
            if (mov >= 0 && mov < 50) { // +3 casilla (50%) -> Avance rápido

                casilla += 3;

            } else if (mov >= 50 && mov < 70) { // -6 casilla (20%) -> Esvarou

                casilla -= 6;

            } else if (mov >= 70 && mov < 100) { // +1 casilla (30%) -> Avance lento

                casilla += 1;
            }

        } else if (tipoAnimal == 1) { // Liebre
            
            if (mov >= 0 && mov < 20) { // 0 casilla (20%) -> Dorme

            } else if (mov >= 20 && mov < 40) { // +9 casilla (20%) -> Gran Salto

                casilla += 9;

            } else if (mov >= 40 && mov < 50) { // -12 casilla (10%) -> Esvarón grande

                casilla -= 12;

            } else if (mov >= 50 && mov < 80) { // +1 casilla (30%) -> Pequeno Salto

                casilla += 1;

            } else if (mov >= 80 && mov < 100) { // -2 casilla (20%) -> Esvarón pequeno

                casilla -= 2;
            }
        }

        // Si pasa de la casilla 1 hacia la izquierda vuelve a la 1
        
        if (casilla < 1) {

            casilla = 1;
        }
        
        // Muestra el nombre del animal y el número de casilla en el que esta.
        
        System.out.println(this.nombre + ": " + casilla);
    }

    @Override synchronized public void run() {
        
        try {
            // Ejecuta los turnos hasta que alguien llegue a la casilla 70
            
            while (casilla < 70) {
                this.turno();
                Animal.sleep(600);
            }

            // Cuando alguien llega al 70 para al otro
            
            switch (tipoAnimal) {
                case 0: Main.liebre.stop(); break;
                case 1: Main.tortuga.stop(); break;
                default: System.out.println("WTF"); break;
            }
            
            // Muestra al ganador
            
            System.out.println(" -------------- La " + this.nombre + " ha ganado. --------------");
        } catch (InterruptedException ex) {}
    }
}
