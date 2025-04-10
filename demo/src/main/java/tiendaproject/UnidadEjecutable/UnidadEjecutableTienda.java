package tiendaproject.UnidadEjecutable;
import tiendaproject.JOpane;
import tiendaproject.TDA.*;

import javax.swing.*;
import java.util.ArrayList;

public class UnidadEjecutableTienda {
    public static void main(String[] args) {
        // Creamos una tienda y luego productos
        Tienda tienda = new Tienda();

        Producto2 producto1 = new Producto2("1", "Chocolate", 10.0);
        tienda.agregarProducto(producto1);

        ArrayList<CLiente> listaClientes = new ArrayList<>();
        boolean agregarCliente = true;

        while (agregarCliente) {
            String id = JOpane.leerString("Ingrese el ID del cliente:");
            String nombre = JOpane.leerString("Ingrese el nombre del cliente:");

            CLiente cliente = new CLiente(id, nombre);
            listaClientes.add(cliente);

            boolean añadirPedido = true;

            while (añadirPedido) {
                String idPedido = JOpane.leerString("Ingrese el ID del pedido:");
                Pedido pedido = new Pedido(idPedido, cliente);

                String idProducto = JOpane.leerString("Ingrese el ID del producto:");

                //Esto lo podemos reemplazar por un metodo que revuelva el pedido directamente que lo busque 
                Producto2 producto = null;
  
                for (Producto2 p : tienda.getListaProductos()) {
                    if (p.getId().equals(idProducto)) {
                        producto = p;
                        break;
                    }
                }

                if (producto == null) {
                    JOpane.salidaError("Producto no encontrado", "Error");
                    continue;
                }

                int cantidad = JOpane.leerInt("Ingrese la cantidad del producto:");
                if (cantidad <= 0) {
                    JOpane.salidaError("Cantidad no válida", "Error");
                    continue;
                }
                //Composicion de DetallePedido
                pedido.agregarDetalle(producto, cantidad);

                ProcesadorPago1 procesadorPago = new ProcesadorPago1();
                pedido.procesarPago(procesadorPago);

                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro pedido?", "Agregar Pedido", JOptionPane.YES_NO_OPTION);
                añadirPedido = (respuesta == JOptionPane.YES_OPTION);
            }

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro cliente?", "Agregar Cliente", JOptionPane.YES_NO_OPTION);
            agregarCliente = (respuesta == JOptionPane.YES_OPTION);
        }

        
        StringBuilder sb = new StringBuilder();
        sb.append("Resumen de Clientes y Pedidos\n\n");

        for (CLiente cliente : listaClientes) {
            sb.append("Cliente: ").append(cliente.getNombre()).append(" (ID: ").append(cliente.getId()).append(")\n");

            for (Pedido pedido : cliente.getListaPedidos()) {
                sb.append("  Pedido ID: ").append(pedido.getPedido()).append("\n");

                for (DetallePedido detalle : pedido.getListaDeDetalles()) {
                    sb.append("    Producto: ").append(detalle.getProducto().getNombre())
                      .append(" | Cantidad: ").append(detalle.getCantidad())
                      .append(" | Subtotal: $").append(detalle.calcularSubTotal()).append("\n");
                }

                sb.append("  Total del pedido: $").append(pedido.calcularTotal()).append("\n");
            }

            sb.append("----------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Resumen de Clientes y Pedidos", JOptionPane.INFORMATION_MESSAGE);
    }

}