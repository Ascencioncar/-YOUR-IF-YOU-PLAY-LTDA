import java.util.Scanner;

public class munecosAccion extends munecosBebe {
    private String enemigoP;

    @Override
    public void ingresarDatos(Scanner scanner) {
        super.ingresarDatos(scanner);
        System.out.println("Ingrese el enemigo principal:");
        this.enemigoP = scanner.nextLine();
    }

    public String getEnemigoP() { return enemigoP; }
}
