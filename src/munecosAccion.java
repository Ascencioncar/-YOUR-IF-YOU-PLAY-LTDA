import java.util.Scanner;

public class munecosAccion extends munecosBebe {
    private String enemigoP;

    // Nuevo constructor que acepta los parámetros de la clase base y el enemigo principal
    public munecosAccion(int id, String nombre, int nArticulaciones, int precioU, String enemigoP) {
        super(id, nombre, nArticulaciones, precioU, null); // Llama al constructor de la clase base
        this.enemigoP = enemigoP;
    }

    public munecosAccion() {
        // Constructor vacío por si se necesita crear instancias sin datos iniciales
    }

    @Override
    public void ingresarDatos(Scanner scanner) {
        super.ingresarDatos(scanner);
        System.out.println("Ingrese el enemigo principal:");
        this.enemigoP = scanner.nextLine();
    }

    public String getEnemigoP() {
        return enemigoP;
    }

    public void setEnemigoP(String enemigoP) {
        this.enemigoP = enemigoP;
    }

    @Override
    public String toString() {
        return "Muñeco de Acción{" +
                "enemigoP='" + enemigoP + '\'' +
                "} " + super.toString();
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public int getPrecioU() {
        return super.getPrecioU();
    }

    @Override
    public int getnArticulaciones() {
        return super.getnArticulaciones();
    }
}