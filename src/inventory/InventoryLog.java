package inventory;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The class tracks the ordering of the character places in the inventory
 *
 * @author Facsimile Nimely
 */
public class InventoryLog implements Inventory{
    ArrayList<Character> log;

    public InventoryLog(){
        log = new ArrayList<>();
    }

    @Override
    public void add(char c) {
        c = Character.toLowerCase(c);
        if(Character.isLetter(c))
            log.add(c);
    }

//    remove all occurrences of c from the arrayList
    @Override
    public void subtract(char c) {
        log.removeAll(Collections.singleton(c));
    }

    @Override
    public int get(char c) {
        int count = 0;
        if (Character.isLetter(c)){
            for (Character l :
                    log ) {
                if(l == c)
                    count++;
            }
            return count;
        }
        return -1;
    }


    /**
     * Makes c appears in the list count number of times
     *
     * If count is more than the number of Cs in the list, c is increased to count,
     * else, c is reduced to count
     *
     * @param c     character to update in inventory, throws IllegalArgumentException if character is not a letter
     * @param count number to update count with, throws IllegalArgumentException if negative
     */
    @Override
    public void set(char c, int count) {
        if(!Character.isLetter(c))
            throw new IllegalArgumentException(c + " is not a letter");
        if(count < 0)
            throw new IllegalArgumentException(c + " is less than 0");
        else{
            int num = 0;
            for (Character character : log) {
                if (c == character) {
                    num++;
                }
            }
            // determines if c should be increased, reduced, or removed entirely
            num = count - num;
            if(num > 0){
                for (int i = 0; i < num; i++){
                    log.add(c);
                }
            } else if(num < 0) {
                log.removeAll(Collections.singleton(c));
                for (int i = 0; i < count; i++){
                    log.add(c);
                }
            } else {
                log.removeAll(Collections.singleton(c));
            }
        }
    }

    @Override
    public boolean contains(char c) {
        return log.contains(c);
    }

    @Override
    public int size() {
        return log.size();
    }

    @Override
    public boolean isEmpty() {
        return log.size() == 0;
    }

    @Override
    public String toString(){
        StringBuilder stringReturn = new StringBuilder("[");
        for (Character character : log) {
            stringReturn.append(character);
        }
        return  stringReturn.append("]").toString();
    }
}
