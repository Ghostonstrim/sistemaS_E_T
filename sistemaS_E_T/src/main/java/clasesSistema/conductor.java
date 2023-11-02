package clasesSistema;

public class conductor extends usuario{
    private long numeroLicencia;
    private char estado;
    private vehiculo vehiculo;

    public conductor(long numeroCedula, String nombre, String apellido, String usuario,
                     String contraseña, long numeroCelular, char tipo_de_usuario,
                     long numeroLicencia, char estado, vehiculo vehiculo) {
        super(numeroCedula, nombre, apellido, usuario, contraseña, numeroCelular, tipo_de_usuario);
        this.numeroLicencia = numeroLicencia;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    public void consultarServiciosAsignados(){

    }

    public void datosVehiculo(){

    }


}
