import java.util.Scanner;

public class CalculadoraDescuentos {
    public static void main(String[] args) {
        boolean salir = false;
        do {
            int opcion = mostrarMenu();
            if (opcion == 1) {
                ejecutarCompra();
            } else {
                salir = true;
            }
        } while (!salir);
    
        System.out.println("Saliendo del sistema.");
    }

    static int mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Calculadora de Descuentos - Tienda Online");
        System.out.println("[1] Realizar Nueva Compra");
        System.out.println("[2] Salir");
        System.out.print("Opcion: ");
        return sc.nextInt();
    }

    static void ejecutarCompra() {
        String[] nombres = new String[10];
        double[] precios = new double[10];
        int[] cantidades = new int[10];

        int n = leerCarrito(nombres, precios, cantidades);
        if (n == 0) {
            System.out.println("Carrito vacio.");
            return;
        }
        
        static int leerCarrito(String[] nombres, double[] precios, int[] cantidades) {
            Scanner sc = new Scanner(System.in);
            int n = 0;
        
            System.out.println("Carrito de Compra");
            while (n < nombres.length) {
                System.out.print("Nombre del producto (o 'fin' para terminar): ");
                String nombre = sc.nextLine();
                if (nombre.equalsIgnoreCase("fin")) break;
        
                nombres[n] = nombre;
        
                System.out.print("Precio de '" + nombre + "': ");
                precios[n] = sc.nextDouble();
        
                System.out.print("Cantidad de '" + nombre + "': ");
                cantidades[n] = sc.nextInt();
                sc.nextLine();
        
                n++;
            }
            return n;
        }
        
