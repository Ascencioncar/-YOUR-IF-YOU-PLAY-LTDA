import java.util.Scanner;

public class munecosBebe {
    private int id;
    private String nombre;
    private int nArticulaciones;
    private int precioU;
    private String tipoR;

    public void ingresarDatos(Scanner scanner) {
        System.out.println("Ingrese el ID:");
        this.id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre:");
        this.nombre = scanner.nextLine();
        System.out.println("Ingrese el número de articulaciones:");
        this.nArticulaciones = scanner.nextInt();
        System.out.println("Ingrese el precio:");
        this.precioU = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el tipo de ropa:");
        this.tipoR = scanner.nextLine();
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getnArticulaciones() { return nArticulaciones; }
    public int getPrecioU() { return precioU; }
    public String getTipoR() { return tipoR; }
}
