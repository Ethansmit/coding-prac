package algorithms.easy_questions.valid_palindrome;

public class valid_palindrome {
    public boolean isPalindrome(String s) {
        // Check if 's' is a string of spaces.
        if (s.isEmpty()) { return true; }

        // Pointers for two-pointer method.
        int start_ptr = 0;
        int end_ptr = s.length() - 1;

        // Loop through 's', comparing the two pointer vals. Skip non alphanumeric chars.
        while (start_ptr <= end_ptr) {
            char start_char = s.charAt(start_ptr);
            char end_char = s.charAt(end_ptr);

            if (!Character.isLetterOrDigit(start_char)) {
                start_ptr++;
            } else if (!Character.isLetterOrDigit(end_char)) {
                end_ptr--;
            } else { // Check if equal.
                if (Character.toLowerCase(start_char) != 
                    Character.toLowerCase(end_char)) { return false; }
                
                start_ptr++;
                end_ptr--;
            }
        }

        return true;
    }
}

class ValidPalindromeTest {
    public static void runTests(String[] testCases, boolean[] expectedResults) {
        valid_palindrome solution = new valid_palindrome();

        boolean correct = true;

        for (int i = 0; i < testCases.length; i++) {
            String testCase = testCases[i];
            boolean expected = expectedResults[i];
            boolean result = solution.isPalindrome(testCase);

            if (result != expected) {
                System.out.println("Test case " + (i + 1) + " failed!");
                System.out.println("Input: \"" + testCase + "\"");
                System.out.println("Expected: " + expected);
                System.out.println("Got: " + result);
                correct = false;
            }
        }

        if (correct) {
            System.out.println("All test cases passed.");
        }
    }

    public static void main(String[] args) {

        // Test cases
        String[] testCases = {
            "A man, a plan, a canal: Panama",
            "race a car",
            " ",
            "12321",
            "a",
            ".,!?",
            "No 'x' in Nixon",
            "Hello World!"
        };

        boolean[] expectedResults = {
            true,
            false,
            true,
            true,
            true,
            true,
            true,
            false
        };

        runTests(testCases, expectedResults);
    }
}