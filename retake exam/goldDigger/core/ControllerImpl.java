package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaelogist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private SpotRepository spotRepository;
    private int exploredSpots;
    private DiscovererRepository discovererRepository;

    public ControllerImpl() {
        discovererRepository = new DiscovererRepository();
        spotRepository = new SpotRepository();
        exploredSpots = 0;

    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;
        switch(kind) {
            case "Archaelogist":
                discoverer = new Archaelogist(discovererName);
                break;
                case "Anthropologist":
                    discoverer = new Anthropologist(discovererName);
                    break;
                    case "Geologist":
                        discoverer = new Geologist(discovererName);
                        break;
                        default:
                            throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }
        discovererRepository.add(discoverer);
        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        for (String exhibitToBeAdded : exhibits) {
            spot.getExhibits().add(exhibitToBeAdded);
        }
        Collections.addAll(spot.getExhibits(), exhibits);
        spotRepository.add(spot);
        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discovererToRemove = discovererRepository.byName(discovererName);
        if (discovererToRemove == null) {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
        discovererRepository.remove(discovererToRemove);
        return String.format(DISCOVERER_EXCLUDE, discovererName);

    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> validExplorers = discovererRepository
                .getCollection()
                .stream()
                .filter(d -> d.getEnergy() > 45)
                .collect(Collectors.toList());
        if (validExplorers.isEmpty()){
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Spot spotToExplore = spotRepository.byName(spotName);
        Operation operation = new OperationImpl();
        operation.startOperation(spotToExplore, validExplorers);
        long countOfTiredExplorers = validExplorers.stream().filter(d -> d.getEnergy() == 0).count();
        exploredSpots++;
        return String.format(INSPECT_SPOT, spotName, countOfTiredExplorers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb  = new StringBuilder();
        sb.append(String.format(FINAL_SPOT_INSPECT,exploredSpots));
        sb.append(System.lineSeparator());
        sb.append(String.format(FINAL_DISCOVERER_INFO));
        sb.append(System.lineSeparator());


        sb.append(discovererRepository.toString());
        return sb.toString().trim();

    }
}
