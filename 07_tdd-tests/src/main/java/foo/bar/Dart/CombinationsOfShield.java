package foo.bar.Dart;

public enum CombinationsOfShield {
    SINGLE(1),
    TRIPPLE(3),
    DOUBLE(2),
    MIDDLE25(1),
    BULLSEYE(1);

    private int multiplayer;

    CombinationsOfShield(int multiplayer) {
        this.multiplayer = multiplayer;
    }

    public int getMultiplayer() {
        return multiplayer;
    }


}
