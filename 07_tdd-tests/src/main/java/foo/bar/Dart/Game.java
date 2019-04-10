package foo.bar.Dart;

import java.util.ArrayList;
import java.util.Random;

import static foo.bar.Dart.CombinationsOfShield.SINGLE;

public class Game {

   private ArrayList<Player> players = new ArrayList<>();
   private Random random=new Random();


    public Game(ArrayList<Player> players) {
        this.players = players;

    }

    public void play() {
        int countPlayersPlaces=0;
        while (players.size()>0) {
            for (int i = 0; i < players.size(); i++) {
                for (int j = 0; j < 3; j++) {
                    players.get(i).dart501.hit(random.nextInt(19)+1,SINGLE);
                    if (players.get(i).win()){
                        System.out.println(players.get(i).getName()+" zakończyła grę w "+players.get(i).dart501.getNumberOfHits()+" rzutów.");
                        countPlayersPlaces++;
                        if (countPlayersPlaces==1){
                            System.out.println("Wygrała "+players.get(i).getName());
                        }
                        players.remove(i);
                        j=3;
                        i--;
                    }
                }

            }

        }
    }




}
