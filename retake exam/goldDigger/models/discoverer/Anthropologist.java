package goldDigger.models.discoverer;

import goldDigger.models.museum.Museum;

public class Anthropologist extends BaseDiscoverer{
    private static final double ANTHROPOLOGIST_DISCOVERER_STARTING_ENERGY = 40.0;

    public Anthropologist(String name) {
        super(name, ANTHROPOLOGIST_DISCOVERER_STARTING_ENERGY);
    }

    @Override
    public Museum getMuseum() {
        return null;
    }
}
