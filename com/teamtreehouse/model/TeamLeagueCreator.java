package com.teamtreehouse.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class TeamLeagueCreator {

    private BufferedReader mReader;
    private List<Player> mPlayers;
    private Map<String, String> mMenu;
    private List<Team> mTeams;


    public TeamLeagueCreator(Player [] players) {
        mPlayers = Arrays.asList(players);
        mReader  = new BufferedReader(new InputStreamReader(System.in));
        mTeams = new ArrayList<>();
        mMenu = new HashMap<>();


        mMenu.put("1", "Create New Team");
        mMenu.put("2", "Add Player to a Team");
        mMenu.put("3", "Remove Player From a Team");
        mMenu.put("4", "Team Roster");
        mMenu.put("5", "Team By Height");
        mMenu.put("6", "Team Experience Report");
        mMenu.put("7", "League Balance Report");
        mMenu.put("8", "Exit");

    }

    private String promptAction() throws IOException{
        System.out.printf("There are %d teams that can be created for this league.  %d team(s) has been created.%n",
                (mPlayers.size() / Team.MAX_MEMBERS), (mTeams.size()));
        for (Map.Entry<String, String> option : mMenu.entrySet()) {
            System.out.printf("%s - %s %n", option.getKey(), option.getValue());
        }
        System.out.print("Make a selection: ");
        String choice = mReader.readLine();
        return choice.trim().toLowerCase();
    }

    public void run() {
        String input = "";
        Team team;

        do {
            try {
                input = promptAction();
                switch (input) {
                    case "1":
                        //create new team
                        if (checkAvailableTeams(mPlayers) || isTeamAvailable() ){
                            team = promptNewTeam();
                            if (mTeams.contains(team.getName())){
                                System.out.println("This team already exists.");
                            } else {
                                mTeams.add(team);
                                System.out.printf("%s team added.%n", team.getName());
                            }
                        } else {
                            System.out.println("There is no more room for a new team. ");
                        }

                        break;
                    case "2":
                        //Add player to team
                        team = promptTeamChoice();
                        Player player = promptPlayerChoice(team);
                        if (isTeamAvailable()) {
                            System.out.println("There are no teams created yet.  Please add a team first.");
                        }else {
                            if (team.getPlayerCount() <= team.MAX_MEMBERS){
                                team.addPlayers(player);
                            } else {
                                System.out.println("Team full.");
                                mPlayers.add(player);
                            }

                        }
                        break;
                    case "3":
                        //Remove Player from team
                        team = promptTeamChoice();
                        if (team.getPlayers() == null){
                            System.out.println("No players added to the " + team.getName() + " team.");
                        } else {
                            mPlayers.add(promptPlayerChoice(team));
                        }
                        break;
                    case "4":
                        //Team Roster in alphabetical order
                        team = promptTeamChoice();
                        team.getPlayers();
                        break;
                    case "5":
                        //Team report sorted by height
//                        team = getTeamSelection();
//                        team.displayTeamByHeight();
                        break;
                    case "6":
                        //Experience report by team
                        //team = promptTeamChoice();
                        //team.displayExperience();
                        break;
                    case "7":
                        //League Balance report by team
//                        leagueBalance();
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

    private Team promptNewTeam() throws IOException{
        System.out.print("What is the name of the new team: ");
        String name =  mReader.readLine().trim();
        System.out.print("Who is the coach:  ");
        String coach = mReader.readLine();
        return new Team(name, coach);
    }

    private int promptForIndex(List<String> options) throws IOException{
        int counter = 1;
        for (String option : options ) {
            System.out.printf("%d - %s %n", counter, option);
            counter++;
        }
        String optionString = mReader.readLine();
        int choice = Integer.parseInt(optionString.trim());
        System.out.print("Your Selection:   ");
        return choice -1;
    }

    private Team promptTeamChoice() throws IOException{
        System.out.println("Available Teams:  ");
        List<String> teams = new ArrayList<>();
        for (Team team : mTeams) {
            teams.add(team.getName());
        }


        int choice = promptForIndex(teams);
        return mTeams.get(choice);

    }

    private boolean checkAvailableTeams(List<Player> players){
        System.out.println((mTeams.size() <= (players.size() / Team.MAX_MEMBERS)));
        return (mTeams.size() < (players.size() / Team.MAX_MEMBERS));
    }

    private Player promptPlayerChoice(Team team) throws IOException{
        System.out.println("Available Players:  ");
        List<String> playerNames = new ArrayList<>(team.getPlayers());
        for (Player player : mPlayers) {
            playerNames.add(player.getLastName() + ", " + player.getFirstName());
        }

        System.out.print("Select a player:   ");
        int choice = promptForIndex(playerNames);
        return mPlayers.get(choice);
    }

//    private Team getTeamSelection() throws IOException{
//        return mTeams.get(promptTeamChoice(mTeams));
//    }

//    private Player getPlayerSelection(List<Player> players) throws IOException {
//        return players.remove(promptPlayerChoice(players));
//    }

    private boolean isTeamAvailable() {
        return (mTeams == null || mTeams.size() == 0);
    }

//    private void leagueBalance() {
//        for (Team team : mTeams){
//            System.out.println("---------------------------------");
//            System.out.println("Team name: " + team.getName() + "    Coach: " + team.getCoach());
//            System.out.println("---------------------------------");
//            System.out.printf("Experienced Team members  :  %d%n", team.experienceTally());
//            System.out.printf("Inexperienced Team members:  %d%n",
//                    (team.getTeamMembers().size() - team.experienceTally()));
//            float percent = ( ((float) team.experienceTally() / (float) team.getTeamMembers().size()) * 100);
//            System.out.println("Experience %       :  " + percent + "%" );
//        }
}
