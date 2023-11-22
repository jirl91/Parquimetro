package com.mycompany.proyecto_parquimetro;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hora_$ {

    public String[] DatosHora;
    private int totalMinutos;
   // Nuevo atributo para almacenar los minutos

    // Constructor
    public Hora_$() {
        // Inicializamos el array con la longitud necesaria
        DatosHora = new String[4];
    }

    // Método para calcular la diferencia de minutos y almacenar los datos
    public void almacenarHora$(String horaEntrada, String horaSalida, String costoTotal) {
        // Almacena los datos de la hora en el resto de campos
        DatosHora[0] = horaEntrada;
        DatosHora[1] = horaSalida;
        DatosHora[3] = costoTotal;  // Cambié el índice de 2 a 3
    }

    // Método para mostrar los datos del cliente
    public void mostrarDatosHora() {
        System.out.println("Hora Entrada: " + DatosHora[0]);
        System.out.println("Hora Salida: " + DatosHora[1]);
        System.out.println("Total Minutos: " + totalMinutos);  // Cambié de DatosHora[2] a totalMinutos
    }

    // Método para convertir horas en formato hh:mm a minutos
    public int convertirHoraAMinutos(String hora) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date date = sdf.parse(hora);
            return date.getHours() * 60 + date.getMinutes();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0; // Manejo de error, puedes ajustarlo según tus necesidades
        }
    }

    // Método para calcular la diferencia de minutos
    public void calcularDiferenciaMinutos() {
        // Asegúrate de que los datos están presentes y son válidos
      
        // Asegúrate de que los datos están presentes y son válidos
        if (DatosHora[0] != null && DatosHora[1] != null) {
            int minutosEntrada = convertirHoraAMinutos(DatosHora[0]);
            int minutosSalida = convertirHoraAMinutos(DatosHora[1]);

            // Realiza operaciones con minutosEntrada y minutosSalida según sea necesario
            totalMinutos = minutosSalida - minutosEntrada;  // Modifiqué el nombre a totalMinutos

            System.out.println("Total Minutos: " + totalMinutos);

            // Luego, calcula el costo total y formatea el monto
            totalApagar();
        } else {
            System.out.println("Datos de hora incompletos");
        }
    }

    //

    // Método para calcular el costo total y formatear el monto
    public void totalApagar() {
        int precioPorMinuto = 35;

        int costoTotal = totalMinutos * precioPorMinuto;
        DatosHora[3] = String.valueOf(costoTotal);
        System.out.println("Costo Total: " + costoTotal);

        // Formatear el monto
        DecimalFormat formato = new DecimalFormat("$ #,###,###");
        String montoFormateado = formato.format(costoTotal);
        System.out.println("Costo Formateado: " + montoFormateado);
    }
}
    
    
   






    
 

    