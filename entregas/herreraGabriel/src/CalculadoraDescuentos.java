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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Calculadora de Descuentos - Tienda Online");
        System.out.println("[1] Realizar Nueva Compra");
        System.out.println("[2] Salir");
        System.out.print("Opcion: ");
        return scanner.nextInt();
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

        double total = calcularPrecioTotal(precios, cantidades, n);
        int cantidadTotal = calcularCantidadTotal(cantidades, n);

        Scanner sc = new Scanner(System.in);
        System.out.print("Tipo de cliente (1=Normal, 2=Estudiante, 3=Jubilado, 4=VIP): ");
        int tipo = sc.nextInt();

        System.out.print("Es temporada de rebajas? (1: Sí / 2: No): ");
        boolean rebajas = sc.nextInt() == 1;

        double precioFinal = aplicarDescuentos(total, tipo, rebajas, cantidadTotal);
        imprimirResumen(total, precioFinal, cantidadTotal);
    }

    static int leerCarrito(String[] nombres, double[] precios, int[] cantidades) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        System.out.println("Carrito de Compra");
        while (n < nombres.length) {
            System.out.print("Nombre del producto (o 'fin' para terminar): ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("fin")) break;

            nombres[n] = nombre;
            System.out.print("Precio de '" + nombre + "': ");
            precios[n] = scanner.nextDouble();

            System.out.print("Cantidad de '" + nombre + "': ");
            cantidades[n] = scanner.nextInt();
            scanner.nextLine();
            n++;
        }
        return n;
    }

    static double calcularPrecioTotal(double[] precios, int[] cantidades, int n) {
        double total = 0;
        for (int i = 0; i < n; i++) {
            total += precios[i] * cantidades[i];
        }
        return total;
    }

    static int calcularCantidadTotal(int[] cantidades, int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += cantidades[i];
        }
        return total;
    }

    static double aplicarDescuentos(double precio, int tipo, boolean rebajas, int cantidad) {
        double precio_final = precio;

        if (tipo == 1) {
            if (rebajas) precio_final *= 0.90;
            if (cantidad >= 5) precio_final *= 0.95;
        } else if (tipo == 2) {
            precio_final *= 0.85;
            if (rebajas) precio_final *= 0.90;
            if (cantidad >= 3) precio_final *= 0.92;
        } else if (tipo == 3) {
            precio_final *= 0.80;
            if (rebajas) precio_final *= 0.85;
            if (cantidad >= 2) precio_final *= 0.90;
        } else if (tipo == 4) {
            precio_final *= 0.70;
            if (rebajas) precio_final *= 0.80;
            precio_final *= 0.85;
        }

        if (precio_final > 500) precio_final -= 50;
        return precio_final;
    }

    static void imprimirResumen(double original, double finalPrecio, int cantidad) {
        System.out.println("Resumen de Compra");
        System.out.println("Precio original total: " + original + " euros");
        System.out.println("Numero total de productos: " + cantidad);
        System.out.println("Precio final con descuento: " + finalPrecio + " euros");
        System.out.println("Ahorro total: " + (original - finalPrecio) + " euros");
    }
}




