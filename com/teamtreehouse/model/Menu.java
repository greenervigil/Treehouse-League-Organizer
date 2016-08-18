package com.teamtreehouse.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by danielvigil on 8/17/16.
 */
public class Menu {

    private static BufferedReader mReader = new BufferedReader(new InputStreamReader(System.in));;

    //Main menu
    public static void menu() throws IOException {
        System.out.println("####################################");
        System.out.println("############### Menu ###############");
        System.out.println("####################################\n");
        System.out.println("Select the menu number:  ");
        System.out.println("1 - Organizer");
        System.out.println("2 - Coach");
        System.out.println("3 - Exit");
        System.out.print("Selection:   ");

        int input = Integer.parseInt(mReader.readLine());
        if (input == 1){
            System.out.print("\033[H\033[2J");
            organizerMenu();
        } else if (input == 2){
            System.out.print("\033[H\033[2J");
            coachMenu();
        } else if (input == 3) {
            System.exit(0);
        } else {
            System.out.println("That is an incorrect menu item.  Try again.");
            System.out.print("\033[H\033[2J");
            menu();
        }

    }

    public static void coachMenu() throws IOException {
        System.out.println("####################################");
        System.out.println("############## Coach ###############");
        System.out.println("####################################\n");
        System.out.println("Select the menu number:  ");
        System.out.println("1 - Organizer");
        System.out.println("2 - Coach");
        System.out.println("3 - Exit");
        System.out.print("Selection:   ");
    }

    public static void organizerMenu() throws IOException {
        System.out.println("####################################");
        System.out.println("############ Organizer #############");
        System.out.println("####################################\n");
        System.out.println("Select the menu number:  ");
        System.out.println("1 - Organizer");
        System.out.println("2 - Coach");
        System.out.println("3 - Exit");
        System.out.print("Selection:   ");
    }

}
