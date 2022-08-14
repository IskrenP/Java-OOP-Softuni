package football.entities.player;

public class Women extends BasePlayer{

    private static final double WEIGHT = 60.00;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, WEIGHT, strength);
    }

    public void stimulation() {
        setStrength(getStrength() + 115);

    }
}

