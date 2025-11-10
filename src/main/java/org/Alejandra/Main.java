package org.Alejandra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorUsuarios manager = new GestorUsuarios();
        int Option = 0;

        do {
            System.out.println(Constantes.MENU_LINEA_VACIA);
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
            System.out.println(Constantes.MENU_LINEA_VACIA);
            switch (Option) {
                case 1:
                    opcionAgregarUsuario(sc, manager);
                    break;
                case 2:
                    opcionBuscarUsuario(sc, manager);
                case 3:
                    manager.listUsers();
                    break;
                case 0:
                    System.out.println(Constantes.MENSAJE_SALIR);
                    break;
                default:
                    System.out.println(Constantes.OPCION_INVALIDA);
            }

        } while (Option != 0);

        sc.close();
    }

    private static void opcionBuscarUsuario(Scanner sc, GestorUsuarios manager) {
        System.out.print(Constantes.PEDIR_NOMBRE_BUSCAR);
        String name2 = sc.nextLine();
        manager.findUser(name2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(Constantes.USUARIO_NO_ENCONTRADO)
                );
    }

    private static void opcionAgregarUsuario(Scanner sc, GestorUsuarios manager) {
        System.out.print(Constantes.PEDIR_NOMBRE);
        String name = sc.nextLine();
        System.out.print(Constantes.PEDIR_EMAIL);
        String email = sc.nextLine();
        manager.addUser(new Usuario(name, email));
        return;
    }
}
