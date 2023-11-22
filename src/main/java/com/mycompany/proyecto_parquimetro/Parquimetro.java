package com.mycompany.proyecto_parquimetro;
import com.mycompany.proyecto_parquimetro.Datos_ingreso;
import com.mycompany.proyecto_parquimetro.Cliente;
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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.*;



public class Parquimetro extends JFrame {
  
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JLabel etiqueta3;
    private JLabel etiqueta4;
 
  
    private JLabel etiqueta7;
    private JLabel etiqueta8;
    private JLabel etiqueta9;
    private JLabel etiqueta10;
    private JTextField texto1;
    private JTextField texto2;
    private JTextField texto3;
   
    private JTextField texto5;
    private JTextField texto6;
    private JTextField texto7;// el cuadro del pasaporte
    private JTextField texto8;// el cuadro del pasaporte
    
    private JButton boton1; //REGISTRA LA HORA AUTOMATICAMENTE 
    private JButton boton3;//Finaliza y abre la ventana con todos los datos
    private JButton boton4;//Guardar los Datos ingresados en el Jframe1
    private JButton boton2; //activa los medios de pago 
    
    
    private JTextArea registroHoras;
   
   
    private int xLine = 0;   
    private Thread animationThread;
    private final Cliente cliente;
    private Datos_ingreso formulario2;
    private Hora_$ datosHora;
    private DatosVehiculo datoV;
    private MediosDePago formulario3;
    private Tarjetas tarjetas;
    private Tarjetas obtenerTarjetaInstance;
    private Tarjetas pagoTarjetas;
    
    
    //ingreso datos vehiculo 
    
    private JLabel etiqueta11; //PATENTE
    private JLabel etiqueta12; //MODELO VEHICULO 
    private JLabel etiqueta13; // Color Vehiculo 
    
    private JTextField texto9; //ingreso de la patente
    private JTextField texto10; //ingreso modelo vehiculo 
    private JTextField texto11; //ingreso color vehiculo 
    
    // Datos de pago 
    
   private JLabel Total_p;
   private JLabel Tarjeta;
    
