import Clases.ConsultasAPI;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String mensaje = """
                ***************************************************
                Sea bienvenido/a al Conversor de Moneda =]
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción válida:
                ***************************************************""";

        buclewhile:
        while (true){
            System.out.println(mensaje);
            try {
                int respuesta = sc.nextInt();
                switch (respuesta){
                    case 1:
                        calcular("USD", "ARS");
                        break;
                    case 2:
                        calcular("ARS", "USD");
                        break;
                    case 3:
                        calcular("USD", "BRL");
                        break;
                    case 4:
                        calcular("BRL", "USD");
                        break;
                    case 5:
                        calcular("USD", "COP");
                        break;
                    case 6:
                        calcular("COP", "ARS");
                        break;
                    case 7:
                        break buclewhile;
                    default:
                        System.out.println("Ingrese una opción valida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción válida!");
                sc.next();
            }
        }
    }


    public static void calcular(String base, String target) {
        Scanner sc = new Scanner(System.in);

        double valor;
        while (true) {
            System.out.println("Ingrese el valor que deseas convertir:");
            try {
                valor = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un valor valido!");
                sc.next();
            }
        }

        ConsultasAPI consultas = new ConsultasAPI();

        double tasa = consultas.obtenerTasaCambio(base, target);

        System.out.println(String.format("El valor %.1f [%s] corresponde al valor final de =>>> %.2f [%s]", valor, base, valor*tasa, target));
    }
}
