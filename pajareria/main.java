import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static ArrayList <Cliente> clientes = new ArrayList<>();
    static ArrayList <Pajaro> pajaros = new ArrayList<>();



    public static void main(String[] args) {

        //CLIENTES DE PRUEBA//
        clientes.add(new Cliente("Laura Martínez", "12345678A", "600123456", "laura.martinez@email.com"));
        clientes.add(new Cliente("Carlos Rodríguez", "87654321B", "611234567", "carlos.rg@email.com"));
        clientes.add(new Cliente("Sofía Gómez", "23456789C", "622345678", "sofia.gomez@email.com"));
        clientes.add(new Cliente("Javier Sánchez", "34567890D", "633456789", "j.sanchez@email.com"));
        clientes.add(new Cliente("Elena Ruiz", "45678901E", "644567890", "elena.ruiz@email.com"));

        //PÁJAROS DE PRUEBA//
        pajaros.add(new Pajaro("Canario", "Amarillo", 15.99));
        pajaros.add(new Pajaro("Periquito", "Verde y Azul", 12.50));
        pajaros.add(new Pajaro("Cacatúa", "Blanco", 89.90));
        pajaros.add(new Pajaro("Loro Amazónico", "Verde", 150.00));
        pajaros.add(new Pajaro("Agapornis", "Rojo y Verde", 35.75));
        pajaros.add(new Pajaro("Jilguero", "Amarillo y Negro", 25.00));
        pajaros.add(new Pajaro("Diamante Mandarín", "Gris y Naranja", 18.20));
        pajaros.add(new Pajaro("Ninfa", "Gris y Amarillo", 45.30));
        pajaros.add(new Pajaro("Guacamayo", "Azul y Amarillo", 350.00));
        pajaros.add(new Pajaro("Tórtola", "Beige", 20.00));



        Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
        System.out.println("-------------------------------------");
        System.out.println("       PAJARERIA PICO Y PLUMA");
        System.out.println("1. Gestión de clientes ");
        System.out.println("2. Gestión de pájaros ");
        System.out.println("3. Realizar venta ");
        System.out.println("4. Mostrar ventas ");
        System.out.println("5. Salir");
        System.out.println("Introduce una opción para continuar: ");

        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion){
            case 1 ->{
                int opcionCliente;
                System.out.println("---------------------------------");
                System.out.println("   GESTIÓN DE CLIENTES");
                System.out.println("1. Alta de clientes");
                System.out.println("2. Baja de clientes");
                System.out.println("3. Modificación de clientes");
                System.out.println("4. Búsqueda por DNI");
                System.out.println("5. Listado de clientes");
                System.out.println("Escoge una opción para continuar: ");
                opcionCliente = scanner.nextInt();
                scanner.nextLine();

                switch (opcionCliente){
                    case 1 -> Cliente.altaNuevoCliente();
                    case 2 -> Cliente.bajaCliente();
                    case 3 -> Cliente.modificarCliente();
                    case 4 -> Cliente.BuscarPorDNI();
                    case 5 -> Cliente.mostrarTodosLosClientes();
                    default -> System.out.println("Introduce una opción válida");
                }
            }
            case 2 ->{
                int opcionPajaro;
                System.out.println("---------------------------------");
                System.out.println("   GESTIÓN DE PÁJAROS");
                System.out.println("1. Alta de pájaros");
                System.out.println("2. Catálogo de pájaros");
                System.out.println("3. Búsqueda por especie");

               opcionPajaro = scanner.nextByte();
               scanner.nextLine();

               switch (opcionPajaro){
                   case 1 -> Pajaro.altaNuevoPajaro();
                   case 2 -> Pajaro.mostrarCatalogo();
                   case 3 ->{}
                   default -> System.out.println("Introduce una opción válida");
               }



            }
            case 3 ->{}
            case 4 ->{}
            case 5 ->{}
            default ->
                System.out.println("Introduce una opción válida");



        }

    }while (opcion !=5 );

    }
}
