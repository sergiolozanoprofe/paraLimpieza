package org.JuanSebastianMoreno;

import java.util.Scanner;

/**
 * @autorJuanSebastianMoreno
 * añadir un usuario
 * buscar un usuario
 * listar un usuario
 * salir
 * elegir la opcion que quieres
 * cada opcion abre un case con mas opciones
 * nombre del usuario
 * busca un usuario y te lo enseña su email si lo encuentra
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        usuariogerente gerente = new usuariogerente();
        int opcion = 0;

        do {
            System.out.println("");
            System.out.println(constantes.AÑADIR_USUARIO);
            System.out.println(constantes.BUSCAR_USUARIO);
            System.out.println(constantes.LISTAR_USUARIOS);
            System.out.println(constantes.SALIR);
            System.out.print(constantes.ELEGIR);
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(constantes.INVALID_INPUT);
            }
            System.out.println("");
            switch (opcion) {
                case 1:
                    extracted(sc, gerente);
                    break;
                case 2:
                    extracted1(sc, gerente);
                    break;
                case 3:
                    gerente.listUsers();
                    break;
                case 0:
                    System.out.println(constantes.BYE);
                    break;
                default:
                    System.out.println(constantes.INVALID_OPTION);
            }

        } while (opcion != 0);

        sc.close();
    }

    private static void extracted1(Scanner sc, usuariogerente gerente) {
        System.out.print(constantes.INTRODUCE_EL_NOMBRE_DE_USUARIO);
        String name2 = sc.nextLine();
        gerente.findUser(name2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(constantes.USUARIO_NO_ENCONTRADO)
                );
    }

    private static void extracted(Scanner sc, usuariogerente gerente) {
        System.out.print(constantes.NOMBRE_DEL_USUARIO);
        String name = sc.nextLine();
        System.out.print(constantes.EMAIL);
        String email = sc.nextLine();
        gerente.addUser(new usuario(name, email));
    }
}
