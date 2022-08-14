package football.entities.player;

public class Men extends BasePlayer{


    private static final double WEIGHT = 85.50;
    public Men(String name, String nationality, int strength) {
        super(name, nationality, WEIGHT, strength);
    }

    public void stimulation() {
        setStrength(getStrength() + 145);

    }
}


