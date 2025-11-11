package org.tpineda;

import java.util.Scanner;

public class Main {static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        UsuarioGestor manager = new UsuarioGestor();
        int Option = 0;

        do {
            procesarOpcion3("");
            procesarOpcion3("1. Añadir usuario");
            procesarOpcion3("2. Buscar usuario");
            procesarOpcion3("3. Listar usuarios");
            procesarOpcion3("0. Salir");
            procesarOpcion2("Elegir: ");
            try {
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                procesarOpcion3("Invalid input.");
            }
            procesarOpcion3("");
            switch (Option) {
                case 1:
                    String name = procesarOpcion1(sc);
                    String email = sc.nextLine();
                    manager.addUser(new usuario(name, email));
                    break;
                case 2:
                    procesarOpcion2("Introduce el nombre de usuario: ");
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
                    procesarOpcion3("Bye!");
                    break;
                default:
                    procesarOpcion3("Invalid option.");
            }

        } while (Option != 0);

        sc.close();
    }

    private static void procesarOpcion2(String s) {
        System.out.print(s);
    }

    private static void procesarOpcion3(String x) {
        System.out.println(x);
    }

    private static String procesarOpcion1(Scanner sc) {
        procesarOpcion2("Nombre del usuario: ");
        String name = sc.nextLine();
        procesarOpcion2("Email: ");
        return name;
    }
    }
