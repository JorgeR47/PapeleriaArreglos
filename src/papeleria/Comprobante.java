package papeleria;

import java.util.ArrayList;

public abstract class Comprobante {

    protected int numero;
    protected Producto producto;
    protected String fecha;

    public Comprobante(int numero, Producto producto, String fecha) {
        this.numero = numero;
        this.producto = producto;
        this.fecha = fecha;
    }

    public int getNumero() {
        return this.numero;
    }

    /*public void setNumero(String numero) {
        this.numero = numero;
    }*/

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return String.format("Numero de comprobante:%d%nFecha: %s%nProductos: %n%s", this.numero,this.fecha, this.producto.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || getClass() != obj.getClass()){ return false;}
        Comprobante comprobante = (Comprobante) obj;
        return numero == comprobante.numero &&
                (producto != null && producto.equals(comprobante.producto)) &&
                (fecha != null && fecha.equals(comprobante.fecha));
    }

    @Override
    public int hashCode() {
         int result = numero; 
         if (producto != null) {
        result += producto.hashCode(); 
         }
         if (fecha != null) {
        result += fecha.hashCode(); 
         }
         return result;
     }
}
