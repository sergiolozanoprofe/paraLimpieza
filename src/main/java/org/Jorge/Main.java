package org.Jorge;

kage org.example;

import java.util.Scanner;
/** nombre de la persona */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorUsuarios gestor = new GestorUsuarios();
        int Option = 0;
/** el do es un bucle*/
        do {
            System.out.println();
            System.out.println(Constantes.Anadir);
            System.out.println(Constantes.Buscar);
            System.out.println(Constantes.Listar);
            System.out.println(Constantes.Salir);
            System.out.print(Constantes.Elegir);
            try {
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
            System.out.println();
            /** esto es otro bucle pero de switchcase*/
            switch (Option) {
                case 1:
                    procesarOpcion1(sc, gestor);
                    break;
                case 2:
                    procesarOpcion2(sc, gestor);

                case 3:
                    gestor.listarUsuarios();
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

    private static void procesarOpcion2(Scanner sc, GestorUsuarios gestor) {
        System.out.print("Introduce el nombre de usuario: ");
        String name2 = sc.nextLine();
        gestor.buscarUsuario(name2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Usuario no encontrado.")
                );
    }

    private static void procesarOpcion1(Scanner sc, GestorUsuarios gestor) {
        System.out.print("Nombre del usuario: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        gestor.agregarUsuario(new Usuario(name, email));
    }
}
