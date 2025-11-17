package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Autor:Ion Madan.Le esta pidiendo al usuario que introduzca por consola
        Scanner sc = new Scanner(System.in);
        UserManager manager = new UserManager();
        int Option = 0;


        do { //Autor:Ion Madan.Un bucle con do donde se repetirá este código hasta que la persona introduzca un 0
            System.out.println("");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Listar usuarios");
            System.out.println("0. Salir");
            System.out.print("Elegir: ");

            //Autor:Ion Madan. Convierte aquello que sea texto en numero
            try {
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
            System.out.println("");

            /*Autor:Ion Madan. Un switch donde dependiendo de la opcion que se haya itroducido
            se irá por un caso o por otro*/
            switch (Option) {
                case 1:
                    System.out.print("Nombre del usuario: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    manager.addUser(new user(name, email));
                    break;
                case 2:
                    System.out.print("Introduce el nombre de usuario: ");
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
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (Option != 0);

        sc.close();
    }
}
