package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorUsuarios manager = new GestorUsuarios();
        int Option = 0;

        do {
            System.out.println("");
            System.out.println(Constantes.MENU_OPCION_1);
            System.out.println(Constantes.MENU_OPCION_2);
            System.out.println(Constantes.MENU_OPCION_3);
            System.out.println(Constantes.MENU_OPCION_0);
            System.out.print(Constantes.MENU_ELEGIR);
            try {
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(Constantes.ERROR_INPUT);
            }
            System.out.println("");
            switch (Option) {
                case 1:
                    System.out.print(Constantes.PEDIR_NOMBRE);
                    String name = sc.nextLine();
                    System.out.print(Constantes.PEDIR_EMAIL);
                    String email = sc.nextLine();
                    manager.addUser(new Usuario(name, email));
                    break;
                case 2:
                    System.out.print(Constantes.PEDIR_BUSCAR);
                    String name2 = sc.nextLine();
                    manager.findUser(name2)
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println(Constantes.USUARIO_NO_ENCONTRADO)
                            );
                    break;
                case 3:
                    manager.listUsers();
                    break;
                case 0:
                    System.out.println(Constantes.DESPEDIDA);
                    break;
                default:
                    System.out.println(Constantes.OPCION_INVALIDA);
            }

        } while (Option != 0);

        sc.close();
    }
}
