package algorithms.medium_questions.append_chars_to_make_subseq;

public class append_chars_to_make_subseq {
    public int appendCharacters(String s, String t) {
        // Two pointers for t and s to track subsequence pos in 's'.
        int t_pointer = 0, s_pointer = 0;

        // Length variables to make sure that we loop in bounds of 's' and 't'.
        int s_len = s.length(), t_len = t.length();

        // Loop through s and t, making sure to not go over.
        while (t_pointer < t_len && s_pointer < s_len) {
            // If the chars of s and t are equal, then we have found another
            // character to form the subsequence, hence we add one to t.
            if (s.charAt(s_pointer) == t.charAt(t_pointer)) {
                t_pointer++;
            }
            s_pointer++;
        }
        // Return number of characters needed to append to s to make t a subsequence.
        return t_len - t_pointer;
    }
}

class append_test {
    public static void main(String[] args) {
        append_chars_to_make_subseq obj = new append_chars_to_make_subseq();
        // Example 1, answer 4
        String s1 = "coaching", t1 = "coding";
        System.out.print("Example 1: ");
        System.out.println(obj.appendCharacters(s1, t1));

        // Example 2, answer 5
        String s2 = "z", t2 = "abcde";
        System.out.print("Example 2: ");
        System.out.println(obj.appendCharacters(s2, t2));

        // Example 3, answer 1
        String s3 = "abcde", t3 = "z";
        System.out.print("Example 3: ");
        System.out.println(obj.appendCharacters(s3, t3));

        // Example 4, answer 0
        String s4 = "z", t4 = "z";
        System.out.print("Example 4: ");
        System.out.println(obj.appendCharacters(s4, t4));

        // Example 5, asnwer 0
        String s5 = "abcde", t5 = "a";
        System.out.print("Example 5: ");
        System.out.println(obj.appendCharacters(s5, t5));

        // Example 6, answer 0
        String s6 = "abcdefghijklmnopqrstuvwxyz", t6 = "acjmuvz";
        System.out.print("Example 6: ");
        System.out.println(obj.appendCharacters(s6, t6));

        // Example 7, answer 25
        String s7 = "acjmuvz", t7 = "abcdefghijklmnopqrstuvwxyz";
        System.out.print("Example 7: ");
        System.out.println(obj.appendCharacters(s7, t7));
    }
}