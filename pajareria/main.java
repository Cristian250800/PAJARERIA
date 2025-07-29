import java.util.Scanner;

public class main {



    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
        System.out.println("BIENVENIDO A PICO Y PLUMA");
        System.out.println("Introduce una opción para continuar: ");
        System.out.println("1. Gestión de clientes ");
        System.out.println("2. Gestión de pájaros ");
        System.out.println("3. Realizar venta ");
        System.out.println("4. Mostrar ventas ");
        System.out.println("5. Salir");

        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion){
            case 1 ->{}
            case 2 ->{}
            case 3 ->{}
            case 4 ->{}
            case 5 ->{}
            default ->{
                System.out.println("Introduce una opción válida");
            }


        }

    }while (opcion !=0 );

    }
}
