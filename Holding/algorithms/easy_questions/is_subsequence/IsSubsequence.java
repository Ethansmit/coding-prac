package algorithms.easy_questions.is_subsequence;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        // Check if pattern is substring.
        if (i == s.length()) {
            return true;
        }
        return false;
    }
}

class TestBestTimeBuySellStock {
    public static void runTests(String[] tArray, String[] sArray, boolean[] expectedArray) {
        IsSubsequence solution = new IsSubsequence();

        boolean correct = true;

        for (int i = 0; i < tArray.length; i++) {
            String t = tArray[i];
            String s = sArray[i];
            boolean result = solution.isSubsequence(s, t);
            boolean expected = expectedArray[i];

            if (result != expected) {
                System.out.println("Test case " + (i + 1) + " failed!");
                System.out.println("Input: \" t = " + t + " s = " + s + "\"");
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
        String[] tArray = {
            "ahbgdc",
            "ahbdgc",
            "asdlfkwa",
            "john",
            "",
            "hellotheremyfriend",
            "hellotherefriendmy",
            "aaaaaaaaaaaaaaaaaaaaaaa"
        };

        String[] sArray = {
            "abc",
            "axc",
            "",
            "john",
            "ea",
            "my",
            "my",
            "b"
        };

        boolean[] expectedResults = {true, false, true, true, false, true, true, false};

        runTests(tArray, sArray, expectedResults);
    }
}