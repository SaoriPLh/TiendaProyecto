package tiendaproject.UnidadEjecutable;

import tiendaproject.TDA.Tienda;
import tiendaproject.TDA.CLiente;
import tiendaproject.TDA.DetallePedido;
import tiendaproject.TDA.Pedido;
import tiendaproject.TDA.ProcesadorPago1;
import tiendaproject.TDA.Producto2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import tiendaproject.JOpane;

public class UnidadEjecutableTienda {
    public static void main(String[] args) {

        Tienda tienda = new Tienda();
        ProcesadorPago1 pago = new ProcesadorPago1();
        ArrayList<CLiente> clientes = new ArrayList<>();

        boolean agregarProducto = true;
        while (agregarProducto) {
            String idProducto = JOpane.leerString("Id del chocolate:");
            String nombreProducto = JOpane.leerString("Nombre del chocolate:");
            Double precioProducto = JOpane.leerDouble("precio del chocolate:");
            Producto2 producto = new Producto2(idProducto, nombreProducto, precioProducto);

            tienda.agregarProducto(producto);

            // Preguntamos si desea añadir otro ingrediente
            int respuesta = JOptionPane.showConfirmDialog(null, " ¿añadir otro producto?", "Añadir Producto",
                    JOptionPane.YES_NO_OPTION);

            // Posible true o false aroa que cambiamos la bandera
            agregarProducto = (respuesta == JOptionPane.YES_OPTION);

        }
        StringBuilder historialClientes = new StringBuilder("historial de clientes y pedidos:\n");
        boolean bandera = true;
        while (bandera) {
            String idCliente = JOpane.leerString("Id del cliente:");

            CLiente cliente = null;

            for (CLiente c : clientes) {
                if (c.getId().equals(idCliente)) {
                    cliente = c;
                    break;
                }
            }

            if (cliente == null) {
                String nombreCliente = JOpane.leerString("Nombre del cliente:");
                cliente = new CLiente(idCliente, nombreCliente);
                clientes.add(cliente);
            }

            String idPedido = JOpane.leerString("Id del pedido:");

            Pedido pedido = new Pedido(idPedido, cliente);

            ArrayList<Producto2> productosDispnibles = tienda.getListaProductos();

            StringBuilder listaProductos = new StringBuilder();

            for (int i = 0; i < productosDispnibles.size(); i++) {
                Producto2 p = productosDispnibles.get(i);
                listaProductos.append(i).append(p.getNombre()).append("- $").append(p.getPrecio()).append("\n");

            }

            boolean bandera2 = true;

            while (bandera2) {
                JOpane.imprimeSalida(listaProductos.toString(), "");

                int indice = JOpane.leerInt("ingresa el numero del producto que deseas");
                int cantidad = JOpane.leerInt("cantidad");

                Producto2 pSeleccionado = productosDispnibles.get(indice);
                pedido.agregarDetalle(pSeleccionado, cantidad);

                // Preguntamos si desea añadir otro ingrediente
                int respuesta = JOptionPane.showConfirmDialog(null, " ¿añadir otro producto al pedido?",
                        "Añadir Producto", JOptionPane.YES_NO_OPTION);

                // Posible true o false aroa que cambiamos la bandera
                bandera2 = (respuesta == JOptionPane.YES_OPTION);

            }

            pedido.procesarPago(pago);

            int respuesta = JOptionPane.showConfirmDialog(null, " ¿añadir otro pedido?", "Añadir Producto",
                    JOptionPane.YES_NO_OPTION);

            // Posible true o false aroa que cambiamos la bandera
            bandera = (respuesta == JOptionPane.YES_OPTION);

        }

        for (CLiente c : clientes) {
            historialClientes.append("Cliente: ").append(c.getNombre()).append(" (ID: ").append(c.getId())
                    .append(")\n");
            ArrayList<Pedido> pedidos = c.getListaPedidos();

            for (Pedido p : pedidos) {
                historialClientes.append("  Pedido: ").append("\n");

                ArrayList<DetallePedido> detalles = p.getListaDeDetalles();
                for (DetallePedido d : detalles) {
                    Producto2 prod = d.getProducto();
                    historialClientes.append("    - ").append(prod.getNombre())
                            .append(" x").append(d.getCantidad())
                            .append(" = $").append(prod.getPrecio() * d.getCantidad())
                            .append("\n");
                }
                historialClientes.append("  Total: $").append(p.calcularTotal()).append("\n\n");
            }
            historialClientes.append("\n");
        }

        JOptionPane.showMessageDialog(null, historialClientes.toString());

    }
}
