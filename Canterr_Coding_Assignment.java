
import java.io.*;
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {

  public static void main(String[] args) {
    int[] nums = {10, 5, 7, 9, 2, 6, 12};
    int target = 13;

    twoSum(nums, target);

    System.out.println();
    if (canFormPalindrome("cv.v??i^i--c"))
            System.out.println("Yes - Palindrome");
        else
            System.out.println("No - Palindrome");
   
  }

         //problem1: Give an array of Strings, find if these strings can become palindromes by shuffling the characters:
   //ex: civic, cviic, cvviic are palindromes, cvic is not 
   /* 
   - "ci v ?? -- iC" should return **`true`**
   - "ivicc" should return **`true`**
   - "civil" should return **`false`**
   - "livci" should return **`false`**  
   special character remove, case sensitive
 */

/* function to check whether characters
    of a string can form a palindrome */
public static boolean canFormPalindrome(String string){
  // Remove special character
  String str = string.replaceAll("[?@,^]*", "");

   int NO_OF_CHARS = 256;
 
        // Create a count array and initialize all values as 0
        int count[] = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);
 
        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (int i = 0; i < str.length(); i++)
            count[(int)(str.charAt(i))]++;
 
        // Count odd occurring characters
        int odd = 0;
        for (int i = 0; i < NO_OF_CHARS; i++) {
            if ((count[i] & 1) == 1)
                odd++;
 
            if (odd > 1)
                return false;
        }
 
        // Return true if odd count is 0 or 1,
        return true;
}

  //problem 2: Given an array of numbers and a target number, find the 2 numbers in the array that add upto this number, print them and their indexes.
  //{10, 5, 7, 9, 2, 6, 12}, target = 13

public static void twoSum(int[] nums, int target){
  // create an empty HashMap
        Map<Integer, Integer> map = new HashMap<>();
 
        // do for each element
        for (int i = 0; i < nums.length; i++)
        {
          int firstValue = target - nums[i];
            // check if pair (nums[i], target-nums[i]) exists
 
            // if the difference is seen before, print the pair
            if (map.containsKey(target - nums[i]))
            {
              // Print index of Elements that adds upto target
                int index = ArrayUtils.indexOf(nums, firstValue);
                System.out.println("Index of Pair found (" + index +", "+ i+ ")");

              // Print Elements that adds upto target
                System.out.printf("Value of Pair found (%d, %d)",
                    nums[map.get(target - nums[i])], nums[i]);
                return;
            }
 
            // store index of the current element in the map
            map.put(nums[i], i);
        }
 
        // we reach here if the pair is not found
        System.out.println("Pair not found");

  }
}
