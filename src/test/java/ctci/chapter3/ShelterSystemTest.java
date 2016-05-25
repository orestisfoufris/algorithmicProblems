package ctci.chapter3;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShelterSystemTest {

    private ShelterSystem shelterSystem;

    @BeforeMethod
    public void setup() {
        shelterSystem = new ShelterSystem();
    }

    @Test
    public void testDequeueAny() {
        populateShelter();

        assertEquals(shelterSystem.dequeueAny().getTimestamp(), 1);
        assertEquals(shelterSystem.dequeueAny().getTimestamp(), 2);
        assertEquals(shelterSystem.dequeueAny().getTimestamp(), 3);
        assertEquals(shelterSystem.dequeueAny().getTimestamp(), 4);
        assertEquals(shelterSystem.dequeueAny().getTimestamp(), 5);
        assertEquals(shelterSystem.dequeueAny().getTimestamp(), 6);

        assertTrue(shelterSystem.isEmpty());
    }

    @Test
    public void testDequeueOldestDog() {
        populateShelter();

        assertEquals(shelterSystem.dequeueDog().getTimestamp(), 1);
        assertEquals(shelterSystem.dequeueDog().getTimestamp(), 2);
        assertEquals(shelterSystem.dequeueDog().getTimestamp(), 3);
        assertEquals(shelterSystem.dequeueDog().getTimestamp(), 6);
        assertEquals(shelterSystem.size(), 2);
    }

    @Test
    public void testDequeueOldestCat() {
        populateShelter();

        assertEquals(shelterSystem.dequeueCat().getTimestamp(), 4);
        assertEquals(shelterSystem.dequeueCat().getTimestamp(), 5);
        assertEquals(shelterSystem.dequeueCat(), null);
        assertEquals(shelterSystem.size(), 4);
    }

    private void populateShelter() {
        shelterSystem.enqueue(new ShelterSystem.Dog(1));
        shelterSystem.enqueue(new ShelterSystem.Dog(2));
        shelterSystem.enqueue(new ShelterSystem.Dog(3));
        shelterSystem.enqueue(new ShelterSystem.Cat(4));
        shelterSystem.enqueue(new ShelterSystem.Cat(5));
        shelterSystem.enqueue(new ShelterSystem.Dog(6));
    }
}
