/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_parquimetro;
import com.mycompany.proyecto_parquimetro.Parquimetro;
import com.mycompany.proyecto_parquimetro.Datos_ingreso;

 
public class DatosVehiculo {
    
     public String[] DatosVehiculo;
     
     
     
     public DatosVehiculo (){
         
         DatosVehiculo = new String [3];
         
         
     }
     
     
     
     public void almacenarDatosVehiculo (String patente, String modelo, String color){
         
         DatosVehiculo [0]= patente;
         DatosVehiculo [1]= modelo;
         DatosVehiculo [2]= color;
     }
     
     
     public void mostrarDatosVehiculo (){
         
         System.out.println("Patente: " + DatosVehiculo[0]);
         System.out.println("Modelo vehiculo: " + DatosVehiculo[1]);
         System.out.println("Color vehiculo: " + DatosVehiculo[2]);
     }
    
}
