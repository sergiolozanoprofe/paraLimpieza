package org.WilmerEsau;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gestorusuario gestor = new Gestorusuario();
        int opcion = 0;

        do {
            System.out.println("");
            System.out.println(costantes.AÑADIR_USUARIO);
            System.out.println(costantes.BUSCAR_USUARIO);
            System.out.println(costantes.LISTAR_USUARIOS);
            System.out.println(costantes.SALIR);
            System.out.print(costantes.ELEGIR);
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(costantes.INVALID_INPUT);
            }
            System.out.println("");
            switch (opcion) {
                case 1:
                    System.out.print(costantes.NOMBRE_DEL_USUARIO);
                    String name = sc.nextLine();
                    System.out.print(costantes.EMAIL);
                    String email = sc.nextLine();
                    gestor.addUser(new usuario(name, email));
                    break;
                case 2:
                    System.out.print(costantes.INTRODUCE_EL_NOMBRE_DE_USUARIO);
                    String name2 = sc.nextLine();
                    gestor.findUser(name2)
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println(costantes.USUARIO_NO_ENCONTRADO)
                            );

                case 3:
                    gestor.listUsers();
                    break;
                case 0:
                    System.out.println(costantes.BYE);
                    break;
                default:
                    System.out.println(costantes.INVALID_OPTION);
            }

        } while (opcion != 0);

        sc.close();
    }
}
