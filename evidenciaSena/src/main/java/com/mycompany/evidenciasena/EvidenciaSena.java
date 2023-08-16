package com.mycompany.evidenciasena;

import com.mycompany.evidenciasena.Controlador.Conexion;
import com.mycompany.evidenciasena.Vista.ManejadorPantalla;


public class EvidenciaSena {

   public static void main(String[] args) {
        Conexion.conectar();
        
        
        
        ManejadorPantalla.abrirPantallaProducto();
    }
}
