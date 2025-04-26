public class Cola {
    protected int maxsize; // Cambiado a protected
    private int size;
    private Nodo frente;
    private Nodo ultimo;

    public Cola(int n) {
        maxsize = n;
        frente = null;
        ultimo = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public boolean isFull() {
        return size >= maxsize;
    }

    public void enqueue(Object dato) {
        if (!isFull()) {
            size++;
            Nodo nuevoNodo = new Nodo(dato);
            if (isEmpty()) {
                frente = nuevoNodo;
            } else {
                ultimo.setSiguiente(nuevoNodo);
            }
            ultimo = nuevoNodo;
        } else {
            System.out.println("¡Cola Llena! No se puede encolar más.");
        }
    }

    public Object dequeue() {
        if (!isEmpty()) {
            Object dato = frente.getDato();
            frente = frente.getSiguiente();
            size--;
            if (isEmpty()) {
                ultimo = null;
            }
            return dato;
        } else {
            System.out.println("¡Cola Vacía! No se puede desencolar.");
            return null;
        }
    }

    public Object peek() {
        if (!isEmpty()) {
            return frente.getDato();
        } else {
            System.out.println("¡Cola Vacía! No hay elemento al frente.");
            return null;
        }
    }

    public int getSize() {
        return size;
    }

    public int getMaxsize() { // Método getter para maxsize
        return maxsize;
    }
}