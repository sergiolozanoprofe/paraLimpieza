package org.breinner;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdministradorDeUsuarios manager = new AdministradorDeUsuarios();
        int option = 0;

        do {
            LOGGER.info("");
            LOGGER.info(Constantes.T1);
            LOGGER.info(Constantes.T2);
            LOGGER.info(Constantes.T3);
            LOGGER.info(Constantes.SALIR);
            LOGGER.info(Constantes.ELEGIR);
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                LOGGER.severe(Constantes.INVALID_INPUT);
            }
            LOGGER.info("");
            switch (option) {
                case 1:
                    extracted(sc, manager);
                    break;
                case 2:
                    extracted1(sc, manager);
                    break;
                case 3:
                    manager.listUsers();
                    break;
                case 0:
                    LOGGER.info("Bye!");
                    break;
                default:
                    LOGGER.severe("Invalid option.");
            }

        } while (option != 0);

        sc.close();
    }


    private static void extracted1(Scanner sc, AdministradorDeUsuarios manager) {
        LOGGER.info("Introduce el nombre de usuario: ");
        String name2 = sc.nextLine();
        manager.findUser(name2)
                .ifPresentOrElse(
                        u -> LOGGER.info ("Usuario encontrado."),
                        () -> LOGGER.severe("Usuario no encontrado")
       );
    }

    private static void extracted(Scanner sc, AdministradorDeUsuarios manager) {
        LOGGER.info("Nombre del usuario: ");
        String name = sc.nextLine();
        LOGGER.info("Email: ");
        String email = sc.nextLine();
        manager.addUser(new Usuario(name, email));
    }
}
