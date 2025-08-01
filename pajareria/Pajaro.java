import java.util.Scanner;

public class Pajaro {

    private String especie;
    private String color;
    private double precio;

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

        return new Pajaro(especie, color, precio);

    }



    public static void mostrarCatalogo(){
        System.out.println("-----CATÁLOGO DE PÁJAROS-----");
        for (Pajaro p : main.pajaros){
            System.out.println("Especie: " + p.buscarEspecie() + ", Color: " + p.buscarColor()+ ", Precio: " + p.buscarPrecio() + "€");
        }
    }

    public static void BuscarPorEspecie() {
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
