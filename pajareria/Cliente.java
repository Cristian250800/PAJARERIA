import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {

        private String nombre;
        private String dni;
        private String telefono;
        private String email;
        public Cliente(String nombre, String dni, String telefono, String email) {
                this.nombre = nombre;
                this.dni = dni;
                this.telefono = telefono;
                this.email = email;
        }

        public static void menuCliente(){
                Scanner scanner = new Scanner(System.in);
                int opcionCliente =0;

                do {
                        System.out.println("---------------------------------");
                        System.out.println("   GESTIÓN DE CLIENTES");
                        System.out.println("1. Alta de clientes");
                        System.out.println("2. Baja de clientes");
                        System.out.println("3. Modificación de clientes");
                        System.out.println("4. Búsqueda por DNI");
                        System.out.println("5. Listado de clientes");
                        System.out.println("6. Volver al menú principal");
                        System.out.println("Escoge una opción para continuar: ");
                        try {
                                opcionCliente = scanner.nextInt();
                                scanner.nextLine();

                                if (opcionCliente < 1 || opcionCliente >6){
                                        System.out.println("El menú de opciones es de 1 a 6");
                                        opcionCliente = 0;
                                        continue;
                                }
                        }catch (InputMismatchException e){
                                System.out.println("Debes introducir un número del 1 al 6");
                                opcionCliente=0;
                                scanner.nextLine();
                        }
                        switch (opcionCliente) {
                                case 1 -> altaNuevoCliente();
                                case 2 -> bajaCliente();
                                case 3 -> modificarCliente();
                                case 4 -> buscarPorDNI();
                                case 5 -> mostrarTodosLosClientes();
                                case 6 -> System.out.println("Volviendo al menú principal.");
                        }

                }while (opcionCliente != 6);
        }


        public static Cliente altaNuevoCliente() {

                Scanner altaCliente = new Scanner(System.in);

                System.out.println("Introduce tu nombre completo:");
                String nombre = altaCliente.nextLine();

               String dni;
               do {
                       System.out.println("Introduce tu dni con letra incluida: ");
                        dni = altaCliente.nextLine().trim();
                       if (!dni.matches("\\d{8}[A-Z]")){
                               System.out.println("Formato inválido. (8 dígitos + letra)");
                               dni = null;
                       }else if(buscarClientePorDNI(dni)!=null ) {
                               System.out.println("Ya existe un cliente con ese DNI");
                               dni = null;
                       }
               }while (dni ==null);


                String telefono;
                do {
                        System.out.println("Introduce tu número de teléfono: ");
                        telefono = altaCliente.nextLine();
                        if (!telefono.matches("\\d{9}")){
                                System.out.println("El número de teléfono debe contener 9 dígitos");
                                telefono = null;
                        }
                }while (telefono == null);

                System.out.println("Introduce tu email: ");
                String email = altaCliente.nextLine();


                System.out.println("-----DATOS DE CLIENTE-----:");
                System.out.println("Nombre: " + nombre);
                System.out.println("DNI: " + dni);
                System.out.println("Teléfono: " + telefono);
                System.out.println("E-mail: " + email);

                boolean confirmar = pedirConfirmacion(altaCliente, "Los datos són correctos?");

                if (confirmar){
                Cliente nuevo = new Cliente(nombre, dni, telefono, email);
                main.clientes.add(nuevo);
                System.out.println("¡Cliente dado de alta satisfactoriamente!");
                return nuevo;}
                else {
                        System.out.println("Introduce los datos de nuevo");
                        return null;
                }

        }

        public String buscarNombre() {return nombre;}
        public String buscarDNI() {return dni;}
        public String buscarTelefono() {
                return telefono;
        }
        public String buscarEmail() {
                return email;
        }
        public void guardarNombre(String nombre) {
                this.nombre = nombre;
        }
        public void guardarDNI(String dni) {
                this.dni = dni;
        }
        public void guardarTelefono(String telefono) {
                this.telefono = telefono;
        }
        public void guardarEmail(String email) {
                this.email = email;
        }


        public static void bajaCliente(){
                Scanner scanner = new Scanner(System.in);

                System.out.println("Introduce el dni del cliente que deseas eliminar: ");

                String eliminarCliente = scanner.nextLine().trim();

                boolean encontrado = false;
                for (Cliente c: main.clientes){
                        if (c.buscarDNI().equalsIgnoreCase(eliminarCliente)) {
                                encontrado = true;
                                System.out.println("¡Cliente encontrado!"+
                                        "\nNombre: " + c.buscarNombre() +
                                        "\nDNI: " + c.buscarDNI() +
                                        "\nTeléfono: " + c.buscarTelefono() +
                                        "\nE-mail: " + c.buscarEmail());

                                boolean confirmar = pedirConfirmacion(scanner,"¿Deseas eliminar este cliente?");

                                if (confirmar) {
                                        main.clientes.remove(c);
                                        System.out.println("¡Cliente dado de baja satisfactoriamente!");
                                } else {
                                        System.out.println("Se ha cancelado el proceso de eliminación");
                                }
                                break;
                        }
                }
                if (!encontrado){
                        System.out.println("No se encontró ningún cliente con ese nombre");
                }
                scanner.close();
        }

        public static void modificarCliente(){
                Scanner scanner = new Scanner(System.in);

                System.out.println("Introduce el dni del cliente que deseas modificar: ");

                String clienteModificar = scanner.nextLine().toLowerCase();

                boolean encontrado = false;
                for (Cliente c: main.clientes){
                        if (c.buscarDNI().equalsIgnoreCase(clienteModificar)) {
                                encontrado = true;
                                System.out.println("¡Cliente encontrado!"+
                                        "\nNombre: " + c.buscarNombre() +
                                        "\nDNI: " + c.buscarDNI() +
                                        "\nTeléfono: " + c.buscarTelefono() +
                                        "\nE-mail: " + c.buscarEmail());

                                boolean confirmar = pedirConfirmacion(scanner, "Deseas modificar este cliente?");

                                if (!confirmar){
                                        System.out.println("cancelando el proceso de modificación..");
                                        break;
                                }

                                int registro = 0;

                                do {
                                        System.out.println("¿Qué registro deseas modificar? Indica la opción.");
                                        System.out.println("1. Nombre");
                                        System.out.println("2. DNI");
                                        System.out.println("3. Teléfono");
                                        System.out.println("4. e-mail");
                                        System.out.println("5. Salir del proceso");

                                        try {
                                                registro = scanner.nextInt();
                                                scanner.nextLine();

                                                if (registro < 1 || registro >5){
                                                        System.out.println("El menú de opciones es de 1 a 5");
                                                        registro = 0;
                                                        continue;
                                                }

                                        }catch (InputMismatchException e){
                                                System.out.println("Debes introducir un número entero.");
                                                registro = 0;
                                                scanner.nextLine();
                                                continue;
                                        }

                                        switch (registro){
                                                case 1 -> {
                                                        System.out.println("Introduce el nuevo nombre:");
                                                        String nuevoNombre = scanner.nextLine();
                                                        if (nuevoNombre.isEmpty()){
                                                                System.out.println("El nombre no puede estar vacío");
                                                        }else {
                                                                if (pedirConfirmacion(scanner, "Es correcto: " + nuevoNombre + "?")) {
                                                                        c.guardarNombre(nuevoNombre);
                                                                        System.out.println("Nombre actualizado correctamente.");
                                                                } else {
                                                                        System.out.println("Cambio de nombre cancelado.");
                                                                }
                                                        }
                                                }
                                                case 2 -> {
                                                        String nuevoDni;

                                                        System.out.println("Introduce el nuevo DNI (8 dígitos + letra):");
                                                        nuevoDni = scanner.nextLine().trim();
                                                        if (!nuevoDni.matches("\\d{8}[A-Z]")) {
                                                                System.out.println("Formato DNI inválido.");
                                                                nuevoDni = null;
                                                        } else if (buscarClientePorDNI(nuevoDni) != null && !nuevoDni.equalsIgnoreCase(c.buscarDNI())) {
                                                                System.out.println("Ya existe un cliente con ese DNI.");
                                                                nuevoDni = null;
                                                        } else {
                                                                if (pedirConfirmacion(scanner, "Es correcto: " + nuevoDni + "?")) {
                                                                        c.guardarDNI(nuevoDni);
                                                                        System.out.println("DNI actualizado correctamente.");
                                                                } else {
                                                                        System.out.println("Cambio de DNI cancelado.");
                                                                }
                                                        }
                                                }
                                                case 3 -> {
                                                        String nuevoTelefono;

                                                        System.out.println("Introduce el nuevo número de teléfono (9 dígitos):");
                                                        nuevoTelefono = scanner.nextLine().trim();
                                                        if (nuevoTelefono.isEmpty()){
                                                                System.out.println("El teléfono no puede estar vacío");
                                                        }else if (!nuevoTelefono.matches("\\d{9}")) {
                                                                System.out.println("Número de teléfono inválido.");
                                                                        nuevoTelefono = null;
                                                        }else {
                                                                if (pedirConfirmacion(scanner, "Es correcto: " + nuevoTelefono + "?")) {
                                                                        c.guardarTelefono(nuevoTelefono);
                                                                        System.out.println("Teléfono actualizado correctamente.");
                                                                } else {
                                                                        System.out.println("Cambio de teléfono cancelado.");
                                                                }
                                                        }
                                                }

                                                case 4 -> {
                                                        System.out.println("Introduce el nuevo email:");
                                                        String nuevoEmail = scanner.nextLine();
                                                        if (nuevoEmail.isEmpty()) {
                                                                System.out.println("El e-mail no puede estar vacío");
                                                        } else {
                                                                if (pedirConfirmacion(scanner, "Es correcto: " + nuevoEmail + "?")) {
                                                                        c.guardarEmail(nuevoEmail);
                                                                        System.out.println("Email actualizado correctamente.");
                                                                } else {
                                                                        System.out.println("Cambio cancelado");
                                                                }
                                                        }
                                                }
                                                case 5 -> System.out.println("Has salido del proceso de modificación");

                                        }
                                } while (registro !=5);

                                break;
                        }
                }
                if (!encontrado){
                        System.out.println("No se encontró ningún cliente con ese dni");
                }
                scanner.close();
        }


        public static void buscarPorDNI() {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Introduce el DNI de la persona que quieres buscar: ");
                String DNIaBuscar = scanner.nextLine();

                boolean encontrado = false;

                for (Cliente c : main.clientes) {
                        if (c.buscarDNI().equalsIgnoreCase(DNIaBuscar)) {
                                System.out.println("¡Cliente encontrado!" +
                                        "\nNombre: " + c.buscarNombre() +
                                        "\nDNI: " + c.buscarDNI() +
                                        "\nTeléfono: " + c.buscarTelefono() +
                                        "\nE-mail: " + c.buscarEmail());
                                encontrado = true;
                                break;
                        }
                }

                if (!encontrado) {
                        System.out.println("Cliente no encontrado");
                }
                scanner.close();
        }

        public static void mostrarTodosLosClientes() {

                if (main.clientes.isEmpty()) {
                        System.out.println("No hay clientes registrados.");
                        return;
                }

                System.out.println("Listado de todos los clientes:\n");

                for (Cliente c : main.clientes) {
                        System.out.println("Nombre: " + c.buscarNombre());
                        System.out.println("DNI: " + c.buscarDNI());
                        System.out.println("Teléfono: " + c.buscarTelefono());
                        System.out.println("Email: " + c.buscarEmail());
                        System.out.println("------------------------------");
                }
        }

        public static Cliente buscarClientePorDNI(String dni) {
                for (Cliente c : main.clientes) {
                        if (c.buscarDNI().equalsIgnoreCase(dni)) {
                                return c;
                        }
                }
                return null;
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
