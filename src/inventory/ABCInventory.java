package inventory;

import java.util.*;
import java.io.*;

/**
 * This class will keep track of counts for the letters a,A,b,B,c,C
 */
public class ABCInventory implements Inventory  {
   // instance fields
   private int aCount;
   private int bCount;
   private int cCount;

   /**
    * default constructor initializes all counts to zero
    * Remember: java will provide this if we do not include in the file
    */
   public ABCInventory() {
      aCount = 0;
      bCount = 0;
      cCount = 0;
   }

   /**
    * increments the count of the character c in the inventory
    *
    * @param c character to track in inventory
    */
   @Override
   public void add(char c) {
      if(Character.isLetter(c)) {
         c = Character.toLowerCase(c);
         if (c == 'c')
            cCount++;
         else if (c == 'a')
            aCount++;
         else if (c == 'b')
            bCount++;
      }
   }

   /**
    * decrements the count of the character c in the inventory
    *
    * @param c character to track in inventory
    */
   @Override
   public void subtract(char c) {
      if(Character.isLetter(c))  {
         c= Character.toLowerCase(c);
         if (c == 'c' && cCount > 0)
            cCount--;
         else if (c == 'a' && aCount > 0)
            aCount--;
         else if (c == 'b' && bCount > 0)
            bCount--;
      }
   }

   /**
    * returns a count of the letter in the inventory, -1 otherwise
    *
    * @param c character in inventory
    * @return a count of the character in the inventory
    */
   @Override
   public int get(char c) {
      if(c == 'a')
         return aCount;
      else if(c == 'b')
         return bCount;
      else if (c == 'c')
         return cCount;
      return -1;
   }

   /**
    * updates the count of the character c in the inventory (if count is zero or greater)
    *
    * @param c     character to update in inventory, throws IllegalArgumentException if character not in inventory
    * @param count number to update count with, throws IllegalArgumentException if negative
    */
   @Override
   public void set(char c, int count) {
      c = Character.toLowerCase(c);
      if(count > 0 && (c == 'c' || c == 'a' || c == 'b')) {
         if (c == 'b')
            aCount += count;
         else if (c == 'a')
            bCount += count;
         else
            cCount += count;
      } else {
         throw new IllegalArgumentException(c + " is not a valid entry.");
      }
   }

   /**
    * returns true if character is contained in the inventory
    *
    * @param c character
    * @return true if character in inventory, false otherwise
    */
   @Override
   public boolean contains(char c) {
      return get(c) > 0;
   }

   /**
    * returns the sum of all counts in the inventory
    *
    * @return the total count
    */
   @Override
   public int size() {
      return aCount + bCount + cCount;
   }

   /**
    * Returns true if this inventory is empty (all counts are 0)
    *
    * @return true if all counts are 0, false otherwise
    */
   @Override
   public boolean isEmpty() {
      return size() ==  0;
   }


   /**
    *
    * @return a string representation of the counts for the letters AaBbCc
    * Example: [A=3, B=4, C=5]
    */
   public String toString() {
      return "[A=" + aCount + ", B=" + bCount + ", C=" + cCount + "]";
   }
}
