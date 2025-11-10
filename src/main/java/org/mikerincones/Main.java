package org.mikerincones;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorUsuarios gestor = new GestorUsuarios();
        int opcion = 0;

        do {
            System.out.println(Constantes.ESPACIOINIC);
            System.out.println(Constantes.ANADIR_USUARIO);
            System.out.println(Constantes.BUSCAR_USUARIO);
            System.out.println(Constantes.LISTAR_USUARIOS);
            System.out.println(Constantes.SALIR);
            System.out.print(Constantes.ELEGIR);
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(Constantes.INVALID_INPUT);
            }
            System.out.println(Constantes.ESPACIO);
            switch (opcion) {
                case 1:
                    AnadirUsuario(sc, gestor);
                    break;
                case 2:
                    BuscarUsuario(sc, gestor);
                    break;

                case 3:
                    gestor.listUsers();
                    break;
                case 0:
                    System.out.println(Constantes.BYE);
                    break;
                default:
                    System.out.println(Constantes.INVALID_OPTION);
            }

        } while (opcion != 0);

        sc.close();
    }

    private static void BuscarUsuario(Scanner sc, GestorUsuarios gestor) {
        System.out.print(Constantes.INTRODUCE_EL_NOMBRE_DE_USUARIO);
        String nombre2 = sc.nextLine();
        gestor.findUser(nombre2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(Constantes.USUARIO_NO_ENCONTRADO)
                );
    }

    private static void AnadirUsuario(Scanner sc, GestorUsuarios gestor) {
        System.out.print(Constantes.NOMBRE_DEL_USUARIO);
        String nombre = sc.nextLine();
        System.out.print(Constantes.EMAIL);
        String email = sc.nextLine();
        gestor.addUser(new usuario(nombre, email));
    }
}
