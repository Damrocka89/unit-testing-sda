package foo.bar.bowling;

public class BowlingGame {

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        this.rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score = score + 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int frame) {
        return rolls[frame] + rolls[frame + 1] == 10;
    }

    private int sumOfBallsInFrame(int frameIndex){
        return rolls[frameIndex]+rolls[frameIndex+1];
    }

    private boolean isStrike(int frameIndex){
        return rolls[frameIndex]==10;
    }

    private int strikeBonus(int frameIndex){
        return rolls[frameIndex+1]
                +spareBonus(frameIndex);
    }

    private int spareBonus(int frameIndex){
        return rolls[frameIndex+2];
    }
}
