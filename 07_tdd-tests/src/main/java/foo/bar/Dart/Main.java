package foo.bar.Dart;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players= new ArrayList<>();
        players.add(new Player("Monia"));
        players.add(new Player("Ewcia"));
        Game game= new Game(players);
        game.play();
    }
}
