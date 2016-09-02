package com.teamtreehouse.model;


public class TeamReports {

    public TeamReports() {

    }

    //REPORTING
    private void header(Team team) {
        System.out.println("---------------------------------");
        System.out.println("Team name: " + team.getName() + "  Coach: " + team.getCoach());
        System.out.println("---------------------------------");
    }

//    public void displayTeam() {
//        header();
//        System.out.printf("%-10s %10s  %s  %s%n", "Last", "First", "Ht", "Exp");
//        for (Player player : mTeamMembers) {
//            System.out.printf("%-10s %10s  %s  %s%n", player.getLastName(),
//                    player.getFirstName(), player.getHeightInInches(),
//                    player.isPreviousExperience());
//        }
//    }
//
//    public void displayTeamByHeight() {
//        Integer count = 1;
//        Map<Integer, Integer> heights = new HashMap<>();
//        header();
//        System.out.println("Height(In):       Player(s)  ");
//        for (Player player : mTeamMembers) {
//            Integer height = player.getHeightInInches();
//            heights.put(height, count);
//            count++;
//        }
//        for (Map.Entry<Integer, Integer> option : heights.entrySet()) {
//            System.out.printf("%-20d  %d%n", option.getKey(), option.getValue());
//            //System.out.printf(" %s %n", (option.getValue()));
//        }
//    }

    public void displayExperience() {
        //header();


    }
}
