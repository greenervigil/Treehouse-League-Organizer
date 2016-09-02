package com.teamtreehouse.model;

import java.util.*;

public class Team {

    private String name;
    private String coach;
    private List<Player> mPlayers;
    public static final int MAX_MEMBERS = 11;

    public Team(String name, String coach) {
        this.name = name;
        this.coach = coach;
        mPlayers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCoach() {
        return coach;
    }

    public void addPlayers(Player player) {
        mPlayers.add(player);
    }

    public int getPlayerCount() {
        return mPlayers.size();
    }

    private Map<String, List<Player>> byPlayer() {
        Map<String, List<Player>> byPlayer = new HashMap<>();
        for(Player player : mPlayers) {
            List<Player> players = byPlayer.get(player.getLastName());
            if (players == null ){
                players = new ArrayList<>();
                byPlayer.put(player.getLastName(), players);
            }
            players.add(player);
        }
        return byPlayer;
    }

    public Set<String> getPlayers() {
        return byPlayer().keySet();
    }

//    public int experienceTally () {
//        int count = 0;
//        for (Player player : mTeamMembers) {
//            if(player.isPreviousExperience()) {
//                count++;
//            }
//        }
//        return count;
//    }



    @Override
    public String toString() {
        return String.format("%s team coached by %s%n", getName(), getCoach());
    }
}
