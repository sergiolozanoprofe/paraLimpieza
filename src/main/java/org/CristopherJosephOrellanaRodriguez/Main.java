package org.CristopherJosephOrellanaRodriguez;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorUsuario gestor = new GestorUsuario();
        int Opcion = 0;

        do {
            System.out.println("");
            System.out.println(constantes.ANADIR_USUARIO);
            System.out.println(constantes.BUSCAR_USUARIO);
            System.out.println(constantes.LISTAR_USUARIOS);
            System.out.println(constantes.SALIR);
            System.out.print(constantes.ELEGIR);
            try {
                Opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(constantes.INVALID_INPUT);
            }
            System.out.println("");
            switch (Opcion) {
                case 1:
                    ANadirUsuario(sc, gestor);
                    break;
                case 2:
                    BuscarUsuario(sc, gestor);
                    break;

                case 3:
                    gestor.listUsers();
                    break;
                case 0:
                    System.out.println(constantes.BYE);
                    break;
                default:
                    System.out.println(constantes.INVALID_OPTION);
            }

        } while (Opcion != 0);

        sc.close();
    }

    private static void BuscarUsuario(Scanner sc, GestorUsuario gestor) {
        System.out.print(constantes.INTRODUCE_EL_NOMBRE_DE_USUARIO + " ");
        String name2 = sc.nextLine();
        gestor.findUser(name2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(constantes.USUARIO_NO_ENCONTRADO)
                );
    }

    private static void ANadirUsuario(Scanner sc, GestorUsuario gestor) {
        System.out.print(constantes.NOMBRE_DEL_USUARIO);
        String name = sc.nextLine();
        System.out.print(constantes.EMAIL);
        String email = sc.nextLine();
        gestor.addUser(new usuario(name, email));
    }
}
