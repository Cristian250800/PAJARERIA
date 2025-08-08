import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static ArrayList <Cliente> clientes = new ArrayList<>();
    static ArrayList <Pajaro> pajaros = new ArrayList<>();
    static ArrayList <Venta> ventas = new ArrayList<>();


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
            case 1 -> Cliente.menuCliente();
            case 2 -> Pajaro.menuPajaro();
            case 3 -> Venta.menuVentas();
            case 4 -> {}
            case 5 ->{
                System.out.println("Has salido del programa.");
            }
            default ->
                System.out.println("Introduce una opción válida");



        }

    }while (opcion !=5 );

    }
}
