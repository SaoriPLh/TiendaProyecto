package tiendaproject.TDA;


import java.util.ArrayList;

public class Pedido {


    private String pedido;
    private CLiente cliente;

    private ArrayList<DetallePedido> listaDeDetalles;

    private ProcesadorPago1 procesadorPago1;

    public Pedido(String pedido, CLiente cliente) {
        this.pedido = pedido;
        this.cliente = cliente;
        listaDeDetalles = new ArrayList<>();
        cliente.agregarPedido(this); //
    }

    
    public void agregarDetalle(Producto2 producto, int cantidad){
        listaDeDetalles.add(new DetallePedido(producto, cantidad));
    }

    public void procesarPago(ProcesadorPago1 procesadorPago){
        procesadorPago1 = procesadorPago;
        procesadorPago.procesarPago(this.calcularTotal());
    }


    public double calcularTotal(){

        double total = 0.0;
        String cad = "Cliente :"+cliente.getId();

        for (DetallePedido detallePedido : listaDeDetalles) {
            total+=detallePedido.calcularSubTotal();
            //cad+=total+"\n";
        }

        
        return total;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public CLiente getCliente() {
        return cliente;
    }

    public void setCliente(CLiente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<DetallePedido> getListaDeDetalles() {
        return listaDeDetalles;
    }

    public void setListaDeDetalles(ArrayList<DetallePedido> listaDeDetalles) {
        this.listaDeDetalles = listaDeDetalles;
    }

    public ProcesadorPago1 getProcesadorPago1() {
        return procesadorPago1;
    }

    public void setProcesadorPago1(ProcesadorPago1 procesadorPago1) {
        this.procesadorPago1 = procesadorPago1;
    }


    
    

}
