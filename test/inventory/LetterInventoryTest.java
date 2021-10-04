package inventory;

import org.junit.Test;

import static org.junit.Assert.*;

public class LetterInventoryTest {
    @Test
    public void testAdd(){
        LetterInventory inv = new LetterInventory();
        inv.add('a');
        inv.add('a');
        assertEquals(2, inv.get('a'));

        inv.add('?');
        assertEquals(-1, inv.get('?'));

        inv.add('a');
        assertEquals(-1, inv.get('-'));
    }

    @Test
    public void testSubtract(){
        LetterInventory inv = new LetterInventory();
        inv.add('a');
        inv.add('a');
        inv.subtract('a');
        assertEquals(1, inv.get('a'));
    }

    @Test
    public void testGet(){
        LetterInventory inv = new LetterInventory();
        assertEquals(0, inv.get('a'));

        inv.add('b');
        assertEquals(-1, inv.get('{'));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalSet(){
//        LetterInventory inv = new LetterInventory();
//        inv.set('c', -1);

        LetterInventory inv2 = new LetterInventory();
        inv2.set('{', 2);
    }

    @Test
    public void testSet(){
        LetterInventory inv = new LetterInventory();
        inv.set('a', 2);
        assertEquals(2, inv.get('a'));
    }

    @Test
    public void testContains(){
        LetterInventory inv = new LetterInventory();
        inv.add('d');
        assertTrue( inv.contains('d'));
    }

    @Test
    public void testSize(){
        LetterInventory inv = new LetterInventory();
        assertEquals(0, inv.size());

        inv.add('s');
        inv.add('z');
        inv.add('a');
        assertEquals(3, inv.size());

        inv.add('?');
        inv.add('#');
        assertEquals(3, inv.size());

        inv.subtract('z');
        assertEquals(2, inv.size());
    }

    @Test
    public void testIsEmpty(){
        LetterInventory inv = new LetterInventory();
        assertTrue(inv.isEmpty());

        inv.add('z');
        assertFalse(inv.isEmpty());

        inv.subtract('z');
        assertTrue(inv.isEmpty());

    }


}