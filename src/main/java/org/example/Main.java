package org.example;

import java.util.Scanner;

/**
 * Clase principal del programa. Gestiona el menú interactivo y permite
 * añadir, buscar y enlistar usuarios utilizando.
 * @autor [Alejandro Herrero]
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Scanner para leer el texto escrito por el usuario
         * @autor [Alejandro Herrero]
         */
        Scanner sc = new Scanner(System.in);
        /**
         * Objeto encargado de gestionar la lista de usuarios
         * @autor [Alejandro Herrero]
         */
        UserManager manager = new UserManager();
        /**
         * Variable que guarda la opción seleccionada
         * @autor [Alejandro Herrero]
         */
        int Option = 0;
        /**
         * Bucle del menú. Se repite hasta que ponga 0
         * @autor [Alejandro Herrero]
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
                 * Intenta convertir la entrada a número si no, da error.
                 * @autor [Alejandro Herrero]
                 */
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
            System.out.println("");
            /**
             * Selección de la opción del menú a ejecutar
             * @autor [Alejandro Herrero]
             */
            switch (Option) {
                case 1:
                    /**
                     * Añade nuevo usuario y su email
                     * @autor [Alejandro Herrero]
                     */
                    System.out.print("Nombre del usuario: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    manager.addUser(new user(name, email));
                    break;
                case 2:
                    /**
                     * Busca un usuario por su nombre
                     * @autor [Alejandro Herrero]
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
                     * Muestra los usuarios almacenados
                     * @autor [Alejandro Herrero]
                     */
                    manager.listUsers();
                    break;
                case 0:
                    /**
                     * Sale del menú
                     * @autor [Alejandro Herrero]
                     */
                    System.out.println("Bye!");
                    break;
                default:
                    /**
                     * En caso de opción no válida
                     * @autor [Alejandro Herrero]
                     */
                    System.out.println("Invalid option.");
            }

        } while (Option != 0);

        sc.close();
    }
}