    public Parquimetro(){
        
    cliente = new Cliente();
    
    datosHora = new Hora_$();
    
    datoV = new DatosVehiculo();
    
    formulario3 = new MediosDePago();
    
    tarjetas = new Tarjetas();
    
   
    
    

    setLayout(null);
   
    etiqueta1 = new JLabel("<html><font color='white' size='4'>HORA ENTRADA</font></html>");
    etiqueta1.setBounds(160, 20, 300,30);
    add(etiqueta1);
   
   
    etiqueta2 = new JLabel("<html><font color='white' size='4'>HORA SALIDA</font></html>");
    etiqueta2.setBounds(360, 20, 100, 30);
    add(etiqueta2);
    
  
                      //DATOS CLIENTE 
    
    etiqueta7 = new JLabel("<html><font color='white' size='4' face='Arial'>&nbsp;NOMBRE COMPLETO </font></html>");
    etiqueta7.setBounds(50, -50, 500, 500); // Reduzco el ancho a 30
    add(etiqueta7);
    
    etiqueta8 = new JLabel("<html><font color='white' size='4' face='Arial'>&nbsp;RUT  </font></html>");
    etiqueta8.setBounds(50, -10, 500, 500); // Reduzco el ancho a 30
    add(etiqueta8);
    
    etiqueta9 = new JLabel("<html><font color='white' size='4' face='Arial'>&nbsp;PASAPORTE  </font></html>");
    etiqueta9.setBounds(50, 30, 500, 500); // Reduzco el ancho a 30
    add(etiqueta9);
    
    etiqueta10 = new JLabel("<html><font color='white' size='4' face='Arial'>&nbsp;NACIONALIDAD  </font></html>");
    etiqueta10.setBounds(50, 60, 500, 500); // Reduzco el ancho a 30
    add(etiqueta10);

     //INGRESO DATOS VEHICULO 
     
    etiqueta11 = new JLabel("<html><font color='white' size='4'>PATENTE</font></html>");
    etiqueta11.setBounds(550, 70, 300,30);
    add(etiqueta11);
   
   
    etiqueta12 = new JLabel("<html><font color='white' size='4'>MODELO VEHICULO</font></html>");
    etiqueta12.setBounds(550, 110, 150, 30);
    add(etiqueta12);
    
    etiqueta13 = new JLabel("<html><font color='white' size='4' face='Arial'>&nbsp;COLOR VEHICULO</font></html>");
    etiqueta13.setBounds(550, 145, 200, 30);
    add(etiqueta13);
    
     Total_p= new JLabel("<html><font color='DARK' size='4' face='Serif'> Total a pagar :</font></html>");
     Total_p.setBounds(600, 165, 300, 300);
     add(Total_p);
      
     Tarjeta= new JLabel(" ");
     Tarjeta.setBounds(600, 165, 300, 300);
     add(Tarjeta);
   
    
    //INGRESO DATOS VEHICULO
    
    texto9 = new JTextField();
    texto9.setBounds(700,70,200,25); // INGRESO DE LA PATENTE
    add(texto9);
    
    
    texto10= new JTextField();
    texto10.setBounds(700,110,200,25); // MODELO VEHICULO
    add(texto10);
    
    texto11= new JTextField();
    texto11.setBounds(700,145,200,25); // COLOR VEHICULO
    add(texto11);
    
    //
   
    texto1 = new JTextField();
    texto1.setBounds(150,50,120,30); // HORA ENTRADA 
    add(texto1);
   
    texto2 = new JTextField();
    texto2.setBounds(350,50,120,30); // HORA DE SALIDA 
    add(texto2);
    
 
    
    
    
    texto5 = new JTextField(); // nombre completo 
    texto5.setBounds(250,190,250,25);
    add(texto5);
    
    texto6 = new JTextField();
    texto6.setBounds(250,230,250,25); // rut
    add(texto6);
   
    
    texto7 = new JTextField();
    texto7.setBounds(250,270,250,25); // Acá se digitara el pasaporte
    add(texto7);
            
     texto8 = new JTextField();
    texto8.setBounds(250,300,250,25); // nacionalidad 
    add(texto8);
    
    boton1 = new JButton("Registrar Entrada");
    boton1.setBounds(250, 90, 120, 50);
    add(boton1);

   
    
    boton3 = new JButton("Listo");
    boton3.setBounds(700,400,120,50);
    add(boton3);
    
    boton4 = new JButton("Guardar");
    boton4.setBounds(500,400,120,50);
    add(boton4);
    
    boton2 = new JButton("Pagar");
    boton2.setBounds(300,400,120,50);
    add(boton2);
    
    
  
     

   

 
  
    
      
        formulario2 = new Datos_ingreso();
        formulario3 =new MediosDePago();
       
        
        
      boton1.addActionListener(new ActionListener() {
       @Override
       
      public void actionPerformed(ActionEvent e) {
                // Obtén la hora actual y regístrala en el JTextField
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                Date horaActual = new Date();
                String horaFormateada = sdf.format(horaActual);
                texto1.setText(horaFormateada);
                
          
               
            }
        });
      
      
         
            
boton4.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Datos del cliente
        String nombreCompleto = texto5.getText();
        String RUT = texto6.getText();
        String Pasaporte = texto7.getText();
        String Nacionalidad = texto8.getText();

        // Almacena los datos del cliente en la instancia de Cliente
        cliente.almacenarDatosCliente(nombreCompleto, RUT, Pasaporte, Nacionalidad, " ");
        cliente.mostrarDatosCliente();
            
           // Actualiza los datos del cliente en el segundo JFrame
            formulario2.actualizarDatosCliente(
                    cliente.datosCliente[0],
                    cliente.datosCliente[1],
                    cliente.datosCliente[2],
                    cliente.datosCliente[3],
                    cliente.datosCliente[4]
            );

          //HORA 
          
          String horaEntrada = texto1.getText();
          String horaSalida = texto2.getText();

// Co// Convierte las cadenas a enteros (asegúrate de manejar posibles excepciones)
        int minutosEntrada = Integer.parseInt(horaEntrada.split(":")[0]) * 60 + Integer.parseInt(horaEntrada.split(":")[1]);
        int minutosSalida = Integer.parseInt(horaSalida.split(":")[0]) * 60 + Integer.parseInt(horaSalida.split(":")[1]);

        // Calcula la diferencia de tiempo en minutos
        int totalMinutos = minutosSalida - minutosEntrada;
        
     

        // No necesitas almacenar totalMinutos en datosHora
        datosHora.almacenarHora$(horaEntrada, horaSalida," ");
        datosHora.mostrarDatosHora();
        datosHora.calcularDiferenciaMinutos();
        datosHora.totalApagar();
        
        
         String costoTotalConPeso = "$" + datosHora.DatosHora[3];
        datosHora.DatosHora[3] = costoTotalConPeso;
       
       

        // Actualiza los datos en formulario2
            formulario2.actualizarDatosHora(
            datosHora.DatosHora[0],
            datosHora.DatosHora[1],
            datosHora.DatosHora[3]
            
        );
        
           formulario2.actualizarDatosHora1(totalMinutos);
           Total_p.setText("<html><font color='DARK' size='4' face='Serif'> Total a pagar: " + datosHora.DatosHora[3] + "</font></html>");

    
            
            formulario2.actualizarDatosHora1(
             totalMinutos
            );
            
            // SE AGREGA EL PAGO AL BOTON 4 
            
            //DATOS DEL VEHICULO
            
        String patente = texto9.getText();
        String modelo = texto10.getText();
        String color = texto11.getText();

        // Verificar que los campos del vehículo no estén vacíos antes de almacenar y mostrar
        
            // Almacena los datos del vehículo en la instancia de DatosVehiculo
            datoV.almacenarDatosVehiculo(patente, modelo, color);
            datoV.mostrarDatosVehiculo();

          

            // Llama a actualizarDatosVehiculo en formulario2 después de almacenar y mostrar los datos
            formulario2.actualizarDatosVehiculo(
                    datoV.DatosVehiculo[0],
                    datoV.DatosVehiculo[1],
                    datoV.DatosVehiculo[2]
            );
          
         

           
           formulario2.setVisible(false);
           formulario3.setVisible (false);
           

     
    }


    
});






