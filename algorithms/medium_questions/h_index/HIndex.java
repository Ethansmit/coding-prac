package algorithms.medium_questions.h_index;

public class HIndex {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] count = new int[len + 1];

        // Populate count.
        for (int c: citations)
            if (c > len) 
                count[len]++;
            else 
                count[c]++;
        
        // Loop from end of count, find h value going backwards.
        int total = 0;
        for (int i = len; i >= 0; i--) {
            total += count[i];
            if (total >= i)
                return i;
        }
        
        return 0;
    }    
}

class TestHIndex {
    public static void runTests(int[][] testCases, int[] expectedResults) {
        HIndex solution = new HIndex();

        boolean correct = true;

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int expected = expectedResults[i];
            int result = solution.hIndex(testCase);

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
        int[][] testCases = {
            {3, 0, 6, 1, 5},
            {1, 3, 1},
            {0},
            {1000},
            {5, 5, 5, 5, 5},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 7, 2, 8, 3, 5, 6, 1},
            {0, 0, 0, 0, 0, 0}
        };

        int[] expectedResults = {3, 1, 0, 1, 5, 5, 4, 0};

        runTests(testCases, expectedResults);
    }
}