package tiendaproject.UnidadEjecutable;

import tiendaproject.TDA.Tienda;
import tiendaproject.TDA.CLiente;
import tiendaproject.TDA.Pedido;
import tiendaproject.JOpane;


public class UnidadEjecutableTienda {
    public static void main(String[] args) {
        boolean bandera = true;
        Tienda tienda = new Tienda();

        while (bandera) {
            String nombre = JOpane.leerString("Nombre del cliente");
            String id = JOpane.leerString("Id del cliente: ");
            CLiente cliente = new CLiente(nombre, id);

            String idPedido = JOpane.leerString("Id del pedido: ");
            Pedido pedido = new Pedido(idPedido, cliente);

            // Aquí va el resto de tu lógica
        }
    }
}
