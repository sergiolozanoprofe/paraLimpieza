package org.alejandro;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioGestor gestor = new UsuarioGestor();
        int opcion = 0;

        do {
            System.out.println("");
            System.out.println(constantes.AÑADIR_USUARIO);
            System.out.println(constantes.BUSCAR_USUARIO);
            System.out.println(constantes.LISTAR_USUARIOS);
            System.out.println(constantes.SALIR);
            System.out.print(constantes.ELEGIR);
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(constantes.INVALID_INPUT);
            }
            System.out.println("");
            switch (opcion) {
                case 1:
                    anadirusuario(sc, gestor);
                    break;
                case 2:
                    buscarusuario(sc, gestor);
                    break;

                case 3:
                    gestor.listUsers();
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println(constantes.INVALID_OPTION);
            }

        } while (opcion != 0);

        sc.close();
    }

    private static void buscarusuario(Scanner sc, UsuarioGestor gestor) {
        System.out.print(constantes.INTRODUCE_EL_NOMBRE_DE_USUARIO);
        String nombre2 = sc.nextLine();
        gestor.findUser(nombre2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(constantes.USUARIO_NO_ENCONTRADO)
                );
    }

    private static void anadirusuario(Scanner sc, UsuarioGestor gestor) {
        System.out.print(constantes.NOMBRE_DEL_USUARIO);
        String nombre = sc.nextLine();
        System.out.print(constantes.EMAIL);
        String correo = sc.nextLine();
        gestor.addUser(new usuario(nombre, correo));
    }
}
