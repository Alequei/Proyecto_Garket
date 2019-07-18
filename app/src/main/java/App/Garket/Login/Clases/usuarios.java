package App.Garket.Login.Clases;

public abstract class usuarios {


    private String apellido;
    private String nombre;
    private int clave_ingreso;
    private String contraseña;
    private int usuario;
    private int id;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getClave_ingreso() {
        return clave_ingreso;
    }

    public void setClave_ingreso(int clave_ingreso) {
        this.clave_ingreso = clave_ingreso;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
