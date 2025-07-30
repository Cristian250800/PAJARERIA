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

        public static void bajaCliente(){
                Scanner scanner = new Scanner(System.in);

                System.out.println("Introduce el nombre del cliente que deseas eliminar: ");

                String eliminarCliente = scanner.nextLine().toLowerCase();

                boolean encontrado = false;
                for (Cliente c: main.clientes){
                        if (c.buscarNombre().toLowerCase().equals(eliminarCliente)) {
                                encontrado = true;
                                System.out.println("Cliente encontrado"+
                                        "\nNombre: " + c.buscarNombre() +
                                        "\nDNI: " + c.buscarDNI() +
                                        "\nTeléfono: " + c.buscarTelefono() +
                                        "\nE-mail: " + c.buscarEmail());

                                System.out.println("¿Deseas eliminar este cliente? (true/false):");
                                boolean confirmar = scanner.nextBoolean();
                                scanner.nextLine();


                                if (confirmar) {
                                        main.clientes.remove(c);
                                        System.out.println("Cliente eliminado con éxito");
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
}
