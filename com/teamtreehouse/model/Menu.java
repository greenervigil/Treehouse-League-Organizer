package com.teamtreehouse.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by danielvigil on 8/17/16.
 */
public class Menu {

    private BufferedReader mReader;
    private Player [] mPlayers;
    private Map<String, String> mMenu;
    private List<Team> mTeams;


    public Menu(Player [] players) {
        mPlayers = players;
        mTeams = new ArrayList<>();
        mReader  = new BufferedReader(new InputStreamReader(System.in));
        mMenu = new HashMap<>();

        mMenu.put("1", "Create New Team");
        mMenu.put("2", "Add Player to a Team");
        mMenu.put("3", "Remove Player From a Team");
        mMenu.put("4", "Team Roster");
        mMenu.put("5", "Team By Height");
        mMenu.put("6", "League Balance Report");
        mMenu.put("7", "Exit");

    }


    public void run() {
        String input = "";

        do {
            try {
                input = promptAction();
                switch (input) {
                    case "1":
                        System.out.println(checkAvailableTeams(mPlayers)
                        + " " + mTeams.size());
                        if (checkAvailableTeams(mPlayers)) {
                            System.out.println("There is no more room for a new team. ");
                        } else {
                            promptNewTeam();
                            System.out.println("Team added.");
                        }
                        break;
                    case "2":
                        //TODO Add a player to a team
                        break;
                    case "3":
                        //TODO Remove a player from an existing team
                        break;
                    case "4":
                        //TODO Display team roster
                        break;
                    case "5":
                        //TODO Team by height report
                        break;
                    case "6":
                        //TODO League Balance Report
                        break;
                    case "7":
                        System.out.println("Good Bye!!");
                        break;
                    default:
                        System.out.println("I do not know what that is.  try again");

                }
            } catch (IOException ioe) {
                System.out.println("Problem with input.");
                ioe.printStackTrace();
            }

        } while (!input.equals("7"));

    }


    private Team promptNewTeam() throws IOException{
        return new Team(promptForTeamName(), promptForCoachName());
    }

    private String promptForTeamName() throws IOException{
        System.out.println("What is the name of the new team: ");
        return mReader.readLine();
    }

    private String promptForCoachName() throws IOException{
        System.out.println("Who is the coach:  ");
        return mReader.readLine();
    }

    private Boolean checkAvailableTeams(Player [] players){
        if (mTeams == null || mTeams.size() == 0 ){
            return false;
        }
        return mTeams.size() <= (players.length / Team.MAX_MEMBERS);
    }

    private String promptAction() throws IOException{
        for (Map.Entry<String, String> option : mMenu.entrySet()) {
            System.out.printf("%s - %s %n", option.getKey(), option.getValue());
        }
        System.out.print("What do you want to do: ");
        String choice = mReader.readLine();
        return choice.trim().toLowerCase();
    }

}
