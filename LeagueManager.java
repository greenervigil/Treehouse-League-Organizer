import com.teamtreehouse.model.Menu;
import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.model.Team;



public class LeagueManager {

  public static void main(String[] args) {
    Player[] players = Players.load();
    System.out.printf("There are currently %d registered players.%n", players.length);
    // Your code here!
    System.out.printf("You can create %d teams.%n", (players.length / Team.MAX_MEMBERS));
    Menu menu = new Menu(players);
    menu.run();
  }

}
