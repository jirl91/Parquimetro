package com.mycompany.atencion_medica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Se define una clase llamada Atencion_medica que extiende de JFrame, lo que significa que es una ventana de Swing

class Atencion_medica extends JFrame {
    
   // Se declaran variables de instancia 
    //(inicioInterfaz, reservasInterfaz, medicoInterfaz) para representar instancias de otras clases.

    private Atencion_medica inicioInterfaz;
    private ReservasInterfaz reservasInterfaz;
    private MedicoInterfaz medicoInterfaz;
    
    //Se define el constructor de la clase. En este caso, configura la apariencia inicial de la ventana principal.

    public Atencion_medica() {
        
        //Se establece el título, tamaño, operación de cierre y la capacidad de redimensionar la ventana principal.
        setTitle("Reserva Medica"); 
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        //Se crean tres botones 
        //botonMedico, botonReservas, botonCerrar con sus
        //respectivos listeners. Estos botones se agregan a un panel principal.

        JButton botonMedico = new JButton("Médico");
        botonMedico.addActionListener(e -> abrirInterfazMedico());

        JButton botonReservas = new JButton("Reservas");
        botonReservas.addActionListener(e -> abrirInterfazReservas());

        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> {
            if (medicoInterfaz != null) {
                medicoInterfaz.dispose();
            }

            if (reservasInterfaz != null) {
                reservasInterfaz.dispose();
            }

            dispose();
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(botonMedico);
        panel.add(botonReservas);
        panel.add(botonCerrar);

        getContentPane().add(panel);
        
        //Se obtiene el tamaño de la pantalla y
        //se calcula la posición (x, y) para centrar la ventana en la pantalla.

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = 0;

        setLocation(x, y);
    }
     
    ////  para obtener información del MedicoInterfaz
    private String obtenerInformacionMedico() {
        if (medicoInterfaz != null) {
            // Obtener la información del MedicoInterfaz utilizando los métodos get
            String nombreMedico = medicoInterfaz.getNombreMedico();
            String nombrePaciente = medicoInterfaz.getNombrePaciente();
            String especialidad = medicoInterfaz.getEspecialidad();
            String horaDisponible = medicoInterfaz.getHoraDisponible();

            // Devolver la información formateada
            return "Nombre del médico: " + nombreMedico + "\n" +
                    "Nombre del paciente: " + nombrePaciente + "\n" +
                    "Especialidad: " + especialidad + "\n" +
                    "Hora disponible: " + horaDisponible;
        } else {
            return "No hay información disponible del MedicoInterfaz.";
        }
    }
  
    //para abrir la interfaz del médico
    private void abrirInterfazMedico() {
        reservasInterfaz = new ReservasInterfaz(inicioInterfaz, new ArrayList<>());
        medicoInterfaz = new MedicoInterfaz(inicioInterfaz, reservasInterfaz);

        this.setVisible(true);
        medicoInterfaz.setLocation(20, 300);
        medicoInterfaz.setVisible(true);
    }

  private void abrirInterfazReservas() {
    if (medicoInterfaz != null) {
        reservasInterfaz = new ReservasInterfaz(inicioInterfaz, medicoInterfaz.obtenerReservas());
        
        // Configura la ubicación de la ventana ReservasInterfaz
        int x = this.getLocation().x + this.getWidth();
        int y = this.getLocation().y;
        reservasInterfaz.setLocation(900, 300);
        
        reservasInterfaz.setVisible(true);
    } else {
        // Indica al usuario que primero debe abrir la interfaz del médico
        JOptionPane.showMessageDialog(this, "Primero debe abrir la interfaz del médico.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Atencion_medica inicioInterfaz = new Atencion_medica();
            inicioInterfaz.setVisible(true);
        });
    }
}

