package org.example;

import java.util.Scanner;

/**
 * clase principal permite añadir, buscar y listar
 *@autor [Sophia Forero]
 */
public class Main {
    public static void main(String[] args) {
        /**
         * scanner para leer el texto escrito por el usuario
         */
        Scanner sc = new Scanner(System.in);
        /**
         * variable para gestionar la lista
         */
        UserManager manager = new UserManager();
        /**
         * variable que guarda la opcion del menu
         */
        int Option = 0;

        /**
         * bucle del menu
         */
        do {
            System.out.println("");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Listar usuarios");
            System.out.println("0. Salir");
            System.out.print("Elegir: ");
            try {
                /**
                 * convierte la entrada a numero, si esta mal, da error
                 */
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
            System.out.println("");
            /**
             * selecciona la accion a ejecutar segun el menu
             */
            switch (Option) {
                case 1:
                    /**
                     * añade nuevo usuario y su email
                     */
                    System.out.print("Nombre del usuario: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    manager.addUser(new user(name, email));
                    break;
                case 2:
                    /**
                     * busca un usuario por su nombre
                     */
                    System.out.print("Introduce el nombre de usuario: ");
                    String name2 = sc.nextLine();
                    manager.findUser(name2)
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println("Usuario no encontrado.")
                            );

                case 3:
                    /**
                     * muestra todos los usuarios
                     */
                    manager.listUsers();
                    break;
                case 0:
                    /**
                     * salir del programa
                     */
                    System.out.println("Bye!");
                    break;
                default:
                    /**
                     * opcion no valida
                     */
                    System.out.println("Invalid option.");
            }

        } while (Option != 0);

        sc.close();
    }
}
