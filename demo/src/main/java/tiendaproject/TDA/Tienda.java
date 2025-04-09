package tiendaproject.TDA;

import java.util.ArrayList;

public class Tienda {

    private ArrayList<Producto2> listaProductos;

    public Tienda(){
        listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto2 producto){
        listaProductos.add(producto);
    }

    public ArrayList<Producto2> getListaProductos() {
        return listaProductos;
    }
}
