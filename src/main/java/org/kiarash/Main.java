package org.kiarash;

import java.util.Scanner;

/**
 * Clase principal que ejecuta la aplicación de gestión de usuarios.
 * Proporciona una interfaz de menú por consola para operaciones de usuario.
 *
 * @author Kiarash (autor original)
 * @author [Tu Nombre] - ¡Reemplaza con tu nombre real!
 * @version 1.0
 */
public class Main {
    /**
     * Método main - punto de entrada de la aplicación.
     * Muestra menú y procesa entrada del usuario en bucle hasta salir.
     *
     * @param args argumentos de línea de comandos (no usados)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorUsuarios gestor = new GestorUsuarios();
        int opcion = 0;

        // Bucle principal de la aplicación
        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(Constantes.ENTRADA_INVALIDA);
            }
            System.out.println(Constantes.CADENA_VACIA);
            procesarOpcion(opcion, sc, gestor);
        } while (opcion != 0);

        sc.close(); // Limpiar recursos
    }

    /**
     * Muestra las opciones del menú principal al usuario.
     */
    private static void mostrarMenu() {
        System.out.println(Constantes.CADENA_VACIA);
        System.out.println(Constantes.MENU_OPCION_1);
        System.out.println(Constantes.MENU_OPCION_2);
        System.out.println(Constantes.MENU_OPCION_3);
        System.out.println(Constantes.MENU_OPCION_0);
        System.out.print(Constantes.MENU_ELEGIR);
    }

    /**
     * Procesa la selección del menú del usuario y llama a los métodos apropiados.
     *
     * @param opcion la opción del menú seleccionada por el usuario
     * @param sc Scanner para entrada del usuario
     * @param gestor Gestor de usuarios para operaciones de negocio
     */
    private static void procesarOpcion(int opcion, Scanner sc, GestorUsuarios gestor) {
        switch (opcion) {
            case 1:
                añadirusuario(sc, gestor); // Añadir nuevo usuario
                break;
            case 2:
                buscarusuario(sc, gestor); // Buscar usuario
                break;
            case 3:
                gestor.listarUsuarios(); // Listar todos los usuarios
                break;
            case 0:
                System.out.println(Constantes.DESPEDIDA); // Mensaje de salida
                break;
            default:
                System.out.println(Constantes.OPCION_NO_VALIDA); // Opción inválida
        }
    }

    /**
     * Maneja el proceso de añadir un nuevo usuario.
     * Solicita nombre de usuario y email, luego crea el usuario.
     *
     * @param sc Scanner para entrada del usuario
     * @param gestor Gestor de usuarios para añadir el usuario
     */
    private static void añadirusuario(Scanner sc, GestorUsuarios gestor) {
        System.out.print(Constantes.NOMBRE_USUARIO);
        String nombre = sc.nextLine();
        System.out.print(Constantes.CORREO_ELECTRONICO);
        String correo = sc.nextLine();
        gestor.añadirUsuario(new Usuario(nombre, correo));
    }

    /**
     * Maneja el proceso de buscar un usuario por nombre.
     * Muestra el usuario si se encuentra, o mensaje de no encontrado.
     *
     * @param sc Scanner para entrada del usuario
     * @param gestor Gestor de usuarios para buscar el usuario
     */
    private static void buscarusuario(Scanner sc, GestorUsuarios gestor) {
        System.out.print(Constantes.INTRODUCIR_NOMBRE);
        String nombre = sc.nextLine();
        gestor.buscarUsuario(nombre)
                .ifPresentOrElse(
                        System.out::println, // Imprimir usuario si se encuentra
                        () -> System.out.println(Constantes.USUARIO_NO_ENCONTRADO) // Mensaje de no encontrado
                );
    }
}