boton3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Datos_ingreso formulario2 = new Datos_ingreso();
       
        
            formulario2.setVisible(false);

            formulario2.setBounds(0, 0, 600, 750);
            formulario2.setResizable(true);

            Dimension screenSize2 = Toolkit.getDefaultToolkit().getScreenSize();
            int centerX2 = (int) (screenSize2.getWidth() - formulario2.getWidth()) / 2;
            int centerY2 = (int) (screenSize2.getHeight() - formulario2.getHeight()) / 2;
            formulario2.setLocation(centerX2, centerY2);

            formulario2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cambiado a DISPOSE_ON_CLOSE
            formulario2.setTitle("Proyecto Parquimetro - Datos Ingreso");
            formulario2.setBackground(Color.BLACK);

           
            formulario2.getContentPane().setBackground(Color.LIGHT_GRAY);
            
            // Datos del cliente
        String nombreCompleto = texto5.getText();
        String RUT = texto6.getText();
        String Pasaporte = texto7.getText();
        String Nacionalidad = texto8.getText();

        // Almacena los datos del cliente en la instancia de Cliente
        cliente.almacenarDatosCliente(nombreCompleto, RUT, Pasaporte, Nacionalidad, " ");
        cliente.mostrarDatosCliente();
            
           // Actualiza los datos del cliente en el segundo JFrame
            formulario2.actualizarDatosCliente(
                    cliente.datosCliente[0],
                    cliente.datosCliente[1],
                    cliente.datosCliente[2],
                    cliente.datosCliente[3],
                    cliente.datosCliente[4]
            );

          //HORA 
          
          String horaEntrada = texto1.getText();
          String horaSalida = texto2.getText();

// Co// Convierte las cadenas a enteros (asegúrate de manejar posibles excepciones)
        int minutosEntrada = Integer.parseInt(horaEntrada.split(":")[0]) * 60 + Integer.parseInt(horaEntrada.split(":")[1]);
        int minutosSalida = Integer.parseInt(horaSalida.split(":")[0]) * 60 + Integer.parseInt(horaSalida.split(":")[1]);

        // Calcula la diferencia de tiempo en minutos
        int totalMinutos = minutosSalida - minutosEntrada;
        
     

        // No necesitas almacenar totalMinutos en datosHora
        datosHora.almacenarHora$(horaEntrada, horaSalida," ");
        datosHora.mostrarDatosHora();
        datosHora.calcularDiferenciaMinutos();
        datosHora.totalApagar();
       
        String costoTotalConPeso = "$ " + datosHora.DatosHora[3];
        datosHora.DatosHora[3] = costoTotalConPeso;

        // Actualiza los datos en formulario2
            formulario2.actualizarDatosHora(
            datosHora.DatosHora[0],
            datosHora.DatosHora[1],
            datosHora.DatosHora[3]
            
           
        );
            
            formulario2.actualizarDatosHora1(
             totalMinutos
            );
            
            // SE AGREGA EL PAGO AL BOTON 4 
            
            //DATOS DEL VEHICULO
            
        String patente = texto9.getText();
        String modelo = texto10.getText();
        String color = texto11.getText();

        // Verificar que los campos del vehículo no estén vacíos antes de almacenar y mostrar
        
            // Almacena los datos del vehículo en la instancia de DatosVehiculo
            datoV.almacenarDatosVehiculo(patente, modelo, color);
            datoV.mostrarDatosVehiculo();

          

            // Llama a actualizarDatosVehiculo en formulario2 después de almacenar y mostrar los datos
            formulario2.actualizarDatosVehiculo(
                    datoV.DatosVehiculo[0],
                    datoV.DatosVehiculo[1],
                    datoV.DatosVehiculo[2]
            );
            
          
          
      
                
             
    
            
               formulario2.setVisible(true);
             
               
               
     
       
    }
});


