package com.teamtreehouse.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by danielvigil on 8/16/16.
 */
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

    public void setName(String name) {
        this.name = name;
    }

    public String getCoach() {
        return coach;
    }

    public List<Player> getTeamMembers() {
        return mTeamMembers;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public void addPlayer(Player player) {
        mTeamMembers.add(player);
    }

    public void displayTeam() {

        for (Player player : mTeamMembers) {
            System.out.printf("%s\t%s\t%s\t%s%n", player.getLastName(),
                    player.getFirstName(), player.getHeightInInches(),
                    player.isPreviousExperience());
        }
    }

    public void displayTeamByHeight() {
        Map<Integer, Integer> heights = new HashMap<>();
        for (Player player : mTeamMembers) {
            Integer count = heights.get(player.getHeightInInches());
            if (count == null) {
                count = 0;
            }
            count++;
            heights.put(player.getHeightInInches(), count);
        }
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Team name: " + getName() + "    Coach: " + getCoach());
        System.out.println("---------------------------------");
        System.out.println(heights);
    }

//    public void removePlayer(Player player) {
//        mTeamMembers.remove(player);
//    }

    public int experienceTally () {
        int count = 0;
        for (Player player : mTeamMembers) {
            if(player.isPreviousExperience()) {
                count++;
            }
        }
        return count;
    }
}
