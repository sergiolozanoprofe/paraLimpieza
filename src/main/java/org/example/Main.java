package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager manager = new UserManager();
        int Option = 0;//esta variable almacena la opción del menú

        do {
            System.out.println("");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Listar usuarios");
            System.out.println("0. Salir");
            System.out.print("Elegir: ");//Aqui le pide al usuario que elija una opción
            try {
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");//Aqui lee la opción del usuario y da error si no escribe un número
            }
            System.out.println("");
            switch (Option) {//aqui ya entra en el switch case donde se ejecuta la opción elegida
                case 1:
                    System.out.print("Nombre del usuario: ");//Pide el nombre
                    String name = sc.nextLine();//Guarda el nombre en un string
                    System.out.print("Email: ");//Pide el email
                    String email = sc.nextLine();//Guarda el email
                    manager.addUser(new user(name, email));
                    break;//Termina el case 1
                case 2:
                    System.out.print("Introduce el nombre de usuario: ");//Pide el nombre
                    String name2 = sc.nextLine();//Guarda el nombre
                    manager.findUser(name2)
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println("Usuario no encontrado.")//En estas líneas si el usuario existe lo imprime y sino da error
                            );
                    break;//Termina el case 2
                case 3:
                    manager.listUsers();//Muestra los usuarios registrados
                    break;//Termina el case 3
                case 0:
                    System.out.println("Bye!");
                    break;//Muestra un mensaje y termina el menu
                default:
                    System.out.println("Invalid option.");//Si el usuario no introduce un numero del 0-3 aparece esto
            }

        } while (Option != 0);//Repite el menu siempre que la opcion no sea 0

        sc.close();
    }
}
