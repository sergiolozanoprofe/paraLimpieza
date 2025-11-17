package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager manager = new UserManager();
        int Option = 0;

        do {
            System.out.println("");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Listar usuarios");
            System.out.println("0. Salir");
            System.out.print("Elegir: "); //Pide al usuario que elija una opcion
            try {
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input."); //Lee la opcion del usuario y da error si no escribe un numero
            }
            System.out.println("");
            switch (Option) { //switch case donde se ejecuta la opcion elegida
                case 1:
                    System.out.print("Nombre del usuario: "); //Pide el nombre del usuario
                    String name = sc.nextLine(); //Guarda el nombre del string
                    System.out.print("Email: "); //Pide el mail
                    String email = sc.nextLine(); //Guarda el mail
                    manager.addUser(new user(name, email)); //Termina el case 1
                    break;
                case 2:
                    System.out.print("Introduce el nombre de usuario: "); //Pide el usuario
                    String name2 = sc.nextLine(); //Guarda el nombre
                    manager.findUser(name2)
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println("Usuario no encontrado.") //Si hay usuario imprime y si no da error
                            );
                    break; //Termina el case 2
                case 3:
                    manager.listUsers(); //Muestra los usuarios
                    break; //Termina el case 3
                case 0:
                    System.out.println("Bye!");
                    break; //Muestra un mensaje y termina el menu
                default:
                    System.out.println("Invalid option."); //Si el usuario no introduce numero del 0 al 3 aparece esto
            }

        } while (Option != 0); //Repite el menu siempre que no sea 0

        sc.close();
    }
}
