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
    public static void imprimirProductos(Producto[] productos) { //todo confirmar si es static, y que ocupen las clases hijas de Comprobante
        // Arreglo auxiliar para contar las repeticiones
        boolean[] numeracionDeProductos = new boolean[productos.length];

        // Imprimir la tabla
        System.out.printf("%-10s %-50s %-10s\n", "Unidades", "Producto", "Precio");
        System.out.println("--------------------------------------------------------------------");

        // Recorremos el arreglo de productos
        for (int i = 0; i < productos.length; i++) {
            // Si ya fue contado este producto, lo saltamos
            if (numeracionDeProductos[i]) continue;

            Producto productoActual = productos[i];
            int cantidad = 0;

            // Contamos las repeticiones de este producto
            for (int j = 0; j < productos.length; j++) {
                if (productoActual.toString().equals(productos[j].toString())) {
                    cantidad++;
                    numeracionDeProductos[j] = true;  // Marcamos este producto como contado
                }
            }

            // Imprimir la información del producto en el orden solicitado
            System.out.printf("%-10d %-50s %-10.2f\n", cantidad, productoActual.getNombre(), productoActual.getPrecio());
        }
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
        return String.format("Numero de comprobante:%d%nFecha: %s%nProductos: %n%s", this.numero, this.fecha, this.producto.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
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
