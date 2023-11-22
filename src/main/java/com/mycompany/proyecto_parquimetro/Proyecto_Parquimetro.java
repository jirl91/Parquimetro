/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_parquimetro;
import com.mycompany.proyecto_parquimetro.Cliente;
import com.mycompany.proyecto_parquimetro.Parquimetro;
import com.mycompany.proyecto_parquimetro.Datos_ingreso;
import com.mycompany.proyecto_parquimetro.Hora_$;
import com.mycompany.proyecto_parquimetro.DatosVehiculo;
import com.mycompany.proyecto_parquimetro.MediosDePago;


import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
  

public class Proyecto_Parquimetro {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            
            Parquimetro formulario1 = new Parquimetro();
            formulario1.setVisible(true);

            formulario1.setBounds(0, 0, 1000, 500);
            formulario1.setResizable(false);

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int centerX1 = (int) (screenSize.getWidth() - formulario1.getWidth()) / 2;
            int centerY1 = (int) (screenSize.getHeight() - formulario1.getHeight()) / 2;
            formulario1.setLocation(centerX1, centerY1);

            formulario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            formulario1.setTitle("Proyecto Parquimetro");
            formulario1.setBackground(Color.BLACK);

            
            formulario1.getContentPane().setBackground(Color.LIGHT_GRAY);
            
            //**************************************************************************//

            
            //************************************************************************//
           
       
            
         
    
            
        });
    }
}
 

    
  
      

      
  

            
      
