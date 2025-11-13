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
            System.out.print("Elegir: ");
            try {
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
            System.out.println("");

            /**
             * Hasta aqui, se muestra un menu con un try catch
             * en caso de que el usuario escriba algo fuera de lo solicitado
             * @Author Alvaro Santos
             */

            switch (Option) {
                case 1:
                    System.out.print("Nombre del usuario: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    manager.addUser(new user(name, email));
                    break;
                /**
                 * En este caso, se pedira un nombre de usuario y un email
                 * y se guarda con un metodo en UserManager
                 * @Author Alvaro Santos
                 */
                case 2:
                    System.out.print("Introduce el nombre de usuario: ");
                    String name2 = sc.nextLine();
                    manager.findUser(name2)
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println("Usuario no encontrado.")
                            );

                    /**
                     * En el caso 2, se pide que introduzca un nombre de usuario
                     * y lo busca con un metodo usando el nombre introducido
                     * @author Alvaro Santos
                     */

                case 3:
                    manager.listUsers();

                    /**
                     * Aqui, hace un print de la lista de los usuarios ya creados
                     * @author Alvaro Santos
                     */
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                /**
                 * Un ultimo case en caso de que el usuario quiera salir
                 * @author Alvaro Santos
                 */
                default:
                    System.out.println("Invalid option.");

                    /**
                     * Y en el default se marca que cualquier otro sea una opcion invalida
                     * @author Alvaro Santos
                     */
            }

        } while (Option != 0);

        sc.close();
        /**
         * se marca la condicion del do while y se cierra el scanner
         * @author Alvaro Santos
         */
    }
}
