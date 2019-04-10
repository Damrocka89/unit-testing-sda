package foo.bar.Dart;

public class Player {
    private String name;
    Dart501 dart501;


    public Player(String name) {
        this.name = name;
        dart501 = new Dart501();
    }

    public boolean win() {
        return dart501.score()==0;
    }

    public String getName() {
        return name;
    }
}
