package goldDigger.models.discoverer;

import goldDigger.models.museum.Museum;

public class Geologist extends BaseDiscoverer{
    private static final double GEOLOGIST_DISCOVERER_STARTING_ENERGY = 100.0;

    public Geologist(String name) {
        super(name, GEOLOGIST_DISCOVERER_STARTING_ENERGY);
    }

    @Override
    public Museum getMuseum() {
        return null;
    }
}
