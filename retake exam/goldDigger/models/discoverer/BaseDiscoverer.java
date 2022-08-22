package goldDigger.models.discoverer;

import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO;
import static goldDigger.common.ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY;

public abstract class BaseDiscoverer implements Discoverer {
    private String name;
    private double energy;
    private Museum museum;

    public BaseDiscoverer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        museum = new BaseMuseum();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(DISCOVERER_ENERGY_LESS_THAN_ZERO);

        }
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public double getEnergy() {
        return energy;
    }

    public void dig() {

        energy = Math.max(0, energy - 15);
    }

    @Override
    public boolean canDig() {
        return energy > 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_DISCOVERER_NAME, getName()));
        sb.append(System.lineSeparator());
        sb.append(String.format(FINAL_DISCOVERER_ENERGY, getEnergy()));
        sb.append(System.lineSeparator());
        if (getMuseum().getExhibits().isEmpty()) {
            sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None"));

        } else {
            sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, getMuseum().getExhibits())));

        }
        return sb.toString();
    }
}
