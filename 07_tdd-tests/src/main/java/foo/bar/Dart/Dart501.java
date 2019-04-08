package foo.bar.Dart;

import java.util.ArrayList;

public class Dart501 {

    private int score = 501;
    private ArrayList<Integer> listOfUnscoredHits = new ArrayList<>();
    private ArrayList<Integer> listOfHits = new ArrayList<>();
    private int hitCount = 0;
    private int shotInRound = 0;

    public boolean hit(int points, CombinationsOfShield combination) {
        checkIfValueIsCorrect(points, combination);

        addHitToList(points, combination);

        int sum = getSumOfUnscoredHits();

        hitCount++;
        shotInRound++;

        if (score - sum == 0) {
            calculateAndUpdateScore();
            System.out.println("Game Over");
        } else if (score - sum < 0) {
            scoresHigherThanGlobalScoreToRemove();
        }
        if (shotInRound == 3) {
            calculateAndUpdateScore();
            shotInRound = 0;
        }
        return true;
    }

    private void scoresHigherThanGlobalScoreToRemove() {
        while (shotInRound > 0) {
            int index = listOfUnscoredHits.size() - shotInRound;
            listOfUnscoredHits.remove(index);
            shotInRound--;
        }
    }

    private int getSumOfUnscoredHits() {
        return listOfUnscoredHits.stream()
                    .reduce((a, b) -> (a + b))
                    .orElseGet(() -> 0);
    }

    private void calculateAndUpdateScore() {
        for (int i = listOfUnscoredHits.size() - shotInRound; i < listOfUnscoredHits.size();) {
            int temporary=listOfUnscoredHits.get(i);
            score = score - temporary;
            listOfHits.add(temporary);
            listOfUnscoredHits.remove(i);
        }
    }

    private void addHitToList(int points, CombinationsOfShield combination) {
        listOfUnscoredHits.add(points * combination.getMultiplayer());
    }

    private void checkIfValueIsCorrect(int points, CombinationsOfShield combination) {
        if (points < 1) {
            throw new IllegalArgumentException();
        }
        if (points > 20 && points != 50 && points != 25) {
            throw new IllegalArgumentException();
        }
        if (points == 25 && !combination.equals(CombinationsOfShield.MIDDLE25) || points == 50 && !combination.equals(CombinationsOfShield.BULLSEYE)) {
            throw new IllegalArgumentException();
        }
    }

    public int score() {
        return score;
    }
}
