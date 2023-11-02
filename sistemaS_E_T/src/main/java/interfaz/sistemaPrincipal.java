package interfaz;

import java.util.Scanner;

import java.util.ArrayList;

import clasesSistema.usuario;

import clasesSistema.cliente;


 /*

 LIBRERIAS PARA LECTURA DE DATOS

  */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;



public class sistemaPrincipal {

    public static void main(String[] args){
        ArrayList<String> datos;
        ArrayList<usuario> usuarios;
        boolean validado = false;
        accederSistema();

        while (!validado) {
            datos = tomaDeDatos();
            usuarios = lecturaBD();



            if (validacion(datos, usuarios)) {
                validado = true;

                //OBTENER EL USUARIO

                usuario usuarioLoggeado =  obtenerUsuario(datos,usuarios);

                //DETERMINAR QUE TIPO DE USUARIO ES, CLIENTE O CONDUCTOR

                if(usuarioLoggeado.getTipo_de_usuario() == 'C'){

                    Scanner scanner = new Scanner(System.in);

                    System.out.println("Por favor ingrese su edad: ");

                    int edad = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Por favor ingrese el numero de tarjeta de credito: ");

                    int tarjeta = scanner.nextInt();

                    scanner.nextLine();


                    cliente cliente = new cliente(usuarioLoggeado.getNumeroCedula(),
                                                  usuarioLoggeado.getNombre(),
                                                  usuarioLoggeado.getApellido(),
                            usuarioLoggeado.getUsuario(),
                            usuarioLoggeado.getContraseña(),
                            usuarioLoggeado.getNumeroCelular(),
                            usuarioLoggeado.getTipo_de_usuario(),
                            edad,tarjeta);

                    //ESCRIBIR EL ARCHIVO CON LOS DATOS DEL CLIENTE

                    escribirSobreArchivoClientes("C:\\Users\\Diego\\Documents\\POO_espol\\sistemaS_E_T\\files\\clientes.txt"
                                                ,cliente);

                    //

                    limpiarConsola();

                    // MOSTRAR MENU

                    mostrarMenuCliente();

                    // SELECCION DEL CLIENTE

                    System.out.println("Elija su opcion: ");

                    int opcion = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println(opcion);



                }else{
                    System.out.println("EMPIEZA LA LOGICA CONDUCTOR");
                }

            }
            else {
                System.out.println("CREDENCIALES INCORRECTAS");

            }
        }


    }

    static void accederSistema(){

        int longitud = 38; // Longitud total del mensaje
        String mensaje = "BIENVENIDO AL SISTEMA";

        // Imprimir la línea superior de asteriscos
        for (int i = 0; i < longitud; i++) {
            System.out.print("*");
        }

        // Imprimir el mensaje centrado
        System.out.println();
        int espaciosAntes = (longitud - mensaje.length()) / 2;
        for (int i = 0; i < espaciosAntes; i++) {
            System.out.print(" ");
        }
        System.out.println(mensaje);

        // Imprimir la línea inferior de asteriscos
        for (int i = 0; i < longitud; i++) {
            System.out.print("*");
        }

        System.out.println();




    }   // SE IMPRIME EL LOGO DE BIENVENIDA

    static ArrayList<String> tomaDeDatos(){
        Scanner sc = new Scanner(System.in);

        System.out.println( "USUARIO: ");
        String usuario = sc.nextLine();
        System.out.println( "CONTRASEÑA: ");
        String contraseña = sc.nextLine();

        ArrayList<String> datos = new ArrayList<>();

        datos.add(usuario);

        datos.add(contraseña);

        return  datos;

    } // SE OBTIENE EL USUARIO Y CONTRASEÑA INGRESADO POR CONSOLA

    static ArrayList<usuario> lecturaBD(){
        String nombreArchivo = "C:\\Users\\Diego\\Documents\\POO_espol\\sistemaS_E_T\\files\\usuarios.txt";

        ArrayList<usuario> usuarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    long cedula = Long.parseLong(datos[0]);
                    long celular = Long.parseLong(datos[5]);
                    char tipoUsuario = datos[6].charAt(0); // Tomamos el primer carácter

                    // Crear un objeto usuario y agregarlo a la lista
                    usuario usuario = new usuario(cedula, datos[1], datos[2], datos[3], datos[4], celular, tipoUsuario);
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usuarios;
    }  // SE CREA UN ARREGLO DE LOS USUARIOS CON LA BASE DE DATOS DE LOS USUARIOS DADA

    static Boolean validacion(ArrayList<String> datosLogin, ArrayList<usuario> usuariosBD){
        String usuario = datosLogin.get(0);
        String contraseña = datosLogin.get(1);

        for(usuario usuarioDB: usuariosBD){
            if (usuario.equals(usuarioDB.getUsuario()) && contraseña.equals(usuarioDB.getContraseña())) {
                return true;
            }
        }

        return false;
        }

    static usuario obtenerUsuario(ArrayList<String> tomaDeDatos, ArrayList<usuario> usuarios){
        String usuario = tomaDeDatos.get(0);
        String contraseña = tomaDeDatos.get(1);

        for(usuario usuarioBD: usuarios){
            if (usuario.equals(usuarioBD.getUsuario()) && contraseña.equals(usuarioBD.getContraseña())) {
                return usuarioBD;
            }
        }

        return null;
    }

    static void escribirSobreArchivoClientes(String ruta, cliente cliente){
        try (FileWriter fileWriter = new FileWriter(ruta);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            String linea = cliente.getNumeroCedula() + "," + cliente.getEdad() + "," + cliente.getNumeroTarjetaCredito();
            writer.write(linea);
            writer.newLine();

            System.out.println("Información del cliente escrita en el archivo.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void mostrarMenuCliente(){
        System.out.println("/*******************MENU*********************/");
        System.out.println("/*                                            */");
        System.out.println("/**********************************************/");
        System.out.println("1.  Solicitar taxi");
        System.out.println("2.  Solicitar comida a domicilio");
        System.out.println("3.  Solicitar entrega de encomienda");
        System.out.println("4.  Consultar servicios");

    }

//    static int seleccionMenuCliente(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Elija una opcion: ");
//
//        String seleccion = sc.nextLine();
//
//        return 3;
//    }

    static void limpiarConsola(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}


