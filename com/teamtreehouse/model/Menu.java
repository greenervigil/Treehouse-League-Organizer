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
        Team team;
        Player player;

        do {
            try {
                input = promptAction();
                switch (input) {
                    case "1":
                        if (!isTeamAvailable() || checkAvailableTeams(mPlayers)){
                            mTeams.add(promptNewTeam());
                            System.out.println("Team added.");
                        } else {
                            System.out.println("There is no more room for a new team. ");
                        }

                        break;
                    case "2":

                        team = getTeamSelection();
                        player = getPlayerSelection();
                        if (!isTeamAvailable()) {
                            System.out.println("There are no teams created yet.  Please add a team first.");
                        }else {
                            team.addPlayer(player);
                        }
                        break;
                    case "3":

                        team = getTeamSelection();
                        player = getPlayerSelection();
                        team.removePlayer(player);
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


    private String promptAction() throws IOException{
        for (Map.Entry<String, String> option : mMenu.entrySet()) {
            System.out.printf("%s - %s %n", option.getKey(), option.getValue());
        }
        System.out.print("What do you want to do: ");
        String choice = mReader.readLine();
        return choice.trim().toLowerCase();
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

    private boolean checkAvailableTeams(Player [] players){
        return (mTeams.size() < (players.length / Team.MAX_MEMBERS));
    }

    private int promptTeamChoice(List<Team> teams) throws IOException{
        int counter = 1;
        for(Team team : teams){
            System.out.printf("%d ).  %s%n", counter, team.getName());
            counter++;
        }
        System.out.print("Select a team:  ");
        int choice = Integer.parseInt(mReader.readLine().trim());
        return choice - 1;
    }

    private int promptPlayerChoice(Player [] players) throws IOException{
        int counter =1;
        for (Player player : players) {
            System.out.printf("%d).  %s\t\t%s\t%s%n", counter, player.getLastName(),
                    player.getFirstName(), player.getHeightInInches());
            counter++;
        }
        System.out.print("Select a player:   ");
        int choice = Integer.parseInt(mReader.readLine().trim());
        return choice -1;
    }

    private Team getTeamSelection() throws IOException{
        return mTeams.get(promptTeamChoice(mTeams));
    }

    private Player getPlayerSelection() throws IOException {
        return mPlayers[promptPlayerChoice(mPlayers)];
    }

    private boolean isTeamAvailable() {
        return (mTeams == null || mTeams.size() == 0);
    }
}
