
package com.mycompany.proyecto_parquimetro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediosDePago extends JFrame {

    private JLabel medioDePago;
    private JLabel pago;
    private JLabel pago2;
   
    private JButton guardar;
    private JTextField texto1;

    private Datos_ingreso formulario2;
    private Tarjetas tarjetas;
    
     private final Cliente cliente;
   
   
    private Tarjetas pagoTarjetas;


    public MediosDePago() {
         tarjetas = new Tarjetas();
          cliente = new Cliente();
    
   
    
             tarjetas = new Tarjetas();

        
        
        pago2 = new JLabel("<html><font color='white' size='4'>MEDIOS DE PAGO</font></html>");
        pago2.setBounds(160, 20, 300, 30);
        add(pago2);

        pago = new JLabel("<html><font color='white' size='4'> " );
        pago.setBounds(130, 140, 300, 30);
        add(pago);

        texto1 = new JTextField(); // nombre completo
        texto1.setBounds(120, 190, 250, 30);
        add(texto1);

    

        guardar = new JButton("Guardar");
        guardar.setBounds(220, 300, 120, 50);
        add(guardar);

        formulario2 = new Datos_ingreso();

        guardar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        String pagoTarjeta = texto1.getText();

        // Almacena el medio de pago en la instancia de Tarjetas
        tarjetas.almacenartarjetas(pagoTarjeta);
        tarjetas.mostrarDatosTarjetas();

        // Actualiza los datos en el formulario2
      
      

        // Almacena el medio de pago en la instancia de Tarjetas
      
         pago2.setText("<html><font color='DARK' size='4' face='Serif'> Su medio de paago es : " + tarjetas.dTarjetas[0] + "</font></html>");


        // Actualiza los datos en el formulario2
        formulario2.actualizarDatosTarjetas(tarjetas.dTarjetas[0]);
        
        
        
     
            
           
        
            
            
         
        // Cierra la ventana actual
        formulario2.setVisible(false);
    }
});

        setLayout(null);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("MEDIOS DE PAGO ");
        setResizable(false);
    }
}


        
        
      
        
        

    



