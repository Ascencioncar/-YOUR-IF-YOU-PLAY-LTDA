import java.util.Scanner;

public class munecosBebe {
    private int id;
    private String nombre;
    private int nArticulaciones;
    private int precioU;
    private String tipoR;

    // Nuevo constructor que acepta todos los parámetros
    public munecosBebe(int id, String nombre, int nArticulaciones, int precioU, String tipoR) {
        this.id = id;
        this.nombre = nombre;
        this.nArticulaciones = nArticulaciones;
        this.precioU = precioU;
        this.tipoR = tipoR;
    }

    public munecosBebe() {
        // Constructor vacío por si se necesita crear instancias sin datos iniciales
    }

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

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getnArticulaciones() {
        return nArticulaciones;
    }

    public int getPrecioU() {
        return precioU;
    }

    public String getTipoR() {
        return tipoR;
    }

    @Override
    public String toString() {
        return "Muñeco Bebé{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nArticulaciones=" + nArticulaciones +
                ", precioU=" + precioU +
                ", tipoR='" + tipoR + '\'' +
                '}';
    }
}