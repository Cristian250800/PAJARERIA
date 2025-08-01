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

        public static Cliente altaNuevoCliente() {

                Scanner altaCliente = new Scanner(System.in);

                System.out.println("Introduce tu nombre completo:");
                String nombre = altaCliente.nextLine();
                System.out.println("Introduce tu dni con letra incluida: ");
                String dni = altaCliente.nextLine();
                System.out.println("Introduce tu número de teléfono: ");
                String telefono = altaCliente.nextLine();
                System.out.println("Introduce tu email: ");
                String email = altaCliente.nextLine();
                System.out.println("¡Cliente dado de alta satisfactoriamente!");

                return new Cliente(nombre,dni, telefono,email);

        }

        public String buscarNombre() {
                return nombre;
        }
        public String buscarDNI() {
                return dni;
        }
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

                System.out.println("Introduce el nombre del cliente que deseas eliminar: ");

                String eliminarCliente = scanner.nextLine().toLowerCase();

                boolean encontrado = false;
                for (Cliente c: main.clientes){
                        if (c.buscarNombre().toLowerCase().equals(eliminarCliente)) {
                                encontrado = true;
                                System.out.println("¡Cliente encontrado!"+
                                        "\nNombre: " + c.buscarNombre() +
                                        "\nDNI: " + c.buscarDNI() +
                                        "\nTeléfono: " + c.buscarTelefono() +
                                        "\nE-mail: " + c.buscarEmail());

                                System.out.println("¿Deseas eliminar este cliente? (true/false):");
                                boolean confirmar = scanner.nextBoolean();
                                scanner.nextLine();


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



        }


        public static void modificarCliente(){
                Scanner scanner = new Scanner(System.in);

                System.out.println("Introduce el nombre del cliente que deseas modificar: ");

                String clienteModificar = scanner.nextLine().toLowerCase();

                boolean encontrado = false;
                for (Cliente c: main.clientes){
                        if (c.buscarNombre().toLowerCase().equals(clienteModificar)) {
                                encontrado = true;
                                System.out.println("¡Cliente encontrado!"+
                                        "\nNombre: " + c.buscarNombre() +
                                        "\nDNI: " + c.buscarDNI() +
                                        "\nTeléfono: " + c.buscarTelefono() +
                                        "\nE-mail: " + c.buscarEmail());

                                System.out.println("¿Deseas modificar este cliente? (true/false):");
                                boolean confirmar = scanner.nextBoolean();
                                scanner.nextLine();


                                if (confirmar) {
                                        System.out.println("¿Qué registro deseas modificar? Indica la opción.");
                                        System.out.println("1. Nombre");
                                        System.out.println("2. DNI");
                                        System.out.println("3. Teléfono");
                                        System.out.println("4. e-mail");
                                        System.out.println("5. Salir del proceso");

                                        int registro = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (registro){
                                                case 1 -> {
                                                        System.out.println("Introduce el nuevo nombre:");
                                                        String nuevoNombre = scanner.nextLine();
                                                        c.guardarNombre(nuevoNombre);
                                                        System.out.println("Nombre actualizado correctamente.");
                                                }
                                                case 2 -> {
                                                        System.out.println("Introduce el nuevo DNI:");
                                                        String nuevoDni = scanner.nextLine();
                                                        c.guardarDNI(nuevoDni);
                                                        System.out.println("DNI actualizado correctamente.");
                                                }
                                                case 3 -> {
                                                        System.out.println("Introduce el nuevo número de teléfono:");
                                                        String nuevoTelefono = scanner.nextLine();
                                                        c.guardarTelefono(nuevoTelefono);
                                                        System.out.println("Teléfono actualizado correctamente.");
                                                }
                                                case 4 -> {
                                                        System.out.println("Introduce el nuevo email:");
                                                        String nuevoEmail = scanner.nextLine();
                                                        c.guardarEmail(nuevoEmail);
                                                        System.out.println("Email actualizado correctamente.");
                                                }

                                                case 5 -> {
                                                        System.out.println("Has salido del proceso de modificación");
                                                }
                                        }
                                } else {
                                        System.out.println("Se ha cancelado el proceso de modificación");

                                }
                                break;
                        }

                }
                if (!encontrado){
                        System.out.println("No se encontró ningún cliente con ese nombre");
                }



        }


        public static void BuscarPorDNI() {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Introduce el DNI de la persona que quieres buscar: ");
                String DNIaBuscar = scanner.nextLine();

                boolean encontrado = false;

                for (Cliente c : main.clientes) {
                        if (c.buscarDNI().equals(DNIaBuscar)) {
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


}
