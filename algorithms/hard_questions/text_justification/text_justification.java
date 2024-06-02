package algorithms.hard_questions.text_justification;

import java.util.ArrayList;
import java.util.List;

public class text_justification {
    public List<String> fullyJustify(String[] words, int maxWidth) {
        // Result to return and left_side justification word index.
        List<String> result = new ArrayList<>();
        int left_side = 0;
        
        // Loop through words to justify the text.
        while (left_side < words.length) {
            // Find the rightside word.
            int right_side = findRight(left_side, words, maxWidth);
            // Justify the left through right side words in words.
            result.add(justify(left_side, right_side, words, maxWidth));
            // Move to the next line of words.
            left_side = right_side + 1;
        }
        
        return result;
    }
    // Helper function to find the right word of the line of text.
    private int findRight(int left, String[] words, int maxWidth) {
        // Start by setting right to left, then we adjust right by looking at the length of prior words.
        int right = left;
        int sum = words[right++].length();
        
        // Loop through the words and add to right until the width becomes too large.
        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
            sum += 1 + words[right++].length();
            
        return right - 1;
    }
    
    // Helper function to text justify the words.
    private String justify(int left, int right, String[] words, int maxWidth) {
        // Special case if word meets width requirement.
        if (right - left == 0) return padResult(words[left], maxWidth);
        
        // Create variables for the lastline, the number of spaces we need to pad, and total space for bounding.
        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);
        
        // Find remainder and space.
        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remainder = isLastLine ? 0 : totalSpace % numSpaces;
        
        // Build justified line to return.
        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++)
            result.append(words[i])
                .append(space)
                .append(remainder-- > 0 ? " " : "");
        
        return padResult(result.toString().trim(), maxWidth);
    }
    
    // Helper function to calculate the length of words.
    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) wordsLength += words[i].length();
        return wordsLength;
    }
    // Helper function to format justified result to correct format.
    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }
    
    // Helper function to replace original chars with ' '.
    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }
}

class test_test_justification {
    public static void main(String[] args) {
        text_justification obj = new text_justification();

        // Example 1
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;
        List<String> solution1 = obj.fullyJustify(words1, maxWidth1);
        System.out.println(solution1);

        // Example 2
        String[] words2 = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth2 = 20;
        List<String> solution2 = obj.fullyJustify(words2, maxWidth2);
        System.out.println(solution2);
    }
}