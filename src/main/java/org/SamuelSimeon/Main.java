package org.SamuelSimeon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioGestor manager = new UsuarioGestor();
        int Option = 0;

        do {
            System.out.println("");
            System.out.println(Constante.ANADIR_USUARIO);
            System.out.println(Constante.BUSCAR_USUARIO);
            System.out.println(Constante.LISTAR_USUARIOS);
            System.out.println(Constante.SALIR);
            System.out.print(Constante.ELEGIR);
            try {
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(Constante.INVALID_INPUT);
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
                    System.out.println(Constante.BYE);
                    break;
                default:
                    System.out.println(Constante.INVALID_OPTION);
            }

        } while (Option != 0);

        sc.close();
    }

    private static void extracted1(Scanner sc, UsuarioGestor manager) {
        System.out.print(Constante.INTRODUCE_EL_NOMBRE_DE_USUARIO);
        String name2 = sc.nextLine();
        manager.findUser(name2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(Constante.USUARIO_NO_ENCONTRADO)
                );
    }

    private static void extracted(Scanner sc, UsuarioGestor manager) {
        System.out.print(Constante.NOMBRE_DEL_USUARIO);
        String name = sc.nextLine();
        System.out.print(Constante.EMAIL);
        String email = sc.nextLine();
        manager.addUser(new usuario(name, email));
    }
}
