package com.teamtreehouse.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Menu {

    private BufferedReader mReader;
    private List<Player> mPlayers;
    private List<String> mMenu;
    private List<Team> mTeams;


    public Menu(Player [] players) {
        mPlayers = toList(players);
        mTeams = new ArrayList<>();
        mReader  = new BufferedReader(new InputStreamReader(System.in));
        mMenu = new ArrayList<>();


        mMenu.add("Create New Team");
        mMenu.add("Add Player to a Team");
        mMenu.add("Remove Player From a Team");
        mMenu.add("Team Roster");
        mMenu.add("Team By Height");
        mMenu.add("Team Experience Report");
        mMenu.add("League Balance Report");
        mMenu.add("Exit");

//        mMenu.put("1", "Create New Team");
//        mMenu.put("2", "Add Player to a Team");
//        mMenu.put("3", "Remove Player From a Team");
//        mMenu.put("4", "Team Roster");
//        mMenu.put("5", "Team By Height");
//        mMenu.put("6", "Team Experience Report");
//        mMenu.put("7", "League Balance Report");
//        mMenu.put("8", "Exit");

    }


    public void run() {
        String input = "";
        Team team;


        do {
            try {
                input = promptAction(mMenu);
                switch (input) {
                    case "1":
                        //create new team
                        if (checkAvailableTeams(mPlayers) || isTeamAvailable() ){
                            mTeams.add(promptNewTeam());
                            System.out.println("Team added.");
                        } else {
                            System.out.println("There is no more room for a new team. ");
                        }

                        break;
                    case "2":
                        //Add player to team
                        team = getTeamSelection();

                        if (isTeamAvailable()) {
                            System.out.println("There are no teams created yet.  Please add a team first.");
                        }else {
                            team.addPlayer(getPlayerSelection(mPlayers));
                        }
                        break;
                    case "3":
                        //Remove Player from team
                        team = getTeamSelection();
                        if (team.getTeamMembers() == null){
                            System.out.println("No players added to the " + team.getName() + " team.");
                        } else {
                            mPlayers.add(getPlayerSelection(team.getTeamMembers()));
                        }
                        break;
                    case "4":
                        //Team Roster in alphabetical order
                        team = getTeamSelection();
                        team.displayTeam();
                        break;
                    case "5":
                        //Team report sorted by height
                        team = getTeamSelection();
                        team.displayTeamByHeight();
                        break;
                    case "6":
                        //Experience report by team
                        team = getTeamSelection();
                        team.displayExperience();
                        break;
                    case "7":
                        //League Balance report by team
                        leagueBalance();
                        break;
                    case "8":
                        System.out.println("Good Bye!!");
                        break;
                    default:
                        System.out.println("I do not know what that is.  try again");

                }
            } catch (IOException ioe) {
                System.out.println("Problem with input.");
                ioe.printStackTrace();
            }

        } while (!input.equals("8"));

    }


    private String promptAction(List<String> list) throws IOException{
        Map<String, String> menuList = new HashMap<>();
        Integer count = 1;
        for (String s : list){
            menuList.put(count.toString(), s);
            count++;
        }
        for (Map.Entry<String, String> option : menuList.entrySet()) {
            System.out.printf("%s - %s %n", option.getKey(), option.getValue());
        }
        System.out.print("Make a selection: ");
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

    private String promptForCoachName() throws IOException {
        System.out.println("Who is the coach:  ");
        return mReader.readLine();
    }

    private int promptTeamChoice(List<Team> teams) throws IOException{
        List<String> teamNames = new ArrayList<>();
        for(Team team : teams){
            teamNames.add(team.getName());
        }
//        System.out.print("Select a team:  ");
//        int choice = Integer.parseInt(mReader.readLine().trim());
//        return choice - 1;
        return (Integer.parseInt(promptAction(teamNames) )-1);

    }

    private boolean checkAvailableTeams(List<Player> players){
        System.out.println((mTeams.size() <= (players.size() / Team.MAX_MEMBERS)));
        return (mTeams.size() < (players.size() / Team.MAX_MEMBERS));
    }

    private int promptPlayerChoice(List<Player> players) throws IOException{
        Integer counter = 1;

        for (Player player : players) {
            System.out.printf("%s  %s %s %s %s %n", counter.toString(), player.getLastName(),
                    player.getFirstName(), player.getHeightInInches(), player.isPreviousExperience());
            counter++;
        }
        System.out.print("Select a player:   ");
        int choice = Integer.parseInt(mReader.readLine().trim());
        return choice -1;
    }

    private Team getTeamSelection() throws IOException{
        return mTeams.get(promptTeamChoice(mTeams));
    }

    private Player getPlayerSelection(List<Player> players) throws IOException {
        return players.remove(promptPlayerChoice(players));
    }

    private boolean isTeamAvailable() {
        return (mTeams == null || mTeams.size() == 0);
    }

    private void leagueBalance() {
        for (Team team : mTeams){
            System.out.println("---------------------------------");
            System.out.println("Team name: " + team.getName() + "    Coach: " + team.getCoach());
            System.out.println("---------------------------------");
            System.out.printf("Experienced Team members  :  %d%n", team.experienceTally());
            System.out.printf("Inexperienced Team members:  %d%n",
                    (team.getTeamMembers().size() - team.experienceTally()));
            float percent = ( ((float) team.experienceTally() / (float) team.getTeamMembers().size()) * 100);
            System.out.println("Experience %       :  " + percent + "%" );
        }
    }

    private List<Player> toList(Player [] players) {
        List<Player> playerList = new ArrayList<>();
        Collections.addAll(playerList, players);
        return playerList;
    }
}
