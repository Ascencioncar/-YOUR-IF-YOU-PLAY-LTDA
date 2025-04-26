public class Pila {
    protected int maxsize; // Cambiado a protected
    private int size;
    private Nodo top;

    public Pila(int n) {
        maxsize = n;
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public boolean isFull() {
        return size >= maxsize;
    }

    public void push(Object dato) {
        if (!isFull()) {
            size++;
            Nodo nuevoNodo = new Nodo(dato);
            nuevoNodo.setSiguiente(top);
            top = nuevoNodo;
        } else {
            System.out.println("¡Pila Llena! No se puede agregar más.");
        }
    }

    public Object pop() {
        if (!isEmpty()) {
            Object dato = top.getDato();
            top = top.getSiguiente();
            size--;
            return dato;
        } else {
            System.out.println("¡Pila Vacía! No se puede sacar.");
            return null;
        }
    }

    public Object peek() {
        if (!isEmpty()) {
            return top.getDato();
        } else {
            System.out.println("¡Pila Vacía! No hay elemento en el tope.");
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