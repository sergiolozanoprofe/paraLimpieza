package org.Santos;

import java.util.Scanner;

public class Main {

    public static final String AÑADIR_USUARIO = "1. Añadir usuario";
    public static final String BUSCAR_USUARIO = "2. Buscar usuario";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdministradorUsuarios manager = new AdministradorUsuarios();
        int Option = 0;

        do {
            System.out.println("");
            System.out.println(Constantes.MENU_ADD_USER);
            System.out.println(Constantes.MENU_FIND_USER);
            System.out.println(Constantes.MENU_ADD_USER);
            System.out.println(Constantes.MENU_LIST_USERS);
            System.out.print(Constantes.MENU_CHOOSE);
            try {
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(Constantes.INVALID_INPUT);
            }
            System.out.println("");
            switch (Option) {
                case 1:
                    crearUsuario(sc, manager);
                    break;
                case 2:
                    System.out.print(Constantes.INPUT_SEARCH);
                    String name2 = sc.nextLine();
                    manager.findUser(name2)
                            .ifPresentOrElse(
                                    System.out::println, () -> System.out.println(Constantes.USER_NOT_FOUND)
                            );

                case 3:
                    manager.listUsers();
                    break;
                case 0:
                    System.out.println(Constantes.EXIT_MESSAGE);
                    break;
                default:
                    System.out.println(Constantes.INVALID_OPTION);
            }

        } while (Option != 0);

        sc.close();
    }

    private static void crearUsuario(Scanner sc, AdministradorUsuarios manager) {
        System.out.print(Constantes.INPUT_NAME);
        String name = sc.nextLine();
        System.out.print(Constantes.INPUT_EMAIL);
        String email = sc.nextLine();
        manager.addUser(new Usuario(name, email));
        return;
    }
}
