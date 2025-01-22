package papeleria;

public class Reserva extends Comprobante implements IVA, Cargo {

    private static int contador = 0;
    private String fechaLimite;
    private Vendedor vendedor;
    private int numeroDeCuotas;
    private Cliente cliente;
    private Double valorTotalFinal;

    public Reserva(Cliente cliente, Producto producto, String fecha, String fechaLimite, int numeroDeCuotas, Vendedor vendedor) {
        super(++contador, producto, fecha);
        this.cliente = cliente;
        this.fechaLimite = fechaLimite;
        this.vendedor = vendedor;
        this.numeroDeCuotas = numeroDeCuotas;
    }

    @Override
    public double calculoCargo() {
        double valorDelCargo = producto.getPrecio() * Cargo.cargo;
        return producto.getPrecio() + valorDelCargo;
    }

    public double ValorTotal(Producto producto) {
        double valorTotal = producto.getPrecio();
        this.valorTotalFinal = valorTotal + producto.getPrecio();

        return valorTotalFinal;
    }

    public void imprimirCuotas() {
        double montoReferencial = producto.getPrecio();
        double tasaInteresDiaria = Cargo.cargo;
        double cuota = (montoReferencial * tasaInteresDiaria) / (1 - Math.pow(1 + tasaInteresDiaria, -numeroDeCuotas));
        double saldoPendiente = montoReferencial;
        System.out.printf("%-10s %-20s %-20s %-20s %-20s\n", "Cuota",
                "Valor de la cuota", "Intereses", "Capital amortizado", "Saldo pendiente");
        for (int i = 1; i <= numeroDeCuotas; i++) {
            double interes = saldoPendiente * tasaInteresDiaria;
            double capitalAmortizado = cuota - interes;
            saldoPendiente -= capitalAmortizado;
            System.out.printf("%-10d %-20.2f %-20.2f %-20.2f %-20.2f\n",
                    i, cuota, interes, capitalAmortizado, saldoPendiente);
        }
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }


    @Override
    public String toString() {
        return String.format("Valor de crédito: %.2f%nVálido hasta: %s%n%s%n%s", (impuestoIVA() - calculoCargo()), this.fechaLimite, this.vendedor.toString(), super.toString());
    }

    @Override
    public double impuestoIVA() {

        return (this.producto.getPrecio() * (1 + IVA));
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false; // Verifica los atributos heredados de Comprobante
        Reserva reserva = (Reserva) obj;
        return (fechaLimite != null ? fechaLimite.equals(reserva.fechaLimite) : reserva.fechaLimite == null) &&
                (vendedor != null ? vendedor.equals(reserva.vendedor) : reserva.vendedor == null);
    }

    @Override
    public int hashCode() {
        int result = 0;
        result += contador;
        if (fechaLimite != null) {
            result += fechaLimite.hashCode();
        }
        return result;
    }
}
