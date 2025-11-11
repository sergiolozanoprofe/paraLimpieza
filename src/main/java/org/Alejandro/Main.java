package org.Alejandro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioGestor gestor = new UsuarioGestor();
        int Opcion = 0;

        do {
            System.out.println("");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Listar usuarios");
            System.out.println("0. Salir");
            System.out.print("Elegir: ");
            try {
                Opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
            System.out.println("");
            switch (Opcion) {
                case 1:
                    System.out.print("Nombre del usuario: ");
                    String nombre = sc.nextLine();
                    System.out.print("Email: ");
                    String correo = sc.nextLine();
                    gestor.addUser(new usuario(nombre, correo));
                    break;
                case 2:
                    System.out.print("Introduce el nombre de usuario: ");
                    String nombre2 = sc.nextLine();
                    gestor.findUser(nombre2)
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println("Usuario no encontrado.")
                            );

                case 3:
                    gestor.listUsers();
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (Opcion != 0);

        sc.close();
    }
}
