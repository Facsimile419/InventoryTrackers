package inventory;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InventoryLogTest {
    @Test
    public void testAdd(){
        Inventory log = new InventoryLog();
        log.add('z');
        log.add('a');
        log.add('z');
        log.add('c');
        log.add('c');
        log.add('c');
        log.add('z');
        assertEquals(3, (char) log.get('z'));
    }

    @Test
    public void testSubtract(){
        Inventory log = new InventoryLog();
        log.add('z');
        log.add('z');
        log.add('a');
        log.add('c');
        log.add('c');
        log.add('z');
        log.subtract('z');
        assertEquals(0, log.get('z'));
        log.add('z');
    }

    @Test
    public void testGet(){
        Inventory log = new InventoryLog();
        log.add('z');
        log.add('z');
        log.add('a');
        log.add('c');
        log.add('z');
        assertEquals(3, log.get('z'));
    }

    @Test
    public void testSet(){
        Inventory log = new InventoryLog();
        log.add('z'); // 1
        log.add('z'); // 2
        log.add('a');
        log.add('c');
        log.add('z'); // 3

        log.set('z', 5);
        assertEquals(5, log.get('z'));

        log.set('z', 2);
        assertEquals(2, log.get('z'));

        log.set('z', 0);
        assertEquals(0, log.get('z'));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalSet(){
        Inventory log = new InventoryLog();
        log.set('-', 1);
    }

    @Test
    public void testContains(){
        Inventory log = new InventoryLog();
        log.add('z');
        log.add('z');
        log.add('a');
        log.add('c');
        log.add('z');
        assertTrue(log.contains('a'));
        assertFalse(log.contains('f'));
        assertTrue(log.contains('c'));
    }

    @Test
    public void testSize(){
        Inventory log = new InventoryLog();
        log.add('z');
        log.add('z');
        log.add('a');
        log.add('c');
        log.add('z');
        assertEquals(5, log.size());
    }

    @Test
    public void testIsEmpty(){
        Inventory log = new InventoryLog();
        assertTrue(log.isEmpty());
        log.add('z');
        log.add('z');
        log.add('a');
        log.add('c');
        log.add('c');
        log.add('z');
        assertFalse(log.isEmpty());
    }

    @Test
    public void testToString(){
        Inventory log = new InventoryLog();
        log.add('z');
        log.add('z');
        String logString = "[" + 'z' + 'z' + "]";
        assertEquals(logString, log.toString());

    }

}