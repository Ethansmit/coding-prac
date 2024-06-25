package algorithms.medium_questions.append_chars_to_make_subseq;

public class AppendCharsToMakeSubseq {
    public int appendCharacters(String s, String t) {
        int tPointer = 0, sPointer = 0;
        int sLen = s.length(), tLen = t.length();

        while (tPointer < tLen && sPointer < sLen) {
            // If the chars of s and t are equal, then we have found another
            // character to form the subsequence, hence we add one to t.
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                tPointer++;
            }
            sPointer++;
        }
        return tLen - tPointer;
    }
}

class TestAppendCharsToMakeSubseq {
    public static void runTests(String[][] testCases, int[] expectedResults) {
        AppendCharsToMakeSubseq solution = new AppendCharsToMakeSubseq();

        boolean correct = true;

        for (int i = 0; i < testCases.length; i++) {
            String s = testCases[i][0];
            String t = testCases[i][1];
            int expected = expectedResults[i];
            int result = solution.appendCharacters(s, t);

            if (result != expected) {
                System.out.println("Test case " + (i + 1) + " failed!");
                System.out.println("Input: \" s = " + s + " t = " + t + "\"");
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
        // first string 's', second string 't'.
        String[][] testCases = {
            {"coaching", "coding"},
            {"z", "abcde"},
            {"abcde", "z"},
            {"z", "z"},
            {"abcde", "a"},
            {"abcdefghijklmnopqrstuvwxyz", "acjmuvz"},
            {"acjmuvz" , "abcdefghijklmnopqrstuvwxyz"}
        };

        int[] expectedResults = {4, 5, 1, 0, 0, 0, 25};

        runTests(testCases, expectedResults);
    }
}