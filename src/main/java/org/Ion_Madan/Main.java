package org.Ion_Madan;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario_Jefe manager = new Usuario_Jefe();
        int Option = 0;

        do {
            System.out.println("");
            System.out.println(Constantes.AÑADIR_USUARIO);
            System.out.println(Constantes.BUSCAR_USUARIO);
            System.out.println(Constantes.LISTAR_USUARIOS);
            System.out.println(Constantes.SALIR);
            System.out.print(Constantes.ELEGIR);
            try {
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(Constantes.INVALID_INPUT + ".");
            }
            System.out.println("");
            switch (Option) {
                case 1:
                    Lista_caso_1(sc, manager);
                    break;
                case 2:
                    Lista_caso_2(sc, manager);
                    break;

                case 3:
                    manager.listUsers();
                    break;
                case 0:
                    System.out.println(Constantes.BYE);
                    break;
                default:
                    System.out.println(Constantes.INVALID_OPTION);
            }

        } while (Option != 0);

        sc.close();
    }

    private static void Lista_caso_2(Scanner sc, Usuario_Jefe manager) {
        System.out.print(Constantes.NOMBRE_DE_USUARIO);
        String name2 = sc.nextLine();
        manager.findUser(name2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(Constantes.USUARIO_NO_ENCONTRADO)
                );
    }

    private static void Lista_caso_1(Scanner sc, Usuario_Jefe manager) {
        System.out.print(Constantes.NOMBRE_DEL_USUARIO);
        String name = sc.nextLine();
        System.out.print(Constantes.EMAIL);
        String email = sc.nextLine();
        manager.addUser(new usuario(name, email));
    }



}
