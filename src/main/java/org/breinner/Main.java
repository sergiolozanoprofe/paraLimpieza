package org.breinner;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdministradorDeUsuarios manager = new AdministradorDeUsuarios();
        int Option = 0;

        do {
            System.out.println("");
            System.out.println(Constantes.T1);
            System.out.println(Constantes.T2);
            System.out.println(Constantes.T3);
            System.out.println(Constantes.SALIR);
            System.out.print(Constantes.ELEGIR);
            try {
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(Constantes.INVALID_INPUT);
            }
            System.out.println("");
            switch (Option) {
                case 1:
                    extracted(sc, manager);
                    break;
                case 2:
                    extracted1(sc, manager);

                case 3:
                    manager.listUsers();
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (Option != 0);

        sc.close();
    }

    private static void extracted1(Scanner sc, AdministradorDeUsuarios manager) {
        System.out.print("Introduce el nombre de usuario: ");
        String name2 = sc.nextLine();
        manager.findUser(name2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Usuario no encontrado.")
                );
    }

    private static void extracted(Scanner sc, AdministradorDeUsuarios manager) {
        System.out.print("Nombre del usuario: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        manager.addUser(new Usuario(name, email));
    }
}
