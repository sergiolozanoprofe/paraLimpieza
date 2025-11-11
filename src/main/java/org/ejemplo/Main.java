package org.ejemplo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        gestorusuario manager = new gestorusuario();
        int Option = 0;

        do {
            System.out.println("");
            System.out.println(constantes.AÑADIR_USUARIO);
            System.out.println(constantes.BUSCAR_USUARIO);
            System.out.println(constantes.LISTAR_USUARIOS);
            System.out.println(constantes.SALIR);
            System.out.print(constantes.ELEGIR);
            try {
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(constantes.INVALID_INPUT);
            }
            System.out.println("");
            switch (Option) {
                case 1:
                    extracted(sc, manager);
                    break;
                case 2:
                    extracted1(sc, manager);
                    break;
                case 3:
                    manager.listUsers();
                    break;
                case 0:
                    System.out.println(constantes.BYE);
                    break;
                default:
                    System.out.println(constantes.INVALID_OPTION);
            }

        } while (Option != 0);

        sc.close();
    }

    private static void extracted1(Scanner sc, gestorusuario manager) {
        System.out.print(constantes.INTRODUCE_EL_NOMBRE_DE_USUARIO);
        String name2 = sc.nextLine();
        manager.findUser(name2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(constantes.USUARIO_NO_ENCONTRADO)
                );
    }

    private static void extracted(Scanner sc, gestorusuario manager) {
        System.out.print(constantes.NOMBRE_DEL_USUARIO);
        String name = sc.nextLine();
        System.out.print(constantes.EMAIL);
        String email = sc.nextLine();
        manager.addUser(new usuario(name, email));
    }
}
