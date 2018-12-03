package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Main extends javax.swing.JFrame implements ActionListener {

    private Ascensor ascensor;
    private int x = 12;
    private int y = 69;
    
    public Main() {
        initComponents();
        
        // Genera los botones por pantalla
        
        for(int i = 1; i < 21; i++){
            JButton boton = new JButton();
            boton.addActionListener((ActionListener) this);
            boton.setText(String.valueOf(i));
            
            switch(i){
                case 1: break;
                case 6: x += 97; y = 69; break;
                case 11: x += 97; y = 69; break;
                case 16: x += 97; y = 69; break;
                default: y += 63; break;
            }
            
            boton.setBounds(0 + x, 0 + y, 80, 45);

            this.add(boton);
        }
        
        // Inicia el ascensor en el piso 0
        
        ascensor = new Ascensor(0);
    }

    @Override public void actionPerformed(ActionEvent e){
        
        // Recoge el número de piso al que clicaron en el boton
        
        String numSelected = ((JButton) e.getSource()).getText();
        
        // Espera a que acabe el anterior boton del ascensor pulsado
        
        while(ascensor.finalizado == false){
            
            System.out.print("");
        }
        
        // Genero un nuevo ascensor con el último piso accedido guardado
        // Genero un nuevo ascensor debido a que no se puede inicializar el "this.start" mas de 1 vez por cada Hilo/Objeto
        
        ascensor = new Ascensor(ascensor.piso);
        
        // Avanza hacia el piso seleccionado en el boton del ascensor
        
        ascensor.cambiarPiso(Integer.valueOf(numSelected));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPrincipal = new javax.swing.JTextField();
        txtPiso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(335, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JTextField txtPiso;
    protected static javax.swing.JTextField txtPrincipal;
    // End of variables declaration//GEN-END:variables
}
