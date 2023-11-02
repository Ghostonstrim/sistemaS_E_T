package clasesSistema;

public class usuario {
    private long numeroCedula;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;
    private long numeroCelular;
    private char tipo_de_usuario;


    /*
    CONTRUCTORES DE LA CLASE USUARIO
     */

    public usuario(long numeroCedula, String nombre, String apellido, String usuario,
                   String contraseña, long numeroCelular, char tipo_de_usuario) {
        this.numeroCedula = numeroCedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.numeroCelular = numeroCelular;
        this.tipo_de_usuario = tipo_de_usuario;
    }

    public usuario() {
        // Constructor por defecto sin argumentos
    }
    /*

    METODOS GETTERS

     */

    public long getNumeroCedula() {
        return numeroCedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public long getNumeroCelular() {
        return numeroCelular;
    }

    public char getTipo_de_usuario() {
        return tipo_de_usuario;
    }

    /*

    METODOS SETTERS

     */


    public void setNumeroCedula(long numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNumeroCelular(long numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public void setTipo_de_usuario(char tipo_de_usuario) {
        this.tipo_de_usuario = tipo_de_usuario;
    }

    @Override
    public String toString() {
        return "cedula: " + getNumeroCedula() + " nombre: " + getNombre() + " apellido: " +
                getApellido() + " usuario: " + getUsuario() + " contraseña: " + getContraseña() +
                " tipo_usuario: " + getTipo_de_usuario() + "\n";
    }
}
