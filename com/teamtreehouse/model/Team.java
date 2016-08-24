package com.teamtreehouse.model;

import java.util.ArrayList;
import java.util.List;

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

    }

    public void removePlayer(Player player) {
        mTeamMembers.remove(player);
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
}
