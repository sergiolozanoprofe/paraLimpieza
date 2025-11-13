package org.nerea;

import java.util.Scanner;

/**
 *
 * Esta es la clse Main que tiene un menu con varias opciones para añadir, buscar y listar usuarios.
 * Dentro de cada case hay una llamada a los metodos que estan despues del menu.
 * @author Nerea
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdministradorUsurios manager = new AdministradorUsurios();
        int opcion = 0;

        do {
            System.out.println(" ");
            System.out.println(Constantes.OPCION_1);
            System.out.println(Constantes.OPCION_2);
            System.out.println(Constantes.OPCION_3);
            System.out.println(Constantes.OPCION_0);
            System.out.print(Constantes.ELEGIR);
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(Constantes.ENTRADA_INVALIDA);
            }
            System.out.println(" ");
            switch (opcion) {
                case 1:
                    /**
                     * esta es la llamada al metodo añadir usuario
                     */
                    aniadirUsuario(sc, manager);
                    break;
                case 2:
                    /**
                     * esta es la llamada al metodo buscar usuario
                     */
                    buscarUsuario(sc, manager);
                    break;

                case 3:
                    /**
                     * esta es la llamada al metodo listar usuario. Se crea en esta misma clase un objeto de Administrar usuarios y se le pone de nombe manager
                     * con el punto, accedemos al metodo listar usuarios que se encuentra en la clase administrador de usuarios
                     */
                    manager.listaUsuarios();
                    break;
                case Constantes.OPCION_SALIR :
                    /**
                     * aqui llamamos a contantes para salir del menu
                     */
                    System.out.println(Constantes.ADIOS);
                    break;
                default:
                    /**
                     * aqui llamamos a contantes por si se introduce una opcion invalida
                     */
                    System.out.println(Constantes.OPCION_INVALIDA);
            }

        } while (opcion != 0);

        sc.close();
    }

    /**
     * este es el metodo bucar usuario, en el se introduce el nombre y te dice si el usuario esta o no
     * @param sc
     * @param manager
     */
    private static void buscarUsuario(Scanner sc, AdministradorUsurios manager) {
        System.out.print(Constantes.INTRODUCE_NOMBRE);
        String nombre2 = sc.nextLine();
        manager.buscarUsuario(nombre2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(Constantes.USUARIO_NO_ENCONTRADO)
                );
    }

    /**
     * este es el metodo añadir usuario, se introduce el nombre, el email y se añade
     * @param sc
     * @param manager
     */
    private static void aniadirUsuario(Scanner sc, AdministradorUsurios manager) {
        System.out.print(Constantes.NOMBRE_USUARIO);
        String nombre = sc.nextLine();
        System.out.print(Constantes.EMAIL);
        String correoElectronico = sc.nextLine();
        manager.aniadirUsuario(new Usuario(nombre, correoElectronico));
    }
}
