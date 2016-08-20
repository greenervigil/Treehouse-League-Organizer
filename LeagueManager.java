import com.teamtreehouse.model.Menu;
import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.model.Team;

import java.io.IOException;

import static com.teamtreehouse.model.Menu.menu;

public class LeagueManager {

  public static void main(String[] args) {
    Player[] players = Players.load();
    System.out.printf("There are currently %d registered players.%n", players.length);
    // Your code here!
      System.out.printf("You can create %d teams.%n", (players.length / Team.MAX_MEMBERS));

        Menu menu = new Menu();
      try {
          menu(players);
      } catch (IOException e) {
          e.printStackTrace();
      }


  }

}
