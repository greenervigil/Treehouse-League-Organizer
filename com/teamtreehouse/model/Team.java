package com.teamtreehouse.model;

import java.util.*;


public class Team {

    private String name;
    private String coach;
    private List<Player> mTeamMembers;
    public static final int MAX_MEMBERS = 11;

    public Team(String name, String coach) {
        this.name = name;
        this.coach = coach;
        mTeamMembers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCoach() {
        return coach;
    }

    public List<Player> getTeamMembers() {
        return mTeamMembers;
    }

    public void addPlayer(Player player) {
        if (mTeamMembers.size() < MAX_MEMBERS) {
            mTeamMembers.add(player);
        } else {
            System.out.println("Team is full.  ");
        }
    }

    public int experienceTally () {
        int count = 0;
        for (Player player : mTeamMembers) {
            if(player.isPreviousExperience()) {
                count++;
            }
        }
        return count;
    }

    //REPORTING
    private void header() {
        System.out.println("---------------------------------");
        System.out.println("Team name: " + getName() + "  Coach: " + getCoach());
        System.out.println("---------------------------------");
    }

    public void displayTeam() {
        header();
        System.out.printf("%-10s %10s  %s  %s%n", "Last", "First", "Ht", "Exp");
        for (Player player : mTeamMembers) {
            System.out.printf("%-10s %10s  %s  %s%n", player.getLastName(),
                    player.getFirstName(), player.getHeightInInches(),
                    player.isPreviousExperience());
        }
    }

    public void displayTeamByHeight() {
        Map<Integer, Integer> heights = new HashMap<>();
        header();
        System.out.println("Height(In):       Player(s)  ");
        for (Player player : mTeamMembers) {
            Integer count = heights.get(player.getHeightInInches());
            if (count == null) {
                count = 0;
            }
            count++;
            heights.put(player.getHeightInInches(), count);
        }
        for (Map.Entry<Integer, Integer> option : heights.entrySet()) {
            System.out.printf("%-20d  %d %n", option.getKey(), option.getValue());

        }
    }

    public void displayExperience() {
        header();


    }
}
