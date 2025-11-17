package org.JavierSoican;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionDeUsuarios manager = new GestionDeUsuarios();
        int Option = 0;
        //Pide una opción al usuario de que opción desea realizar
        do {
            System.out.println("");
            System.out.println(Constantes.AÑADIR_USUARIO);
            System.out.println(Constantes.BUSCAR_USUARIO);
            System.out.println(Constantes.LISTAR_USUARIOS);
            System.out.println(Constantes.SALIR);
            System.out.print(Constantes.ELEGIR); //Desde añadir usuario a elegir lo que hace es una salida de texto por pantalla que imprima lo que dicen los mensajes
            try {
                Option = Integer.parseInt(sc.nextLine()); //Lee la siguiente entrada de texto por teclado
            } catch (Exception e) {
                System.out.println(Constantes.INVALID_INPUT); //Imprime por pantalla que la opcion no es válida
            }
            System.out.println(""); //Imprime comillas vacías
            switch (Option) {
                case 1:
                    extracted(sc, manager);
                    break;
                case 2:
                    extracted1(sc, manager);

                case 3:
                    manager.listUsers();
                    break;
                case 0:
                    System.out.println(Constantes.BYE);//Imprime por pantalla una despedida del programa
                    break;
                default:
                    System.out.println(Constantes.INVALID_OPTION); //Imprime por pantalla que la opcion no es válida
            }

        } while (Option != 0);
    //Bucle con las opciones que puede elegir el usuario y dependiendo de que opcion registre llamará a un método u otro
        sc.close();
    }

    private static void extracted1(Scanner sc, GestionDeUsuarios manager) {
        System.out.print(Constantes.INTRODUCE_EL_NOMBRE_DE_USUARIO);
        String name2 = sc.nextLine(); //Pide por pantalla que se introduzca el nombre de usuario y lee la siguiente entrada de texto
        manager.findUser(name2)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(Constantes.USUARIO_NO_ENCONTRADO) //Manda una salida por pantalla que indica que el usuario no ha introducido un usuario que se encuentre definido
                );
    }

    private static void extracted(Scanner sc, GestionDeUsuarios manager) {
        System.out.print(Constantes.NOMBRE_DEL_USUARIO);
        String name = sc.nextLine();//Imprime una petición de nombre de usuario y lo lee en la siguiente línea
        System.out.print(Constantes.EMAIL);
        String email = sc.nextLine();//Imprime una petición de email de usuario y lo lee en la siguiente línea
        manager.addUser(new Usuario(name, email)); //Añade una instancia de usuario en manager con los atributos de nombre de usario e email
    }
}
