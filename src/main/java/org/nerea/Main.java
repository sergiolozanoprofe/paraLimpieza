package org.nerea;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Adminnistrador_Usuarios manager = new Adminnistrador_Usuarios();
        int opcion = 0;

        do {
            System.out.println(" ");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Listar usuarios");
            System.out.println("0. Salir");
            System.out.print("Elegir: ");
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
            System.out.println(" ");
            switch (opcion) {
                case 1:
                    aniadirUsuario(sc, manager);
                    break;
                case 2:
                    buscarUsuario(sc, manager);
                    break;

                case 3:
                    manager.listaUsuarios();
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (opcion != 0);

        sc.close();
    }

    private static void buscarUsuario(Scanner sc, Adminnistrador_Usuarios manager) {
        System.out.print("Introduce el nombre de usuario: ");
        String name2 = sc.nextLine();
        manager.buscarUsuario(name2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Usuario no encontrado.")
                );
    }

    private static void aniadirUsuario(Scanner sc, Adminnistrador_Usuarios manager) {
        System.out.print("Nombre del usuario: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        manager.aniadirUsuario(new Usuario(name, email));
    }
}
