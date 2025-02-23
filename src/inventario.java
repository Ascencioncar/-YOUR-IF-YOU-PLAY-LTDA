import java.util.Scanner;

public class inventario {
    private int contadorBebe = 0;
    private int contadorAccion = 0;
    private int precioTotalBebe = 0;
    private int precioTotalAccion = 0;
    private int articulacionesMasDe12 = 0;
    private int totalMunecos = 0;

    public void agregarMunecoBebe(munecosBebe muneco) {
        contadorBebe++;
        precioTotalBebe += muneco.getPrecioU();
        if (muneco.getnArticulaciones() > 12) {
            articulacionesMasDe12++;
        }
        totalMunecos++;
    }

    public void agregarMunecoAccion(munecosAccion muneco) {
        contadorAccion++;
        precioTotalAccion += muneco.getPrecioU();
        if (muneco.getnArticulaciones() > 12) {
            articulacionesMasDe12++;
        }
        totalMunecos++;
    }

    public double promedioPrecioMunecosBebe() {
        if (contadorBebe > 0) {
            return (double) precioTotalBebe / contadorBebe;
        } else {
            return 0; // Evitar división por cero
        }
    }

    public double promedioPrecioMunecosAccion() {
        if (contadorAccion > 0) {
            return (double) precioTotalAccion / contadorAccion;
        } else {
            return 0; // Evitar división por cero
        }
    }

    public int contarMunecosMasDe12Articulaciones() {
        return articulacionesMasDe12;
    }

    public double porcentajeMunecosAccion() {
        if (totalMunecos > 0) {
            return (double) contadorAccion * 100 / totalMunecos;
        } else {
            return 0; // Evitar división por cero
        }
    }

    public static void main(String[] args) {
        inventario inv = new inventario();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione el tipo de muñeco a agregar:");
            System.out.println("1. Muñeco Bebé");
            System.out.println("2. Muñeco de Acción");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.println("Ingrese el ID:");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.println("Ingrese el nombre:");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese el número de articulaciones:");
                int nArticulaciones = scanner.nextInt();
                System.out.println("Ingrese el precio:");
                int precio = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.println("Ingrese el tipo de ropa:");
                String tipoR = scanner.nextLine();

                inv.agregarMunecoBebe(new munecosBebe(id, nombre, nArticulaciones, precio, tipoR));
            } else if (opcion == 2) {
                System.out.println("Ingrese el ID:");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.println("Ingrese el nombre:");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese el número de articulaciones:");
                int nArticulaciones = scanner.nextInt();
                System.out.println("Ingrese el precio:");
                int precio = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.println("Ingrese el tipo de ropa:");
                String tipoR = scanner.nextLine();
                System.out.println("Ingrese el enemigo principal:");
                String enemigoP = scanner.nextLine();

                inv.agregarMunecoAccion(new munecosAccion(id, nombre, nArticulaciones, precio, tipoR, enemigoP));
            } else if (opcion == 3) {
                continuar = false;
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        // Calcular y mostrar resultados
        System.out.println("Promedio de precios de los muñecos de bebé: " + inv.promedioPrecioMunecosBebe());
        System.out.println("Promedio de precios de los muñecos de acción: " + inv.promedioPrecioMunecosAccion());
        System.out.println("Cantidad de muñecos con más de 12 articulaciones: " + inv.contarMunecosMasDe12Articulaciones());
        System.out.println("Porcentaje de muñecos de acción: " + inv.porcentajeMunecosAccion() + "%");

        scanner.close();
    }
}