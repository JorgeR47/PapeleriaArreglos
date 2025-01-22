package papeleria;

public class Borrador extends Producto {
    
    private double peso;
    private String tipo;
    
    public Borrador(String nombre, double precio, double peso, String tipo) {
        
        super(nombre, precio);
        this.peso = peso;
        this.tipo = tipo;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        
        return String.format("%sBorrador de %s con un gramaje de %.2f gramos%n",super.toString(), this.tipo, this.peso);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Borrador)) return false;
        Borrador other = (Borrador) obj;
        return Double.compare(other.peso, peso) == 0 &&
                (tipo != null ? tipo.equals(other.tipo) : other.tipo == null);
    }

   @Override
     public int hashCode() {
         int result = 0; 
         result += (int) peso; 
         if (tipo != null) {
         result += tipo.hashCode(); 
     }
         return result;
     }
}
