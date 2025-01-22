package papeleria;

import java.util.ArrayList;

public class NotaVenta extends Comprobante {

    private static int contador = 0;
    private Cliente cliente;
    //no hay impuestos


    public NotaVenta(Producto producto, String fecha, Cliente cliente) {


        super(++contador,producto, fecha);
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n",cliente, super.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false; // Verifica los atributos heredados de Comprobante
        NotaVenta that = (NotaVenta) obj;
        return (cliente != null ? cliente.equals(that.cliente) : that.cliente == null);
    }

   @Override
    public int hashCode() {
        int result = 0; 
        if (cliente != null) {
        result += cliente.hashCode(); 
       }
        return result;
    }
}
