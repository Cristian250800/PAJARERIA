import java.util.ArrayList;
import java.util.Scanner;

public class Venta {

    private Cliente cliente;
    private ArrayList<Pajaro> lineasDeVenta;
    private String fecha;
    static ArrayList<Pajaro> pajarosVenta = new ArrayList<>();

    public Venta (Cliente cliente, ArrayList<Pajaro> lineasDeVenta, String fecha){
        this.cliente = cliente;
        this.lineasDeVenta = lineasDeVenta;
        this.fecha = fecha;
    }
    public Cliente verCliente(){
        return cliente;
    }
    public ArrayList<Pajaro> getLineasDeVenta() {
        return lineasDeVenta;
    }
    public String getFecha() {
        return fecha;
    }

    public static void menuVentas() {
        Scanner scanner = new Scanner(System.in);
        int opcionVenta;
        Cliente clienteSeleccionado = null;

        do {
            System.out.println("-------------------------------");
            System.out.println("---------VENTAS----------");
            System.out.println("1. Seleccionar cliente");
            System.out.println("2. Añadir pájaros");
            System.out.println("3. Confirmar venta");
            System.out.println("4. Cancelar venta");
            System.out.println("5. Volver al menú principal");
            System.out.println("Selecciona una opción:");

            opcionVenta = scanner.nextInt();
            scanner.nextLine();

            switch (opcionVenta) {
                case 1 -> clienteSeleccionado = seleccionarCliente();
                case 2 -> {
                    if (clienteSeleccionado == null) {
                        System.out.println("Primero debes seleccionar un cliente.");
                    } else {
                        ArrayList<Pajaro> listaPajarosFinal = seleccionarPajaro();
                        if (!listaPajarosFinal.isEmpty()) {
                            pajarosVenta.addAll(listaPajarosFinal);
                            System.out.println("Pájaros añadidos al carrito.");
                        } else {
                            System.out.println("No se añadieron pájaros al carrito.");
                        }
                    }
                }
                case 3 -> {}
                case 4 -> {}
                case 5 ->  System.out.println("Volviendo al menú principal.");
                default -> System.out.println("Opción no válida, intenta de nuevo.");
            }

        } while (opcionVenta != 5);
    }

    public static Cliente seleccionarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el DNI del cliente: ");
        String dni = scanner.nextLine();

        Cliente c = Cliente.buscarClientePorDNI(dni);

        if (c != null) {
            System.out.println("Cliente seleccionado:");
            System.out.println("Nombre: " + c.buscarNombre()  +
                    "\nDNI: " + c.buscarDNI() +
                    "\nTeléfono: " + c.buscarTelefono() +
                    "\nE-mail: " + c.buscarEmail());
            return c;
        } else {
            System.out.println("No se encontró ningún cliente con ese DNI.");
            return null;
        }
    }



    public static ArrayList<Pajaro> seleccionarPajaro() {
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        boolean seguir;
        ArrayList<Pajaro> pajarosSeleccionados = new ArrayList<>();

        System.out.println("¿Deseas consultar el catálogo? (s/n)");
        String respuestaCatalogo = scanner.nextLine();

        if (respuestaCatalogo.equalsIgnoreCase("s")) {
            Pajaro.mostrarCatalogo();
        }

        if (main.pajaros.isEmpty()) {
            System.out.println("No hay pájaros disponibles en el catálogo.");
            return pajarosSeleccionados;
        }

        do {
            System.out.println("Escribe el nombre del pájaro que quieras añadir:");
            String nombrePajaro = scanner.nextLine();

            Pajaro pajaroEncontrado = null;
            for (Pajaro p : main.pajaros) {
                if (p.buscarEspecie().equalsIgnoreCase(nombrePajaro)) {
                    pajaroEncontrado = p;
                    break;
                }
            }

            if (pajaroEncontrado != null) {
                System.out.println("¿Cuántos deseas añadir?");
                int cantidad = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < cantidad; i++) {
                    pajarosSeleccionados.add(pajaroEncontrado);
                }

                System.out.println("Se han añadido " + cantidad + " pájaros al carrito.");
            } else {
                System.out.println("No se encontró ningún pájaro con ese nombre.");
            }

            System.out.println("¿Deseas añadir más pájaros al carrito? (s/n)");
            respuesta = scanner.nextLine();
            seguir = respuesta.equalsIgnoreCase("s");

        } while (seguir);
        return pajarosSeleccionados;
    }



}


