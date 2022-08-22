package goldDigger.models.discoverer;

import goldDigger.models.museum.Museum;

public class Archaelogist extends BaseDiscoverer{
    private static final double ARCHAELOGIST_DISCOVERER_STARTING_ENERGY = 60.0;
    public Archaelogist(String name){
        super(name, ARCHAELOGIST_DISCOVERER_STARTING_ENERGY);

    }

    @Override
    public Museum getMuseum() {
        return null;
    }
}