boton2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
        MediosDePago formulario3 = new MediosDePago();
            formulario3.setVisible(false);

            formulario3.setBounds(0, 0, 500, 500);
            formulario3.setResizable(true);

            Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
            int centerX3 = (int) (screenSize3.getWidth() - formulario3.getWidth()) / 2;
            int centerY3 = (int) (screenSize3.getHeight() - formulario3.getHeight()) / 2;
            formulario3.setLocation(centerX3, centerY3);

            formulario3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cambiado a DISPOSE_ON_CLOSE
            formulario3.setTitle("MEDIOS DE PAGO");
            formulario3.setBackground(Color.BLACK);

           
            formulario3.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        formulario3.setVisible(true);  // Reemplaza "MediosdePagos" con el nombre correcto de tu JFrame
    }
});

        setSize(500, 1000);
        setLocationRelativeTo(null);
    }
             

    
     @Override
    public void paint(Graphics g) {
        super.paint(g);
        
       int frameHeight = getHeight();

        // Dibuja una línea roja
       g.setColor(Color.RED);
       ((Graphics2D) g).setStroke(new BasicStroke(3));
       int x = getWidth() - 20; // x es el mismo para ambos puntos
       int y1 = frameHeight / 16; // Punto inicial
       int y2 = y1 + 600; // Punto final, 500 píxeles más abajo
       g.drawLine(x, y1, x, y2); // Dibuja una línea vertical
       
      
    
        // Dibuja una línea azu
       g.setColor(Color.BLUE);
       ((Graphics2D) g).setStroke(new BasicStroke(3));
       int xAzul = getWidth() - 40; // x es el mismo para ambos puntos
       int y1Azul = frameHeight / 16; // Punto inicial
       int y2Azul = y1Azul + 600; // Punto final, 500 píxeles más abajo
       g.drawLine(xAzul, y1Azul, xAzul, y2Azul); // Dibuja una línea vertical

        // Dibuja una línea verde
        g.setColor(Color.GREEN);
        ((Graphics2D) g).setStroke(new BasicStroke(3));
       int xverde = getWidth() - 60; // x es el mismo para ambos puntos
       int y1verde = frameHeight / 16; // Punto inicial
       int y2verde = y1verde + 600; // Punto final, 500 píxeles más abajo
       g.drawLine(xverde, y1verde, xverde, y2verde); // Dibuja una línea vertical


        // Otras personalizaciones de línea
        g.setColor(Color.BLACK);
        // Ancho de línea
        ((Graphics2D) g).setStroke(new BasicStroke(3));
       int xD = getWidth() - 80; // x es el mismo para ambos puntos
       int y1D = frameHeight / 16; // Punto inicial
       int y2D = y1D + 600; // Punto final, 500 píxeles más abajo
       g.drawLine(xD, y1D, xD, y2D); // Dibuja una línea vertical

        // Dibujar una línea diagonal
        g.setColor(Color.MAGENTA);
        ((Graphics2D) g).setStroke(new BasicStroke(3));
       int xM = getWidth() - 80; // x es el mismo para ambos puntos
       int y1M = frameHeight / 16; // Punto inicial
       int y2M = y1M + 600; // Punto final, 500 píxeles más abajo
       g.drawLine(xM, y1M, xM, y2M); // Dibuja una línea vertical
       
       
         // Dibuja una línea roja
      
       
    }
    
    
    
    
}



   