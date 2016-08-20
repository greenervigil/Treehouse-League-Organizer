package com.teamtreehouse.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielvigil on 8/17/16.
 */
public class Menu {

    private static BufferedReader mReader = new BufferedReader(new InputStreamReader(System.in));;
    private static List<Team> teams = new ArrayList<>();

    //Main menu
    public static void menu(Player [] players) throws IOException {
        System.out.println("####################################");
        System.out.println("############### Menu ###############");
        System.out.println("####################################\n");
        System.out.println("------ Organizer -------");
        System.out.println("1 - Create New Team");
        System.out.println("2 - Add Player to a Team");
        System.out.println("3 - Remove Player From a Team");
        System.out.println("-------- Coach ---------");
        System.out.println("4 - Team Roster");
        System.out.println("------- Reports --------");
        System.out.println("5 - Team By Height");
        System.out.println("6 - League Balance Report");
        System.out.println("7 - Exit");
        System.out.print("\nSelection:   ");

        int input = Integer.parseInt(mReader.readLine());
        while(input != 0 ) {
            switch (input) {
                case 1:
                    createTeam(players);
                    break;
                case 2:
                    //TODO Add a player to a team
                    break;
                case 3:
                    //TODO Remove a player from an existing team
                    break;
                case 4:
                    //TODO Display team roster
                    break;
                case 5:
                    //TODO Team by height report
                    break;
                case 6:
                    //TODO League Balance Report
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("I do not know what that is.  try again");

            }
        }


    }

    public static List<Team> createTeam(Player [] players) throws IOException{
        if(teams.size() <= (players.length / Team.MAX_MEMBERS)) {
            System.out.println("What is the name of the new team: ");
            String name = mReader.readLine();
            System.out.println("Who is the coach:  ");
            String coach = mReader.readLine();
            Team team = new Team(name, coach);
            teams.add(team);
        }
        return teams;
    }



}
