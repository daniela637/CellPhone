
package modelo;


import java.util.List;

public class Compra {
    
    
    private int id;
    private Cliente cliente;
  

  
    private int idPago;
   
    private double monto;
    private String estado;
    
    private List<CarritoCliente>detalleCompra;
    
    public Compra() {
        
    }

    public Compra(int id, Cliente cliente, int idPago, double monto, String estado, List<CarritoCliente> detalleCompra) {
        this.id = id;
        this.cliente = cliente;
        this.idPago = idPago;
        this.monto = monto;
        this.estado = estado;
        this.detalleCompra = detalleCompra;
    }

  

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
    this.cliente = cliente;
      
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

  
   

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<CarritoCliente> getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(List<CarritoCliente> detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

   
    
    
    
   
    
    
    
    
}
