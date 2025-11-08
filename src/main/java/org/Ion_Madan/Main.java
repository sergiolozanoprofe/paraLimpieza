package org.Ion_Madan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario_Jefe manager = new Usuario_Jefe();
        int Option = 0;

        do {
            System.out.println("");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Listar usuarios");
            System.out.println("0. Salir");
            System.out.print("Elegir: ");
            try {
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
            System.out.println("");
            switch (Option) {
                case 1:
                    System.out.print("Nombre del usuario: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    manager.addUser(new usuario(name, email));
                    break;
                case 2:
                    System.out.print("Introduce el nombre de usuario: ");
                    String name2 = sc.nextLine();
                    manager.findUser(name2)
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println("Usuario no encontrado.")
                            );

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
}
