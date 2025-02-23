public class munecosAccion extends munecosBebe {
    private String EnemigoP; // Enemigo principal
    

    public munecosAccion(int id, String nombre, int nArticulaciones, int PrecioU, String TipoR, String enemigoP) {
        super(id, nombre, nArticulaciones, PrecioU, TipoR);
        EnemigoP = enemigoP;
    }

    public String getEnemigoP() {
        return EnemigoP;
    }
}
