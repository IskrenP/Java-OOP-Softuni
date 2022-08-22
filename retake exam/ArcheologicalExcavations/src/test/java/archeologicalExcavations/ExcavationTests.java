package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {
    private Archaeologist chicken;
    private Archaeologist lion;
    private Excavation farm;

    @Before
    public void setUp() {
        chicken = new Archaeologist("Big", 1);
        lion = new Archaeologist("DDB", 10);
        farm = new Excavation("Softuni", 15);
    }




    @Test
    public void test_ShouldCreateArcheologist(){
       Excavation excavation = new Excavation("Softuni", 15);
        Assert.assertEquals("Softuni", excavation.getName());
        Assert.assertEquals(15, excavation.getCapacity());
        Assert.assertEquals(0, excavation.getCount());

    }
    @Test(expected = NullPointerException.class)
    public void test_ShouldThrowExceptionBecauseNameIsNull(){
        Excavation excavation = new Excavation("null", 15);

    }
    @Test(expected = NullPointerException.class)
    public void test_ShouldThrowExceptionBecauseNameIsWhitespace(){
        Excavation excavation = new Excavation("   ", 15);

    }
    @Test(expected = NullPointerException.class)
    public void test_ShouldThrowExceptionBecauseNameIsEmpty(){
        Excavation excavation = new Excavation("", 15);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_ShouldThrowExceptionBecauseCapacityIsNegative(){
        Excavation excavation = new Excavation("SoftUni", -15);

    }
    @Test
    public void test_AddShouldAddSuccess(){
        Excavation excavation = new Excavation("Softuni", 3);
        Archaeologist archaeologist = new Archaeologist("Big", 10);
        excavation.addArchaeologist(archaeologist);
        Assert.assertEquals(1, excavation.getCount());
        Archaeologist archaeologist1 = new Archaeologist("DDB", 50);
        excavation.addArchaeologist(archaeologist1);
        Assert.assertEquals(2, excavation.getCount());

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_ShouldThrowBecauseOfNoCapacity(){
        Excavation excavation = new Excavation("Softuni", 1);
        Archaeologist archaeologist = new Archaeologist("Big", 10);
        excavation.addArchaeologist(archaeologist);
        Archaeologist archaeologist1 = new Archaeologist("DDB", 50);
        excavation.addArchaeologist(archaeologist1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_AddShouldThrowBecauseOfArcheologistExists(){

        farm.addArchaeologist(chicken);
        farm.addArchaeologist(chicken);


    }
    @Test
    public void testRemoveShouldRemove(){
        farm.addArchaeologist(chicken);
        Assert.assertTrue(farm.removeArchaeologist(chicken.getName()));
        Assert.assertEquals(0, farm.getCount());


    }
    @Test
    public void testRemoveShouldNotRemove(){
        farm.addArchaeologist(lion);
        Assert.assertFalse(farm.removeArchaeologist(chicken.getName()));
        Assert.assertEquals(1, farm.getCount());


    }





}
