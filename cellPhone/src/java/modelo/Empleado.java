
package modelo;


public class Empleado extends Usuario{
    
    private int id;
    private String nombre;
    private String apellido;
    private String dni;

    public Empleado() {
    }

  

    public Empleado(int id, String nombre, String apellido, String dni, String user, String password) {
        super(user, password);
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
    
    
}
