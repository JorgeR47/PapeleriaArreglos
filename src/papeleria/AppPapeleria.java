package papeleria;

//import java.lang.Throwable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class AppPapeleria {//extends Throwable{

    public static void main(String[] args) {

        //Producto
        //lapiz
        Lapiz lp1 = new Lapiz("Bic", 0.75, "HB");
        Lapiz lp2 = new Lapiz("Bic", 0.65, "2B");
        //Cuaderno
        Cuaderno cuad1 = new Cuaderno("Norma", 1.25, 60, "cuadros");
        Cuaderno cuad2 = new Cuaderno("Norma", 1.5, 60, "Dos lineas");
        Cuaderno cd1 = new Cuaderno("Escribir", 1.50, 100, "Una linea");
        //Borrador
        Borrador borr1 = new Borrador("Borrador", 0.50, 70, "Lapiz");
        Borrador borr2 = new Borrador("Borrador", 1.50, 70, "Esfero");

        Producto[] inventario = new Producto[]{lp1, lp1};
        //Cliente
        Cliente cl1 = new Cliente("1234567890", "Juan", "juan@juan", "Casa de Juan", "Telefono de Juan");
        Cliente cl2 = new Cliente("1316630175", "Elkin", "Elkin@epn", "Quito", "0987654321");

        //Vendedor
        Vendedor vn1 = new Vendedor("0321456987", "Pedro", 8, "Vendedor");

        //Ingrese la Fecha del dia de hoy
        String Fecha = LocalDate.now().toString();

        //Valida si el usuario existe
        Scanner sc = new Scanner(System.in);

        //Variable
        boolean verificacion = false;
        Object Cliente = null;
        Object Vendedor = vn1;

        do {


            do {
                System.out.println("Ingrese el nombre del Cliente");
                String nombre = sc.nextLine();

                if (nombre.equals(cl2.getNombre())) {
                    System.out.println("El cliente se encuentra registrado");
                    Cliente = cl2;
                    verificacion = true;
                } else if (nombre.equals(cl1.getNombre())) {
                    System.out.println("El cliente se encuentra registrado");
                    Cliente = cl1;
                    verificacion = true;
                } else {
                    System.out.println("El cliente no se encuentra registrado");
                    verificacion = false;
                }
            } while (!verificacion);


            //Revisa que desea comprar
            //Variables
            int opciones;
            Producto[] ListaProductos = new Producto[0];

            do {
                System.out.println("\n\nEl Cliente que desea comprar");

                System.out.printf("1.- Lapiz \n2.- Cuaderno \n3.- Borrador\n4.- Mostrar inventario \n5.- Mostrar compras \n6.- Mostrar reservas \n");
                opciones = sc.nextInt();

                switch (opciones) {
                    case 1:
                        System.out.println("Desea comprar un lapiz");
                        System.out.println("Escoga un Lapiz\n");
                        System.out.println("1.- Lapiz HB");
                        System.out.println(lp1.toString());
                        System.out.println("2.- Lapiz 2B");
                        System.out.println(lp2.toString());

                        do {
                            int opciones2 = sc.nextInt();
                            if (opciones2 == 1) {
                                ListaProductos = Arrays.copyOf(ListaProductos, ListaProductos.length + 1);
                                ListaProductos[ListaProductos.length - 1] = lp1;

                                verificacion = true;
                            } else if (opciones2 == 2) {
                                ListaProductos = Arrays.copyOf(ListaProductos, ListaProductos.length + 1);
                                ListaProductos[ListaProductos.length - 1] = lp2;
                                verificacion = true;

                            } else {
                                System.out.println("Ingrese bien el numero");
                                verificacion = false;
                            }
                        } while (!verificacion);

                        break;
                    case 2:
                        System.out.println("Desea comprar un cuaderno");
                        System.out.println("Escoga un Cuaderno\n");
                        System.out.println("1.- Cuadros");
                        System.out.println(cuad1.toString());
                        System.out.println("2.- Dos lineas");
                        System.out.println(cuad2.toString());
                        System.out.println("3.- Una linea");
                        System.out.println(cd1.toString());

                        do {
                            int opciones2 = sc.nextInt();
                            if (opciones2 == 1) {
                                ListaProductos = Arrays.copyOf(ListaProductos, ListaProductos.length + 1);
                                ListaProductos[ListaProductos.length - 1] = cuad1;

                                verificacion = true;
                            } else if (opciones2 == 2) {
                                ListaProductos = Arrays.copyOf(ListaProductos, ListaProductos.length + 1);
                                ListaProductos[ListaProductos.length - 1] = cuad2;
                                verificacion = true;
                            } else if (opciones2 == 3) {
                                ListaProductos = Arrays.copyOf(ListaProductos, ListaProductos.length + 1);
                                ListaProductos[ListaProductos.length - 1] = cd1;

                                verificacion = true;
                            } else {
                                System.out.println("Ingrese bien el numero");
                                verificacion = false;
                            }
                        } while (!verificacion);

                        break;
                    case 3:
                        System.out.println("Desea comprar un borrador");
                        System.out.println("Escoga un Borrador\n");
                        System.out.println("1.- Borrador");
                        System.out.println(borr1.toString());
                        System.out.println("2.- Borrador de Esfero");
                        System.out.println(borr2.toString());

                        do {
                            int opciones2 = sc.nextInt();
                            if (opciones2 == 1) {
                                ListaProductos = Arrays.copyOf(ListaProductos, ListaProductos.length + 1);
                                ListaProductos[ListaProductos.length - 1] = borr1;

                                verificacion = true;
                            } else if (opciones2 == 2) {
                                ListaProductos = Arrays.copyOf(ListaProductos, ListaProductos.length + 1);
                                ListaProductos[ListaProductos.length - 1] = borr2;
                                verificacion = true;
                            } else {
                                System.out.println("Ingrese bien el numero");
                                verificacion = false;
                            }
                        } while (!verificacion);

                        break;
                    case 4:
                        do {
                            if (inventario != null) {
                                for (int i = 0; i < inventario.length; i++) {
                                    System.out.println(inventario[i]);
                                }
                            } else {
                                System.out.println("Inventario no encontrado");
                            }
                        } while (!verificacion);

                        break;

                    case 5:
                        if (inventario == null) {

                        } else {
                            System.out.println("Aun no se ha registrado ninguna compra");
                        }
                        break;
                    case 6:
                        if (inventario == null) {

                        } else {
                            System.out.println("Aun no se ha registrado ninguna reserva");
                        }
                        break;
                    default:
                        System.out.println("Error Page 404");
                }
                System.out.println("Desea Comprar mas ?");
                System.out.println("1.- Si \n2.- No");
                opciones = sc.nextInt();
                if (opciones == 1) {
                    verificacion = false;
                } else {
                    verificacion = true;
                }

            } while (!verificacion);


            System.out.println("Quiere comprar ahora o Quiere realizar una reserva");
            System.out.println("1.- Comprar \n2.- Reserva");
            opciones = sc.nextInt();


            switch (opciones) {
                case 1:
                    System.out.println("\nSu nota de venta es:");
                    NotaVenta notaVenta1 = new NotaVenta(ListaProductos[0], Fecha, (Cliente) Cliente);
                    System.out.printf(notaVenta1.toString());
                    for (int i = 1; i < ListaProductos.length; i++) {
                        System.out.println(ListaProductos[i]);
                    }
                    break;
                case 2:
                    System.out.println("Cuantos dias desea reservar");
                    int ReservaDias = sc.nextInt();
                    String fechaReserva = LocalDate.now().plusDays(ReservaDias).toString();
                    System.out.println("Cuantos va a ser el numero de cuotas a pagar");
                    int Cuotas = sc.nextInt();


                    Reserva reserva = new Reserva((Cliente) Cliente, ListaProductos[0], Fecha, fechaReserva, Cuotas, (Vendedor) Vendedor);

                    for (int i = 0; i < ListaProductos.length; i++) {
                        reserva.ValorTotal(ListaProductos[i]);
                    }
                    reserva.imprimirCuotas();


                    System.out.println();
                    System.out.println(reserva.toString());
                    for (int i = 1; i < ListaProductos.length; i++) {
                        System.out.println(ListaProductos[i]);
                    }

                    break;
                default:
                    System.out.println("Error Page 404");
            }
            System.out.println("Desea hacer otro pedido?");
            System.out.println("1.- Si \n2.- No");
            opciones = sc.nextInt();
            if (opciones == 1) {
                verificacion = false;
            } else {
                verificacion = true;
            }
        } while (!verificacion);
    }
}
