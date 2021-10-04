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
//        log.removeAll(Collections.singleton(c));
        ArrayList<Character> l = new ArrayList<>();
        l.add(c);
        log.removeAll(l);
    }

    // rest should behave similar to the methods in LetterInventory
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

    // may be decided, but solution should be sound and should include javadoc

    /**
     * Adds c to the list count number of times if c is a letter and count > 0
     *
     * @param c     character to update in inventory, throws IllegalArgumentException if character not in inventory
     * @param count number to update count with, throws IllegalArgumentException if negative
     */
    @Override
    public void set(char c, int count) {

        // method changes the count
        if(Character.isLetter(c) && count > 0){
            int num = 0;
            for (int i = 0; i < log.size(); i++){
                if(c == log.get(i)){
                    num++;
                }
            }
            num = count - num;
            if(num > 0){
                for (int i = 0; i < num; i++){
                    log.add(c);
                }
            } else if(num < 0) {
               while (num)/*for (int i = 0; i > num; num++)*/{
                    if(c == log.get(i)){
                        log.remove(i);
                        num++;
                        if(num == 0){
                            break;
                        }
                    }
//                    log.re(c);
                }
            }
        } else
            throw new IllegalArgumentException(c + " is not a valid entry.");
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

    }
}
