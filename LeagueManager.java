import com.teamtreehouse.model.Menu;
import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;

import java.io.IOException;

import static com.teamtreehouse.model.Menu.menu;

public class LeagueManager {

  public static void main(String[] args) {
    Player[] players = Players.load();
    System.out.printf("There are currently %d registered players.%n", players.length);
    // Your code here!


        Menu menu = new Menu();
      try {
          menu();
      } catch (IOException e) {
          e.printStackTrace();
      }


  }

}
