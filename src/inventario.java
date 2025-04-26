import javax.swing.JOptionPane;
import java.util.Scanner;

public class inventario {
    private int contadorBebe = 0;
    private int contadorAccion = 0;
    private int precioTotalBebe = 0;
    private int precioTotalAccion = 0;
    private int articulacionesMasDe12 = 0;
    private int totalMunecos = 0;

    private Pila munecosRecienAgregados = new Pila(100);
    private Cola munecosProximosAgotarse = new Cola(50);

    public void agregarMunecoBebe(munecosBebe muneco) {
        contadorBebe++;
        precioTotalBebe += muneco.getPrecioU();
        if (muneco.getnArticulaciones() > 12) {
            articulacionesMasDe12++;
        }
        totalMunecos++;
        munecosRecienAgregados.push(muneco);
        verificarAgotamiento(muneco);
    }

    public void agregarMunecoAccion(munecosAccion muneco) {
        contadorAccion++;
        precioTotalAccion += muneco.getPrecioU();
        if (muneco.getnArticulaciones() > 12) {
            articulacionesMasDe12++;
        }
        totalMunecos++;
        munecosRecienAgregados.push(muneco);
        verificarAgotamiento(muneco);
    }

    private void verificarAgotamiento(Object muneco) {
        String nombreMuneco = "";
        if (muneco instanceof munecosBebe) {
            nombreMuneco = ((munecosBebe) muneco).getNombre();
        } else if (muneco instanceof munecosAccion) {
            nombreMuneco = ((munecosAccion) muneco).getNombre();
        }

        if (totalMunecos % 5 == 0 && munecosProximosAgotarse.getSize() < munecosProximosAgotarse.getMaxsize()) {
            munecosProximosAgotarse.enqueue(nombreMuneco + " (Próximo a agotarse)");
        }
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

    public void mostrarRecienAgregados() {
        Pila pilaAux = new Pila(munecosRecienAgregados.maxsize);
        StringBuilder mensaje = new StringBuilder("Muñecos recién agregados (Pila - del más reciente al más antiguo):\n");
        if (munecosRecienAgregados.isEmpty()) {
            mensaje.append("La pila de recién agregados está vacía.");
        } else {
            while (!munecosRecienAgregados.isEmpty()) {
                Object muneco = munecosRecienAgregados.pop();
                mensaje.append("- ").append(muneco).append("\n");
                pilaAux.push(muneco);
            }
            while (!pilaAux.isEmpty()) {
                munecosRecienAgregados.push(pilaAux.pop());
            }
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Muñecos Recién Agregados", JOptionPane.INFORMATION_MESSAGE);
    }

    public Object obtenerUltimoAgregado() {
        return munecosRecienAgregados.peek();
    }

    public void mostrarProximosAgotarse() {
        Cola colaAux = new Cola(munecosProximosAgotarse.maxsize);
        StringBuilder mensaje = new StringBuilder("Muñecos próximos a agotarse (Cola - en orden de detección):\n");
        if (munecosProximosAgotarse.isEmpty()) {
            mensaje.append("La cola de próximos a agotarse está vacía.");
        } else {
            while (!munecosProximosAgotarse.isEmpty()) {
                Object muneco = munecosProximosAgotarse.dequeue();
                mensaje.append("- ").append(muneco).append("\n");
                colaAux.enqueue(muneco);
            }
            while (!colaAux.isEmpty()) {
                munecosProximosAgotarse.enqueue(colaAux.dequeue());
            }
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Muñecos Próximos a Agotarse", JOptionPane.INFORMATION_MESSAGE);
    }

    public Object obtenerPrimeroProximoAgotarse() {
        return munecosProximosAgotarse.peek();
    }

    public static void main(String[] args) {
        inventario inv = new inventario();
        boolean continuar = true;

        while (continuar) {
            String[] opciones = {"Agregar Muñeco Bebé", "Agregar Muñeco de Acción", "Mostrar Estadísticas", "Mostrar Recién Agregados (Pila)", "Mostrar Próximos a Agotarse (Cola)", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(null,
                    "Seleccione una opción:",
                    "Inventario de Muñecos",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            if (seleccion == 0) {
                // Entrada de datos para Muñeco Bebé con JOptionPane
                String idStr = JOptionPane.showInputDialog("Ingrese el ID del Muñeco Bebé:");
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del Muñeco Bebé:");
                String articulacionesStr = JOptionPane.showInputDialog("Ingrese el número de articulaciones del Muñeco Bebé:");
                String precioStr = JOptionPane.showInputDialog("Ingrese el precio del Muñeco Bebé:");
                String tipoR = JOptionPane.showInputDialog("Ingrese el tipo de ropa del Muñeco Bebé:");

                try {
                    int id = Integer.parseInt(idStr);
                    int articulaciones = Integer.parseInt(articulacionesStr);
                    int precio = Integer.parseInt(precioStr);
                    if (nombre != null && tipoR != null) {
                        inv.agregarMunecoBebe(new munecosBebe(id, nombre, articulaciones, precio, tipoR));
                        JOptionPane.showMessageDialog(null, "Muñeco Bebé agregado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error al ingresar datos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (seleccion == 1) {
                // Entrada de datos para Muñeco de Acción con JOptionPane
                String idStr = JOptionPane.showInputDialog("Ingrese el ID del Muñeco de Acción:");
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del Muñeco de Acción:");
                String articulacionesStr = JOptionPane.showInputDialog("Ingrese el número de articulaciones del Muñeco de Acción:");
                String precioStr = JOptionPane.showInputDialog("Ingrese el precio del Muñeco de Acción:");
                String enemigoP = JOptionPane.showInputDialog("Ingrese el enemigo principal del Muñeco de Acción:");

                try {
                    int id = Integer.parseInt(idStr);
                    int articulaciones = Integer.parseInt(articulacionesStr);
                    int precio = Integer.parseInt(precioStr);
                    if (nombre != null && enemigoP != null) {
                        munecosAccion munecoAccion = new munecosAccion(id, nombre, articulaciones, precio, null); // tipoR es null aquí
                        munecoAccion.setEnemigoP(enemigoP);
                        inv.agregarMunecoAccion(munecoAccion);
                        JOptionPane.showMessageDialog(null, "Muñeco de Acción agregado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error al ingresar datos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (seleccion == 2) {
                String estadisticas = "--- Estadísticas ---\n" +
                        "Promedio de precios de los muñecos de bebé: " + inv.promedioPrecioMunecosBebe() + "\n" +
                        "Promedio de precios de los muñecos de acción: " + inv.promedioPrecioMunecosAccion() + "\n" +
                        "Cantidad de muñecos con más de 12 articulaciones: " + inv.contarMunecosMasDe12Articulaciones() + "\n" +
                        "Porcentaje de muñecos de acción: " + inv.porcentajeMunecosAccion() + "%";
                JOptionPane.showMessageDialog(null, estadisticas, "Estadísticas del Inventario", JOptionPane.INFORMATION_MESSAGE);
            } else if (seleccion == 3) {
                inv.mostrarRecienAgregados();
            } else if (seleccion == 4) {
                inv.mostrarProximosAgotarse();
            } else if (seleccion == 5 || seleccion == JOptionPane.CLOSED_OPTION) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "¡Hasta luego!", "Salir", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}