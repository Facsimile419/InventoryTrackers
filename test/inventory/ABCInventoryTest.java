package inventory;

import org.junit.Test;

import static org.junit.Assert.*;

public class ABCInventoryTest {
    @Test
    public void testAdd(){
        ABCInventory inv = new ABCInventory();
        inv.add('a');
        assertEquals(-1, inv.get('e'));
    }

    @Test
    public void testSubtract(){
        ABCInventory inv = new ABCInventory();
        inv.add('a');
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalSet(){
        ABCInventory inv = new ABCInventory();
        inv.set('f', -1);
    }

    @Test
    public void testGet(){
        ABCInventory inv = new ABCInventory();
        inv.get('e');
        assertEquals(-1, inv.get('e'));
    }

    @Test
    public void testContains(){
        ABCInventory inv = new ABCInventory();
        inv.add('a');
        assertTrue(inv.contains('a'));
        assertFalse(inv.contains('c'));
    }

    @Test
    public void testSize(){
        ABCInventory inv = new ABCInventory();
        assertEquals(0, inv.size());
    }
}