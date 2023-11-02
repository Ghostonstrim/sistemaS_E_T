package clasesSistema;

public class cliente extends usuario{
    private int edad;
    private long numeroTarjetaCredito;

    public cliente(long numeroCedula, String nombre, String apellido, String usuario, String contraseña, long numeroCelular, char tipo_de_usuario) {
        super(numeroCedula, nombre, apellido, usuario, contraseña, numeroCelular, tipo_de_usuario);
        this.edad = 0;
        this.numeroTarjetaCredito = 0;
    }

    public cliente(long numeroCedula, String nombre, String apellido, String usuario, String contraseña, long numeroCelular, char tipo_de_usuario,int edad, int tarjetaCredito) {
        super(numeroCedula, nombre, apellido, usuario, contraseña, numeroCelular, tipo_de_usuario);
        this.edad = edad;
        this.numeroTarjetaCredito = tarjetaCredito;
    }

    //GETTERS
    public int getEdad() {
        return edad;
    }

    public long getNumeroTarjetaCredito() {
        return numeroTarjetaCredito;
    }


    //SETTERS
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNumeroTarjetaCredito(long numeroTarjetaCredito) {
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    public void solicitarTaxi(){

    }

    public void comidaADomicilio(){

    }

    public void entregaEncomiendas(){

    }

    public void consultarServicios(){

    }

    @Override
    public String toString() {
        return "cedula: " + getNumeroCedula() + " nombre: " + getNombre() + " apellido: " +
                getApellido() + " usuario: " + getUsuario() + " contraseña: " + getContraseña() +
                " tipo_usuario: " + getTipo_de_usuario() + " edad: " + getEdad() + " tarjetaCredito: " + getNumeroTarjetaCredito() + "\n";
    }
}
