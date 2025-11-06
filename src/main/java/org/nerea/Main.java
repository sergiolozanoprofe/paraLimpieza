package org.nerea;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdministratorUsurious manager = new AdministratorUsurious();
        int opcion = 0;

        do {
            System.out.println(" ");
            System.out.println(Constantes.OPCION_1);
            System.out.println(Constantes.OPCION_2);
            System.out.println(Constantes.OPCION_3);
            System.out.println(Constantes.OPCION_0);
            System.out.print(Constantes.ELEGIR);
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(Constantes.ENTRADA_INVALIDA);
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
                case Constantes.OPCION_SALIR :
                    System.out.println(Constantes.ADIOS);
                    break;
                default:
                    System.out.println(Constantes.OPCION_INVALIDA);
            }

        } while (opcion != 0);

        sc.close();
    }

    private static void buscarUsuario(Scanner sc, AdministratorUsurious manager) {
        System.out.print(Constantes.INTRODUCE_NOMBRE);
        String nombre2 = sc.nextLine();
        manager.buscarUsuario(nombre2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(Constantes.USUARIO_NO_ENCONTRADO)
                );
    }

    private static void aniadirUsuario(Scanner sc, AdministratorUsurious manager) {
        System.out.print(Constantes.NOMBRE_USUARIO);
        String nombre = sc.nextLine();
        System.out.print(Constantes.EMAIL);
        String correoElectronico = sc.nextLine();
        manager.aniadirUsuario(new Usuario(nombre, correoElectronico));
    }
}
