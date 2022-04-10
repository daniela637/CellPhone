
package modelo;


public class CarritoCliente {
    
    
    private int item;
    private int idArticulo;
    private String marcas;
    private String descripcion;
    private double precioCompra;
    private int cantidad;
    private double subTodtal;

    public CarritoCliente() {
    }

    public CarritoCliente(int item, int idArticulo, String marcas, String descripcion, double precioCompra, int cantidad, double subTodtal) {
        this.item = item;
        this.idArticulo = idArticulo;
        this.marcas = marcas;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.subTodtal = subTodtal;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getMarcas() {
        return marcas;
    }

    public void setMarcas(String marcas) {
        this.marcas = marcas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTodtal() {
        return subTodtal;
    }

    public void setSubTodtal(double subTodtal) {
        this.subTodtal = subTodtal;
    }
    
    
    
}
