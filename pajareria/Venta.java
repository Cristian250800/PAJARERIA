import java.util.ArrayList;
import java.util.Scanner;

public class Venta {

    private Cliente cliente;
    private ArrayList<Pajaro> lineasDeVenta;
    private String fecha;

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
                case 2 -> {}
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



}
