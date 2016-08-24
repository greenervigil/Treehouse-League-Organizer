import com.teamtreehouse.model.Menu;
import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;

import java.util.Set;
import java.util.TreeSet;


public class LeagueManager {

  public static void main(String[] args) {
    Player[] players = Players.load();
    System.out.printf("There are currently %d registered players.%n", players.length);
    // Your code here!
    Menu menu = new Menu(players);
    menu.run();
  }

}
