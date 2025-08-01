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


}
