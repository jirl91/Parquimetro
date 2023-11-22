/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_parquimetro;


    
public class Tarjetas {
    
    private String pagoTarjeta;
     private String tarjeta;
    
    
    public String[] dTarjetas;

    // Constructor
    public Tarjetas() {
        // Inicializamos el array con la longitud necesaria
        dTarjetas = new String[1]; // Cambié la longitud a 1 ya que parece que solo necesitas almacenar un tipo de dato
    }

    // Método para almacenar los datos en la tarjeta
    public void almacenartarjetas(String pagoTarjeta) {
        // Almacena los datos de la tarjeta en el array
        dTarjetas[0] = pagoTarjeta;
        // Puedes continuar con la lógica para almacenar otros datos si es necesario
    }

    // Método para mostrar los datos de la tarjeta
    public void mostrarDatosTarjetas() {
        System.out.println("Su medio de pago es: " + dTarjetas[0]);
        // Puedes mostrar otros datos si es necesario
    }
    
    
    

    // Método para obtener el costo total como double
    
   public String obtenerTarjeta(String pagoTarjeta) {
        this.tarjeta = pagoTarjeta;
        return pagoTarjeta;
    }

    // Puedes tener un método adicional para obtener el valor de la tarjeta
     public String obtenerValorTarjeta() {
        return tarjeta;
    }

}


