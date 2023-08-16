package com.mycompany.evidenciasena.Vista;

public class ManejadorPantalla {
      
    public static VProducto pantallaProducto;
    public static void abrirPantallaProducto(){
    
        pantallaProducto = new VProducto();
        pantallaProducto.setVisible(true);
        pantallaProducto.setLocationRelativeTo(null);
    
    }
     
    public static void cerrarPantallaEstudiante(){
    pantallaProducto.setVisible(false);
    pantallaProducto=null;
   
    }
    
}
