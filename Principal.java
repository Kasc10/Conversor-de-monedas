import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        String origenMoneda = "";
        String destinoMoneda = "";
        double monto;
        int opcion = 1;

        while (opcion != 7){
            System.out.println("""
                    \n******************************************************
                    Sea Bienvenido/a al conversor de monedas =)
                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Salir
                    ******************************************************
                    
                    Elija una opción válida: """);

            opcion = lectura.nextInt();

            switch (opcion){
                case 1:
                    origenMoneda = "USD";
                    destinoMoneda = "ARS";
                    break;
                case 2:
                    origenMoneda = "ARS";
                    destinoMoneda = "USD";
                    break;
                case 3:
                    origenMoneda = "USD";
                    destinoMoneda = "BRL";
                    break;
                case 4:
                    origenMoneda = "BRL";
                    destinoMoneda = "USD";
                    break;
                case 5:
                    origenMoneda = "USD";
                    destinoMoneda = "COP";
                    break;
                case 6:
                    origenMoneda = "COP";
                    destinoMoneda = "USD";
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida");
                    break;
            }

            if (opcion >= 1 && opcion <= 6) {
                System.out.println("Ingrese el monto que desea convertir: ");
                monto = lectura.nextDouble();

                if (monto > 0){
                    try {
                        Moneda consultaConversion = consulta.buscaMoneda(origenMoneda, destinoMoneda, monto);
                        System.out.println("El valor de " + monto +
                                " [" + origenMoneda + "] equivale a " + consultaConversion.conversion_result() +
                                " [" + destinoMoneda + "]");
                    }catch (NumberFormatException e){
                        System.out.println("Error, número no encontrado: " + e.getMessage());
                    }
                } else {
                    System.out.println("Por favor, ingrese el valor que desea cambiar");
                }
            }
        }
        System.out.println("Finalizó la ejecución del programa");
    }
}
