import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static ArrayList <Cliente> clientes = new ArrayList<>();


    public static void main(String[] args) {

        //CLIENTES DE PRUEBA//
        clientes.add(new Cliente("Laura Martínez", "12345678A", "600123456", "laura.martinez@email.com"));
        clientes.add(new Cliente("Carlos Rodríguez", "87654321B", "611234567", "carlos.rg@email.com"));
        clientes.add(new Cliente("Sofía Gómez", "23456789C", "622345678", "sofia.gomez@email.com"));
        clientes.add(new Cliente("Javier Sánchez", "34567890D", "633456789", "j.sanchez@email.com"));
        clientes.add(new Cliente("Elena Ruiz", "45678901E", "644567890", "elena.ruiz@email.com"));

        Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
        System.out.println("BIENVENIDO A PICO Y PLUMA");
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

                System.out.println("Gestión de clientes");
                System.out.println("Escoge una opción para continuar: ");
                System.out.println("1. Alta de clientes");
                System.out.println("2. Baja de clientes");
                System.out.println("3. Modificación de clinetes");
                System.out.println("4. Búsqueda por DNI");
                System.out.println("5. Listado de clientes");

                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion){
                    case 1 ->{
                        Cliente.altaNuevoCliente();
                        System.out.println("¡Cliente dado de alta satisfactoriamente!");
                    }
                    case 2 ->{
                        Cliente.bajaCliente();

                    }
                    case 3 ->{}
                    case 4 ->{}
                    case 5 ->{}
                    default ->{
                        System.out.println("Introduce una opción válida");}

                }
            }
            case 2 ->{}
            case 3 ->{}
            case 4 ->{}
            case 5 ->{}
            default ->{
                System.out.println("Introduce una opción válida");
            }


        }

    }while (opcion !=5 );

    }
}
