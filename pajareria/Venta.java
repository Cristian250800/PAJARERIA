import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Venta {

    private Cliente cliente;
    private ArrayList<Pajaro> lineasDeVenta;
    private String fecha;
    static ArrayList<Pajaro> pajarosVenta = new ArrayList<>();
    static Cliente clienteSeleccionado = null;
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
    static ArrayList<Venta> registroVentas = new ArrayList<>();

    public static void menuVentas() {
        Scanner scanner = new Scanner(System.in);
        int opcionVenta = 0;


        do {
            System.out.println("-------------------------------");
            System.out.println("---------VENTAS----------");
            System.out.println("1. Seleccionar cliente");
            System.out.println("2. Añadir pájaros");
            System.out.println("3. Confirmar venta");
            System.out.println("4. Cancelar venta");
            System.out.println("5. Mostrar el registro de ventas");
            System.out.println("6. Volver al menú principal");
            System.out.println("Selecciona una opción:");

            try {
                opcionVenta = scanner.nextInt();
                scanner.nextLine();

                if (opcionVenta < 1 || opcionVenta >6){
                    System.out.println("El menú de opciones es de 1 a 6");
                    opcionVenta = 0;
                    continue;
                }

            }catch (InputMismatchException e){
                System.out.println("Debes introducir un número entero.");
                opcionVenta = 0;
                scanner.nextLine();
                continue;
            }


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
                case 3 -> {
                    if (clienteSeleccionado == null) {
                        System.out.println("Primero debes seleccionar un cliente.");
                    } else if (pajarosVenta.isEmpty()) {
                        System.out.println("No hay pájaros en el carrito.");
                    } else {
                        confirmarVenta();
                    }
                }
                case 4 -> {
                    if (clienteSeleccionado == null && pajarosVenta.isEmpty()) {
                        System.out.println("No hay ninguna venta en curso");
                    }else {
                        cancelarVenta();
                    }
                }
                case 5 ->  registroVentas();
                case 6 -> System.out.println("Volviendo al menú principal.");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcionVenta != 6);
        scanner.close();
    }

    public static Cliente seleccionarCliente() {
        Scanner scanner = new Scanner(System.in);

        String dni;

        while (true){
            System.out.print("Introduce el DNI del cliente: ");
            dni = scanner.nextLine().toUpperCase();

            if (!dni.matches("\\d{8}[A-Z]")){
                System.out.println("Formato inválido. (8 dígitos + letra)");
                continue;
            }


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
                boolean respuesta = pedirConfirmacion(scanner,"¿Quieres intentarlo otra vez?" );
                if (!respuesta){
                    System.out.println("Se ha cancelado el proceso de selección");
                    return null;
                }

            }
            scanner.close();
        }
    }



    public static ArrayList<Pajaro> seleccionarPajaro() {
        Scanner scanner = new Scanner(System.in);
        boolean seguir = true;
        ArrayList<Pajaro> pajarosSeleccionados = new ArrayList<>();

        boolean respuestaCatalogo = pedirConfirmacion(scanner, "Deseas consultar el catálogo?");

        if (respuestaCatalogo) {
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

            if (pajaroEncontrado == null) {
                System.out.println("No se encontró ningún pájaro con ese nombre");
                boolean siNo = pedirConfirmacion(scanner, "Quieres intentarlo otra vez?");
                if (siNo) {
                    continue;
                }
                else{
                    System.out.println("Se ha cancelado el proceso de selección");
                    break;
                }

            }else {
                int cantidad = -1;
                while (cantidad < 0) {
                    System.out.println("¿Cuántos deseas añadir?");
                    try {
                        cantidad = Integer.parseInt(scanner.nextLine());
                        if (cantidad < 0) {
                            System.out.println("La cantidad no puede ser negativa.");
                        } else if (cantidad == 0) {
                            System.out.println("Al introducir 0 no se añadirá ningún pájaro.");
                        } else {
                            for (int i = 0; i < cantidad; i++) {
                                pajarosSeleccionados.add(pajaroEncontrado);
                            }
                            System.out.println("Se han añadido " + cantidad + " pájaros al carrito.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida, introduce un número entero.");
                        cantidad = -1;
                    }
                }
            }

            seguir = pedirConfirmacion(scanner, "Quieres añadir más pájaros al carrito?");

        } while (seguir);
        scanner.close();
        return pajarosSeleccionados;
    }


    public static void confirmarVenta() {
        if (pajarosVenta.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }


        class DatosVenta {
            int cantidad;
            double precioUnitario;

            DatosVenta(int cantidad, double precioUnitario) {
                this.cantidad = cantidad;
                this.precioUnitario = precioUnitario;
            }
        }

        Map<String, DatosVenta> resumen = new HashMap<>();
        double totalCompra = 0;

        for (Pajaro p : pajarosVenta) {
            String especie = p.buscarEspecie();
            double precio = p.buscarPrecio();

            if (resumen.containsKey(especie)) {
                resumen.get(especie).cantidad++;
            } else {
                resumen.put(especie, new DatosVenta(1, precio));
            }
        }

        System.out.println("Resumen del carrito:");

        for (Map.Entry<String, DatosVenta> entry : resumen.entrySet()) {
            String especie = entry.getKey();
            DatosVenta datos = entry.getValue();
            double precioFinal = datos.cantidad * datos.precioUnitario;
            totalCompra += precioFinal;

            System.out.println("Especie: " + especie +
                    " || Cantidad: " + datos.cantidad +
                    " || Precio unitario: " + datos.precioUnitario + " €" +
                    " || Precio total: " + precioFinal + " €");
        }

        System.out.println("Total de la compra: " + totalCompra + " €");

        String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Venta ventaConfirmada = new Venta(clienteSeleccionado, new ArrayList<>(pajarosVenta), fechaActual);
        registroVentas.add(ventaConfirmada);

        pajarosVenta.clear();
        clienteSeleccionado = null;

    }

    public static void cancelarVenta(){
        Scanner scanner = new Scanner(System.in);
        boolean cancelar = pedirConfirmacion(scanner, "Estás seguro de que quieres cancelar la venta?");
        if (cancelar) {
            pajarosVenta.clear();
            clienteSeleccionado = null;
            System.out.println("La venta ha sido cancelada.");
        } else {
            System.out.println("Se ha cancelado el proceso de cancelación");
        }
        scanner.close();
    }


    public static void registroVentas(){
        if (registroVentas.isEmpty()) {
            System.out.println("No hay ventas registradas");
            return;
        }

        System.out.println("-----REGISTRO DE VENTAS-----");

        int contador = 1;
        for (Venta venta : registroVentas) {
            System.out.println("Nº: " + contador++);
            System.out.println("Cliente: " + venta.verCliente().buscarNombre() +
                    " (DNI: " + venta.verCliente().buscarDNI() + ")");
            System.out.println("Fecha: " + venta.getFecha());

            System.out.println("Venta realizada: ");
            double totalVenta = 0;
            for (Pajaro p : venta.getLineasDeVenta()) {
                System.out.println("Especie: " + p.buscarEspecie() + " || Precio unitario: " + p.buscarPrecio() + " €");
                totalVenta += p.buscarPrecio();
            }
            System.out.println("Precio total venta: " + totalVenta + " €");
            System.out.println("------------------------------");

        }
    }


    public static boolean pedirConfirmacion(Scanner scanner, String mensaje) {
        String respuesta;
        do {
            System.out.print(mensaje + " (s/n): ");
            respuesta = scanner.nextLine().trim().toLowerCase();
            if (!respuesta.equals("s") && !respuesta.equals("n")) {
                System.out.println("Introduce 's' para sí o 'n' para no.");
            }
        } while (!respuesta.equals("s") && !respuesta.equals("n"));
        return respuesta.equals("s");
    }
}


