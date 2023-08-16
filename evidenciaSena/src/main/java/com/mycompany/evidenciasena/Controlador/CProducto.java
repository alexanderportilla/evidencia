package com.mycompany.evidenciasena.Controlador;


import com.mycompany.evidenciasena.Modelo.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CProducto {
    
      public void registrarProducto(Producto p) {
          
          try {
              Statement st = Conexion.getConect().createStatement();
              st.execute("insert into producto values ('" + p.getCodigo() + "','" + p.getNombre() + "','" + p.getPrecio() + "','" + p.getCantidad() + "'  ) ");
              JOptionPane.showMessageDialog(null, "Registrado");
          } catch (SQLException ex) {
              Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
          }
          

    }   
    
    public ResultSet consultarProducto() {
        ResultSet rs = null;
        try {
            Statement st = Conexion.getConect().createStatement();
            rs = st.executeQuery("select * from producto");
          
        } catch (SQLException ex) {
            Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
           
        }

        return rs;
    
    }
    
    public ResultSet consultarProductoId(int codigo) {
    
         ResultSet rs = null;

        try {
            Statement st = Conexion.getConect().createStatement();
            rs = st.executeQuery("select * from producto where codigo = '" + codigo + "'");

        } catch (SQLException ex) {
            Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);

        }
        return rs;    
    
    }
    
    public void modificarProducto(Producto p) {
      try {
              Statement st =Conexion.getConect().createStatement();
              st.execute("update producto set codigo= '"+p.getCodigo()+"',nombre='"+p.getNombre()+"',precio='"+p.getPrecio()+" ',cantidad='"+p.getCantidad()+"' where codigo='"+p.getCodigo()+"'  ");
              JOptionPane.showMessageDialog(null, "Actualizado");
              
      } catch (SQLException ex) {
              Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
          }
                
    }
    
    public void eliminarProducto(int codigo) {
    
    try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("delete from producto where codigo='"+codigo+"'");
            JOptionPane.showMessageDialog(null, "Eliminado");

        } catch (SQLException ex) {
            Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Problemas,No Elimino");
        }

             
    }
    
    
    public void pintarTabla(JTable  tabla, ResultSet rs){
    
         DefaultTableModel modelo= new DefaultTableModel();
        
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
      
        
          try {
              
                    while (rs.next()) {
                            int codigo = rs.getInt("codigo");
                            String nombre = rs.getString("nombre");
                            int preciot = rs.getInt("precio");
                            int cantidad = rs.getInt("cantidad");
                            String[] fila = {String.valueOf(codigo), nombre, String.valueOf(preciot), String.valueOf(cantidad)};
                            modelo.addRow(fila);
        }

          
              tabla.setModel(modelo);
          
          } catch (SQLException ex) {
              Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
}
    }

        
}

