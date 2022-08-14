package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {
    private final static String TEAM_NAME = "F1";
    private final static int TEAM_CAPACITY = 3;
    private final static int PLAYERS_COUNT = 2;
    private final static String NAME_OF_FIRST_PLAYER = "Iskren";
    private final static String NAME_OF_SECOND_PLAYER = "Stivi";
    private final static String REMOVE_AND_SALE_PLAYER = "Stivi";
    private final static String NULL_REMOVE_AND_SALE_PLAYER = "Tiram";
    private final static String TEAM_STATS = "The footballer Iskren, Stivi is in the team F1 ";

    private FootballTeam teamTests;
    private Footballer firstFootballer;
    private Footballer secondFootballer;

    @Before
    public void setUp() {
        teamTests = new FootballTeam(TEAM_NAME, TEAM_CAPACITY);

        firstFootballer = new Footballer(NAME_OF_FIRST_PLAYER);
        secondFootballer = new Footballer(NAME_OF_SECOND_PLAYER);

        teamTests.addFootballer(firstFootballer);
        teamTests.addFootballer(secondFootballer);
        teamTests.removeFootballer("Stivi");
        teamTests.addFootballer(secondFootballer);
    }

    @Test
    public void getName() {
        Assert.assertEquals(TEAM_NAME, teamTests.getName());
    }


    @Test(expected = IllegalArgumentException.class)
    public void setInvalidCapacity() {
        FootballTeam testHouse = new FootballTeam("Test FootballTeam", -5);
    }
    @Test
    public void getCount() {
        Assert.assertEquals(TEAM_CAPACITY, teamTests.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void addFootballerInFullTeam() {
        teamTests.addFootballer(firstFootballer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeFootballerWithNullName() {
        teamTests.removeFootballer(NULL_REMOVE_AND_SALE_PLAYER);
    }


    @Test
    public void sellExistingFootballer() {
        Assert.assertEquals(secondFootballer, teamTests.footballerForSale(REMOVE_AND_SALE_PLAYER));
        Assert.assertFalse(teamTests.footballerForSale(REMOVE_AND_SALE_PLAYER).isActive());
    }
    @Test(expected = IllegalArgumentException.class)
    public void sellFootballerNotPresent() {
        teamTests.footballerForSale(NULL_REMOVE_AND_SALE_PLAYER);
    }

    @Test
    public void setTeamNameStats() {
        Assert.assertEquals(TEAM_STATS, teamTests.getStatistics());
    }

    @Test
    public void getCapacity() {
        Assert.assertEquals(TEAM_CAPACITY, teamTests.getVacantPositions());
    }
}
