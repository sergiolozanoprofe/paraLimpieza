package org.joserodriguez;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gestordeusuario manager = new Gestordeusuario();
        int Option = 0;
/**lee la opción del usuario y ejecuta la acción correspondiente hasta que elige salir
         @author JoseRodriguez */
        do {
            System.out.println(constante.MENU_LINEA_VACIA);
            System.out.println(constante.MENU_OPCION_1);
            System.out.println(constante.MENU_OPCION_2);
            System.out.println(constante.MENU_OPCION_3);
            System.out.println(constante.MENU_OPCION_0);
            System.out.print(constante.MENU_ELEGIR);

            try {
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(constante.MENSAJE_INVALID_INPUT);
            }

            System.out.println("");

            switch (Option) {
                case 1:
                    pedirnombre(sc, manager);
                    break;

                case 2:
                    gestornombres(sc, manager);
                    break;

                case 3:
                    manager.listUsers();
                    break;

                case 0:
                    System.out.println(constante.MENSAJE_BYE);
                    break;

                default:
                    System.out.println(constante.MENSAJE_INVALID_OPTION);
            }

        } while (Option != 0);

        sc.close();
    }

    private static void pedirnombre(Scanner sc, Gestordeusuario manager) {
        System.out.print(constante.PEDIR_NOMBRE);
        String name = sc.nextLine();
        System.out.print(constante.PEDIR_EMAIL);
        String email = sc.nextLine();
        manager.addUser(new usuario(name, email));
        return;
    }

    private static void gestornombres(Scanner sc, Gestordeusuario manager) {
        System.out.print(constante.PEDIR_NOMBRE_BUSQUEDA);
        String name2 = sc.nextLine();
        manager.findUser(name2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(constante.MENSAJE_NO_ENCONTRADO)
                );
        return;
    }
}