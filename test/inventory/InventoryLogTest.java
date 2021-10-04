package inventory;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InventoryLogTest {
    @Test
    public void testAdd(){
        ArrayList<Character> logs = new ArrayList<>();
        logs.add('z');
        assertEquals('z', (char) logs.get(0));
    }

//    @Test
//    public void testSubtract(){
//        ArrayList<Character> logs = new ArrayList<>();
//        logs.add('z');
//        logs.add('z');
//        logs.add('a');
//        logs.subtract('z');
//
//        logs.add('z');
//    }

    @Test
    public void testGet(){

    }

}