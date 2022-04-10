
package modelo;


public class Cliente extends Usuario{
    
    private int id;
    private String nombre;
    private String apellido;

    public Cliente() {
    }


    public Cliente(int id, String nombre, String apellido, String user, String password) {
        super(user, password);
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
}
