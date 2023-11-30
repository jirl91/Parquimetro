package com.mycompany.atencion_medica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class MedicoInterfaz extends JFrame {
    
    //Se declaran las variables de instancia inicioInterfaz 
    //y reservasInterfaz. También se crea una lista (reservas) para almacenar la información de las 

    private Atencion_medica inicioInterfaz;
    private ReservasInterfaz reservasInterfaz;
    private List<String> reservas = new ArrayList<>();
    
    
    //Se declaran componentes gráficos 
    //como etiquetas (JLabel), cuadros de lista JComboBox, un campo de texto JTextField y etiquetas de resultado.

    private JLabel labelNombreMedico;
    private JComboBox<String> comboBoxNombresMedicos;
    private JLabel labelNombrePaciente;
    private JTextField textFieldNombrePaciente;
    private JLabel labelNombrePacienteResultado;
    private JLabel labelEspecialidad;
    private JComboBox<String> comboBoxEspecialidad;
    private JLabel labelHoraDisponible;
    private JComboBox<String> comboBoxHoraDisponible;
    private JLabel labelValorHora;
    
    //Se declara un modelo de tabla DefaultTableModel para manejar la información de la tabla.

    private DefaultTableModel tableModel; // Agregado
    
    //Se define el constructor de la clase, que recibe instancias de Atencion_medica y ReservasInterfaz

    public MedicoInterfaz(Atencion_medica inicioInterfaz, ReservasInterfaz reservasInterfaz) {
        
        //Se establece el título, tamaño, operación de cierre y la ubicación de la ventana.
        
        this.inicioInterfaz = inicioInterfaz;
        this.reservasInterfaz = reservasInterfaz;
        setTitle("Interfaz Médico");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(900, 300);
       
        //Se crea e inicializa el modelo de tabla con columnas específicas.
        tableModel = new DefaultTableModel(); // Agregado
        tableModel.addColumn("Nombre del Médico");
        tableModel.addColumn("Nombre del Paciente");
        tableModel.addColumn("Especialidad");
        tableModel.addColumn("Hora Disponible");

        labelNombreMedico = new JLabel("Nombre del médico:");
        String[] nombresMedicos = {"Seleccionar ", "Juan Meza ", "Pedro Pascal", "Juan Fernandez", "Ricardo Araya", "Magdalena Montes", "Isidora Goyenechea"};
        comboBoxNombresMedicos = new JComboBox<>(nombresMedicos);

        labelNombrePaciente = new JLabel("Nombre del paciente:");
        textFieldNombrePaciente = new JTextField();
        labelNombrePacienteResultado = new JLabel("");

        labelEspecialidad = new JLabel("Especialidad:");
        String[] especialidades = {"Seleccionar ", "Medicina general ", "Pediatría", "Traumatología", "Dermatología", "Oftalmología", "Otorrinolaringolodía", "Ginecología"};
        comboBoxEspecialidad = new JComboBox<>(especialidades);

        labelHoraDisponible = new JLabel("Hora disponible:");
        String[] horasDisponibles = {"Seleccionar", "8 am", "9 am", "10 am", "11 am", "12 pm", "1 pm", "2 pm", "3 pm", "4 pm", "5 pm", "6 pm", "7 pm"};
        comboBoxHoraDisponible = new JComboBox<>(horasDisponibles);

        labelValorHora = new JLabel("Valor hora: $ 7,000");
        
        //Creación de componentes gráficos como etiquetas, cuadros de lista

        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensaje = "Nombre del médico: " + comboBoxNombresMedicos.getSelectedItem() + "\n" +
                        "Nombre del paciente: " + textFieldNombrePaciente.getText() + "\n" +
                        "Especialidad: " + comboBoxEspecialidad.getSelectedItem() + "\n" +
                        "Hora disponible: " + comboBoxHoraDisponible.getSelectedItem() + "\n" +
                        "Valor hora: $7,000";

                JOptionPane.showMessageDialog(MedicoInterfaz.this, mensaje);

                labelNombrePacienteResultado.setText("Nombre del paciente: " + textFieldNombrePaciente.getText());

                // Después de agregar la información
                List<String> informacionMedico = new ArrayList<>();
                informacionMedico.add(comboBoxNombresMedicos.getSelectedItem().toString());
                informacionMedico.add(textFieldNombrePaciente.getText());
                informacionMedico.add(comboBoxEspecialidad.getSelectedItem().toString());
                informacionMedico.add(comboBoxHoraDisponible.getSelectedItem().toString());

                reservasInterfaz.agregarReserva(informacionMedico);
            }
        });

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        //Se crea un panel con un diseño de cuadrícula para organizar
        //los componentes, y se agregan los componentes al panel.
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));
        panel.add(labelNombreMedico);
        panel.add(comboBoxNombresMedicos);
        panel.add(labelNombrePaciente);
        panel.add(textFieldNombrePaciente);
        panel.add(labelEspecialidad);
        panel.add(comboBoxEspecialidad);
        panel.add(labelHoraDisponible);
        panel.add(comboBoxHoraDisponible);
        panel.add(labelValorHora);
        panel.add(new JLabel());
        panel.add(botonAceptar);
        panel.add(botonCancelar);
        panel.add(labelNombrePacienteResultado);
        panel.add(new JLabel());

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public String obtenerInformacion() {
        // Método para obtener la información ingresada en MedicoInterfaz
        String nombreMedico = comboBoxNombresMedicos.getSelectedItem().toString();
        String nombrePaciente = textFieldNombrePaciente.getText();
        String especialidad = comboBoxEspecialidad.getSelectedItem().toString();
        String horaDisponible = comboBoxHoraDisponible.getSelectedItem().toString();

        // Devolver la información formateada
        return "Nombre del médico: " + nombreMedico + "\n" +
                "Nombre del paciente: " + nombrePaciente + "\n" +
                "Especialidad: " + especialidad + "\n" +
                "Hora disponible: " + horaDisponible;
    }

    public String getNombreMedico() {
        return comboBoxNombresMedicos.getSelectedItem().toString();
    }

    public String getNombrePaciente() {
        return textFieldNombrePaciente.getText();
    }

    public String getEspecialidad() {
        return comboBoxEspecialidad.getSelectedItem().toString();
    }

    public String getHoraDisponible() {
        return comboBoxHoraDisponible.getSelectedItem().toString();
    }

    public void agregarReserva(List<String> informacionMedico) {
        // Lógica para agregar la información del médico a la tabla de ReservasInterfaz
        tableModel.addRow(informacionMedico.toArray(new String[0]));
        reservasInterfaz.actualizarReservas(obtenerReservas());
    }

    public List<String> obtenerReservas() {
        // Devuelve la lista de reservas actualizada
        List<String> reservas = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            StringBuilder reserva = new StringBuilder();
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                reserva.append(tableModel.getValueAt(i, j)).append("\n");
            }
            reservas.add(reserva.toString());
        }
        return reservas;
    }
}