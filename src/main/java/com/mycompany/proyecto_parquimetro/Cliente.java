/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_parquimetro;
import com.mycompany.proyecto_parquimetro.Parquimetro;
import com.mycompany.proyecto_parquimetro.Datos_ingreso;
 

public class Cliente {
    public String[] datosCliente; // Usaremos un array para almacenar los datos del cliente
    

    // Constructor
 public Cliente() {
        // Inicializamos el array con la longitud necesaria
        datosCliente = new String[5];
    }

    // Método para almacenar datos del cliente en el array
 public void almacenarDatosCliente(String nombreCompleto, String edad, String RUT, String Pasaporte, String nacionalidad) {
    datosCliente[0] = nombreCompleto;
    datosCliente[1] = edad;
    datosCliente[2] = RUT;
    datosCliente[3] = Pasaporte;
    datosCliente[4] = nacionalidad;
    

    }

    // Método para mostrar los datos del cliente
    public void mostrarDatosCliente() {
        System.out.println("Nombre completo: " + datosCliente[0]);
        System.out.println("Edad: " + datosCliente[1]);
        System.out.println("RUT: " + datosCliente[2]);
        System.out.println("Pasaporte : " + datosCliente[3]);
        System.out.println("Nacionalidad: " + datosCliente[4]);
      
    }
    

}
