package algorithms.easy_questions.longest_palindrome;

import java.util.HashMap;
import java.util.Map;

public class longest_palindrome {
    public int longestPalindrome(String s) {
        // Var to store the count of odd counted chars in 's'.
        int odd_count = 0;
        // Map to store the counts of the chars in 's'.
        Map<Character, Integer> map = new HashMap<>();

        // Loop through 's' and count the number of occurences.
        for (char ch : s.toCharArray()) {
            // Count the instance of char.
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Check if the char in the map is odd. If so, add to odd_count, otherwise substract.
            if (map.get(ch) % 2 == 1) {
                odd_count++;
            } else {
                odd_count--;
            }
        }
        // Two cases:
        // If odd_count is greater than 1, then we can't use all the odd_count characters in the
        // longest palindrome. We subtract the number of odd_count from the length and then add one
        // for including one of the odd_count characters.
        if (odd_count > 1) {
            return s.length() - odd_count + 1;
        }
        // Otherwise the count is either all even for each char or one is an counted odd, which can
        // be included at the end.
        return s.length();
    }
    
}

class test_longest_palindrome {
    public static void main(String[] args) {
        // Testing object.
        longest_palindrome obj = new longest_palindrome();

        // Example 1, answer 7
        String s1 = "abccccdd";
        System.out.print("Example 1: ");
        System.out.println(obj.longestPalindrome(s1));

        // Example 2, answer 1
        String s2 = "a";
        System.out.print("Example 2: ");
        System.out.println(obj.longestPalindrome(s2));

        // Example 3, answer 5
        String s3 = "aaaaa";
        System.out.print("Example 3: ");
        System.out.println(obj.longestPalindrome(s3));

        // Example 4, answer 7
        String s4 = "aaaaabbb";
        System.out.print("Example 4: ");
        System.out.println(obj.longestPalindrome(s4));

        // Example 5, answer 1
        String s5 = "abcdefghijklmnopqrstuvwxyz";
        System.out.print("Example 5: ");
        System.out.println(obj.longestPalindrome(s5));

        // Example 6, answer 5
        String s6 = "Challengers";
        System.out.print("Example 6: ");
        System.out.println(obj.longestPalindrome(s6));

        // Example 7, answer 9
        String s7 = "AaaaAAAAaa";
        System.out.print("Example 7: ");
        System.out.println(obj.longestPalindrome(s7));

        // Example 8, answer 15
        String s8 = "aAmmMMamamaZafsZzzz";
        System.out.print("Example 8: ");
        System.out.println(obj.longestPalindrome(s8));
    }
}