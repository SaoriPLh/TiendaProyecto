package tiendaproject.TDA;


import java.util.ArrayList;



public class CLiente {



    private String id;
    private String nombre;


    private ArrayList<Pedido> listaPedidos;


    public CLiente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        listaPedidos = new ArrayList<>();
    }


    public void agregarPedido(Pedido pedido){
        listaPedidos.add(pedido);
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }


    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    

    




    

}
