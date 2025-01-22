package papeleria;

public class Cliente extends Persona {

    private String correo;
    private String direccion;
    private String telefono;

    public Cliente(String cedula, String nombre, String correo, String direccion, String telefono) {
        super(cedula, nombre);
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getCorreo() {

        return this.correo;
    }

    public void setCorreo(String correo) {

        this.correo = correo;
    }

    public String getDireccion() {

        return this.direccion;
    }

    public void setDireccion(String direccion) {

        this.direccion = direccion;
    }

    public String getTelefono() {

        return this.telefono;
    }

    public void setTelefono(String telefono) {

        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return String.format("%sDireccion: %s%nTelefono: %s%nCorreo EletrĂ³nico: %s%n",super.toString(),this.direccion,
                this.telefono, this.correo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false; // Comparar con la implementación en Persona
        Cliente cliente = (Cliente) obj;
        return (correo != null && correo.equals(cliente.correo)) &&
                (direccion != null && direccion.equals(cliente.direccion)) &&
                (telefono != null && telefono.equals(cliente.telefono));
    }

   @Override
     public int hashCode() {
         int result = 0; 
         if (correo != null) {
        result += correo.hashCode(); 
         }
         if (direccion != null) {
        result += direccion.hashCode(); 
        }
         if (telefono != null) {
        result += telefono.hashCode(); 
        }
        return result;
     }
}
