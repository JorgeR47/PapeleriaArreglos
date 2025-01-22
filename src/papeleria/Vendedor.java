package papeleria;

public class Vendedor extends Persona {

    private int horasTurno;
    private String puesto;

    public Vendedor(String cedula, String nombre, int horasTurno, String puesto) {

        super(cedula, nombre);
        this.horasTurno = horasTurno;
        this.puesto = puesto;
    }

    public int getHorasTurno() {

        return this.horasTurno;
    }

    public void setHorasTurno(int horasTurno) {

        this.horasTurno = horasTurno;
    }

    public String getPuesto() {

        return this.puesto;
    }

    public void setPuesto(String puesto) {

        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return String.format("%sPuesto: %s%n",super.toString(),this.puesto);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false; // Comparar con la implementación en Persona
        Vendedor vendedor = (Vendedor) obj;
        return horasTurno == vendedor.horasTurno &&
                (puesto != null && puesto.equals(vendedor.puesto));
    }

   @Override
    public int hashCode() {
        int result = 0; 
        result += horasTurno; 
        if (puesto != null) {
        result += puesto.hashCode(); 
        }
    return result;
    }
}
