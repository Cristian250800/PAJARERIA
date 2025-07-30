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
}
