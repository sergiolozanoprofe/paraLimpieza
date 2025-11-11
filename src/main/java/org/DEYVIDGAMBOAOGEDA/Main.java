package org.DEYVIDGAMBOAOGEDA;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        USUARIOGERENTE gerente = new USUARIOGERENTE();
        int Opcion = 0;

        do {
            System.out.println("");
            System.out.println(Constante.AÑADIR_USUARIO);
            System.out.println(Constante.BUSCAR_USUARIO);
            System.out.println(Constante.LISTAR_USUARIOS);
            System.out.println(Constante.SALIR);
            System.out.print(Constante.ELEGIR + " ");
            try {
                Opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(Constante.INVALID_INPUT);
            }
            System.out.println("");
            switch (Opcion) {
                case 1:
                    System.out.print(Constante.NOMBRE_DEL_USUARIO + " ");
                    String name = sc.nextLine();
                    System.out.print(Constante.EMAIL + " ");
                    String email = sc.nextLine();
                    gerente.addUser(new USUARIO(name, email));
                    break;
                case 2:
                    System.out.print(Constante.INTRODUCE_EL_NOMBRE_DE_USUARIO + " ");
                    String name2 = sc.nextLine();
                    gerente.findUser(name2)
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println(Constante.USUARIO_NO_ENCONTRADO)
                            );

                case 3:
                    gerente.listUsers();
                    break;
                case 0:
                    System.out.println(Constante.BYE);
                    break;
                default:
                    System.out.println(Constante.INVALID_OPTION);
            }

        } while (Opcion != 0);

        sc.close();
    }
}
