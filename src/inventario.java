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
        return contadorBebe > 0 ? (double) precioTotalBebe / contadorBebe : 0;
    }

    public double promedioPrecioMunecosAccion() {
        return contadorAccion > 0 ? (double) precioTotalAccion / contadorAccion : 0;
    }

    public int contarMunecosMasDe12Articulaciones() {
        return articulacionesMasDe12;
    }

    public double porcentajeMunecosAccion() {
        return totalMunecos > 0 ? (double) contadorAccion * 100 / totalMunecos : 0;
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
            scanner.nextLine();

            if (opcion == 1) {
                munecosBebe muneco = new munecosBebe();
                muneco.ingresarDatos(scanner);
                inv.agregarMunecoBebe(muneco);
            } else if (opcion == 2) {
                munecosAccion muneco = new munecosAccion();
                muneco.ingresarDatos(scanner);
                inv.agregarMunecoAccion(muneco);
            } else if (opcion == 3) {
                continuar = false;
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        System.out.println("Promedio de precios de los muñecos de bebé: " + inv.promedioPrecioMunecosBebe());
        System.out.println("Promedio de precios de los muñecos de acción: " + inv.promedioPrecioMunecosAccion());
        System.out.println("Cantidad de muñecos con más de 12 articulaciones: " + inv.contarMunecosMasDe12Articulaciones());
        System.out.println("Porcentaje de muñecos de acción: " + inv.porcentajeMunecosAccion() + "%");

        scanner.close();
    }
}
