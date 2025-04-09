package tiendaproject.TDA;


public class DetallePedido {


    private Producto2 producto;
    private int cantidad;

    private ProcesadorPago1 procesadorPago1;

    public DetallePedido(Producto2 producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        
    }


    public double calcularSubTotal(){
        return this.producto.getPrecio()*this.cantidad;
    }

    
}
