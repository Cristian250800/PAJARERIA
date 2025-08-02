import java.util.Scanner;

public class Pajaro {

    private String especie;
    private String color;
    private double precio;


    public static void menuPajaro(){
        int opcionPajaro;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("---------------------------------");
            System.out.println("   GESTIÓN DE PÁJAROS");
            System.out.println("1. Alta de pájaros");
            System.out.println("2. Catálogo de pájaros");
            System.out.println("3. Búsqueda por especie");
            System.out.println("4. Volver al menú principal");


            opcionPajaro = scanner.nextInt();
            scanner.nextLine();

            switch (opcionPajaro) {
                case 1 -> altaNuevoPajaro();
                case 2 -> mostrarCatalogo();
                case 3 -> buscarPorEspecie();
                case 4 -> System.out.println("Volviendo al menú principal");
                default -> System.out.println("Introduce una opción válida");
            }
        }while (opcionPajaro != 4);
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

        System.out.println("Introduce el nombre de la especie: ");
        String especie = altaPajaro.nextLine();
        System.out.println("Introduce su color: ");
        String color = altaPajaro.nextLine();
        System.out.println("Introduce el precio: ");
        double precio = altaPajaro.nextDouble();

        Pajaro nuevo = new Pajaro(especie, color, precio);
        main.pajaros.add(nuevo);

        System.out.println("Pájaro registrado correctamente!");

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
            if (p.buscarEspecie().equalsIgnoreCase(EspecieBuscar.toLowerCase())) {
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
    }


}
