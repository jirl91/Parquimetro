package com.mycompany.atencion_medica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

class ReservasInterfaz extends JFrame {

    private Atencion_medica inicioInterfaz;
    private DefaultTableModel tableModel;
    private List<String> reservas;

    private MedicoInterfaz medicoInterfaz;

    public ReservasInterfaz(Atencion_medica inicioInterfaz, List<String> reservas) {
        this.inicioInterfaz = inicioInterfaz;
        this.reservas = reservas;

        setTitle("Reserva ");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre del Médico");
        tableModel.addColumn("Nombre del Paciente");
        tableModel.addColumn("Especialidad");
        tableModel.addColumn("Hora Disponible");

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> {
            inicioInterfaz.setVisible(true);
            dispose();
        });

        JButton botonVerMedico = new JButton("Ver Médico");
        botonVerMedico.addActionListener(e -> {
            medicoInterfaz = new MedicoInterfaz(inicioInterfaz, ReservasInterfaz.this);
            medicoInterfaz.setVisible(true);
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(botonCerrar, BorderLayout.SOUTH);
        panel.add(botonVerMedico, BorderLayout.NORTH);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public void actualizarReservas(List<String> nuevasReservas) {
        // Borra las filas existentes en la tabla
        tableModel.setRowCount(0);

        // Agrega las nuevas reservas a la tabla
        for (String reserva : nuevasReservas) {
            String[] partes = reserva.split("\n");
            tableModel.addRow(new String[]{partes[0].split(": ")[1], partes[1].split(": ")[1], partes[2].split(": ")[1], partes[3].split(": ")[1]});
        }
    }

    public void agregarReserva(List<String> informacionMedico) {
        // Agrega la nueva reserva a la lista y actualiza la tabla
        reservas.add(informacionMedico.toString());
        tableModel.addRow(informacionMedico.toArray(new String[0]));
    }

    public List<String> obtenerReservas() {
        return reservas;
    }
    

}