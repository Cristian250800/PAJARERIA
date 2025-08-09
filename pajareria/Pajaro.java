import java.util.InputMismatchException;
import java.util.Scanner;

public class Pajaro {

    private String especie;
    private String color;
    private double precio;


    public static void menuPajaro(){
        int opcionPajaro =0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("---------------------------------");
            System.out.println("   GESTIÓN DE PÁJAROS");
            System.out.println("1. Alta de pájaros");
            System.out.println("2. Catálogo de pájaros");
            System.out.println("3. Búsqueda por especie");
            System.out.println("4. Volver al menú principal");


            try {
                opcionPajaro = scanner.nextInt();
                scanner.nextLine();
                if (opcionPajaro < 1 || opcionPajaro > 4) {
                    System.out.println("El menú de opciones es de 1 a 4.");
                    opcionPajaro = 0;
                }
            }catch (InputMismatchException e){
                System.out.println("El menú de opciones es del 1 al 4.");
                opcionPajaro = 0;
                scanner.nextLine();

            }
            switch (opcionPajaro) {
                case 1 -> altaNuevoPajaro();
                case 2 -> mostrarCatalogo();
                case 3 -> buscarPorEspecie();
                case 4 -> System.out.println("Volviendo al menú principal");
            }
        }while (opcionPajaro != 4);
        scanner.close();
    }


    public Pajaro(String especie, String color, double precio) {
        this.especie = especie;
        this.color = color;
        this.precio = precio;
    }
    public String buscarEspecie (){
        return especie;
    }
    public String buscarColor(){
        return color;
    }
    public double buscarPrecio() {
        return precio;
    }


    public static Pajaro altaNuevoPajaro() {

        Scanner altaPajaro = new Scanner(System.in);

        String especie;
        do {
            System.out.println("Introduce el nombre de la especie: ");
            especie = altaPajaro.nextLine();
            if (especie.isEmpty()) {
                System.out.println("La especie no puede estar vacía.");
            }
        } while (especie.isEmpty());

        String color;
        do {
            System.out.println("Introduce el color: ");
            color = altaPajaro.nextLine();
            if (color.isEmpty()) {
                System.out.println("El color no puede estar vacío.");
            }
        } while (color.isEmpty());

        double precio = 0;
        boolean precioValido = false;
        do {
            System.out.println("Introduce el precio: ");
            if (altaPajaro.hasNextDouble()) {
                precio = altaPajaro.nextDouble();
                if (precio <= 0) {
                    System.out.println("El precio debe ser mayor que cero.");
                    altaPajaro.nextLine();
                } else {
                    precioValido = true;
                    altaPajaro.nextLine();
                }
            } else {
                System.out.println("Por favor, introduce un número válido para el precio.");
                altaPajaro.nextLine();
            }
        } while (!precioValido);

        Pajaro nuevo = new Pajaro(especie, color, precio);
        main.pajaros.add(nuevo);

        System.out.println("Pájaro registrado correctamente!");
        altaPajaro.close();

        return nuevo;
    }



    public static void mostrarCatalogo(){
        if (main.pajaros.isEmpty()) {
            System.out.println("No hay registros dados de alta");
            return;
        }

        System.out.println("-----CATÁLOGO DE PÁJAROS-----");
        for (Pajaro p : main.pajaros){
            System.out.println("Especie: " + p.buscarEspecie() +
                    ", Color: " + p.buscarColor()+
                    ", Precio: " + p.buscarPrecio() + "€");
        }
    }

    public static void buscarPorEspecie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce la especie del pájaro que quieres buscar: ");
        String EspecieBuscar = scanner.nextLine();

        boolean encontrado = false;

        for (Pajaro p : main.pajaros) {
            if (p.buscarEspecie().equalsIgnoreCase(EspecieBuscar)) {
                System.out.println("¡Pájaro encontrado!" +
                        "\nEspecie: " + p.buscarEspecie() +
                        "\nColor: " + p.buscarColor() +
                        "\nPrecio: " + p.buscarPrecio());

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Pájaro no encontrado");
        }
    scanner.close();
    }


}
