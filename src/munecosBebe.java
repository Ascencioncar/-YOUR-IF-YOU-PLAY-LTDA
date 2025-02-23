public class munecosBebe {
    private int contador = 0; // Contador de instancias
    private int id; // Código del muñeco
    private String nombre; // Nombre
    private int nArticulaciones; // Número de articulaciones
    private int PrecioU; // Precio 
    private int EdadLim; // Edad límite
    private String TipoR; // Tipo de ropa

    public munecosBebe(int id, String nombre, int nArticulaciones, int PrecioU, String TipoR) {
        this.id = id;
        this.nombre = nombre;
        this.nArticulaciones = nArticulaciones;
        this.PrecioU = PrecioU;
        this.TipoR = TipoR;
        incrementarContador(); // Incrementar el contador
    }

    private void incrementarContador() {
        contador++;
    }

    public int getContador() {
        return contador;
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
        return PrecioU;
    }

    public String getTipoR() {
        return TipoR;
    }

    public int getEdadLim() {
        return EdadLim;
    }

    public void promedioPrecio(int precio) {
        PrecioU = precio / contador;
    }
}
