package org.kiarash;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorUsuarios gestor = new GestorUsuarios();
        int opcion = 0;

        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(Constantes.ENTRADA_INVALIDA);
            }
            System.out.println(Constantes.CADENA_VACIA);
            procesarOpcion(opcion, sc, gestor);
        } while (opcion != 0);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println(Constantes.CADENA_VACIA);
        System.out.println(Constantes.MENU_OPCION_1);
        System.out.println(Constantes.MENU_OPCION_2);
        System.out.println(Constantes.MENU_OPCION_3);
        System.out.println(Constantes.MENU_OPCION_0);
        System.out.print(Constantes.MENU_ELEGIR);
    }

    private static void procesarOpcion(int opcion, Scanner sc, GestorUsuarios gestor) {
        switch (opcion) {
            case 1:
                añadirusuario(sc, gestor);
                break;
            case 2:
                buscarusuario(sc, gestor);
                break;
            case 3:
                gestor.listarUsuarios();
                break;
            case 0:
                System.out.println(Constantes.DESPEDIDA);
                break;
            default:
                System.out.println(Constantes.OPCION_NO_VALIDA);
        }
    }

    private static void añadirusuario(Scanner sc, GestorUsuarios gestor) {
        System.out.print(Constantes.NOMBRE_USUARIO);
        String nombre = sc.nextLine();
        System.out.print(Constantes.CORREO_ELECTRONICO);
        String correo = sc.nextLine();
        gestor.añadirUsuario(new usuario(nombre, correo));
    }

    private static void buscarusuario(Scanner sc, GestorUsuarios gestor) {
        System.out.print(Constantes.INTRODUCIR_NOMBRE);
        String nombre = sc.nextLine();
        gestor.buscarUsuario(nombre)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(Constantes.USUARIO_NO_ENCONTRADO)
                );
    }
}