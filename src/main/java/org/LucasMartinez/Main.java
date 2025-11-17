package org.LucasMartinez;
/**
 *Clase principal del programa, gestiona el menú y permite registro de usuarios
 * @author [LucasMartinezRodriguez]
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /**
         * Escaner para leer el texto escrito
         */
        Scanner sc = new Scanner(System.in);
        GestionUsuario manager = new GestionUsuario();
        int Option = 0;
        /**
         *Bucle del menú
         */
        do {
            System.out.println("");
            System.out.println(Constantes.AÑADIR_USUARIO);
            System.out.println(Constantes.BUSCAR_USUARIO);
            System.out.println(Constantes.LISTAR_USUARIOS);
            System.out.println(Constantes.SALIR);
            System.out.print(Constantes.ELEGIR);
            try {
        /**
        * Intenta convertir la entrada de un numero
        */
                Option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(Constantes.INVALID_INPUT);
            }
            System.out.println("");
        /**
        *Seleccion de la opción del menú
        */
            switch (Option) {
                case 1:
                    /**
                     *Añade usuario y su email
                     */
                    extracted(sc, manager);
                    break;
                case 2:
                    /**
                     *Busca un usuario por su nombre
                     */
                    extracted1(sc, manager);
                    break;
                case 3:
                    /**
                     *Muestra los usuarios almacenados
                     */
                    manager.listUsers();
                    break;
                case 0:
                    /**
                     *Salir del menú
                     */
                    System.out.println(Constantes.BYE);
                    break;
                default:
                    /**
                     *Opción no válida
                     */
                    System.out.println(Constantes.INVALID_OPTION);
            }

        } while (Option != 0);

        sc.close();
    }

    private static void extracted1(Scanner sc, GestionUsuario manager) {
        System.out.print(Constantes.INTRODUCE_EL_NOMBRE_DE_USUARIO);
        String name2 = sc.nextLine();
        manager.findUser(name2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(Constantes.USUARIO_NO_ENCONTRADO)
                );
    }

    private static void extracted(Scanner sc, GestionUsuario manager) {
        System.out.print(Constantes.NOMBRE_DEL_USUARIO);
        String name = sc.nextLine();
        System.out.print(Constantes.EMAIL);
        String email = sc.nextLine();
        manager.addUser(new Usuario(name, email));
    }
}
