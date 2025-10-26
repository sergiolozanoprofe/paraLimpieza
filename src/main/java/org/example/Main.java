package org.example;

import java.util.Scanner;

/**
 * Gestor de usuarios
 * @author Sergio Lozano
 */
public class Main {
    public static void main(String[] args) {
        UserManager manager = new UserManager();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n=== Gestión de Usuarios ===");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Listar usuarios");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> {
                    System.out.print("Nombre de usuario: ");
                    String username = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    manager.addUser(new User(username, email));
                    System.out.println("Usuario añadido correctamente.");
                }
                case 2 -> {
                    System.out.print("Introduce el nombre de usuario: ");
                    String name = scanner.nextLine();
                    manager.findUser(name)
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println("Usuario no encontrado.")
                            );
                }
                case 3 -> manager.listUsers();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (option != 0);
    }
}
