#include <string>

class length_of_last_word {
    public:
        static int lengthOfLastWord(std::string s) {
            // Initialize tail to move from the end of the string back.
            // Initialize length to return the length of the last word.
            int tail = s.size() - 1;
            int length = 0;

            // Loop through the back until we hit the first nonspace character.
            // This will move tail backwards until he hit the last character of the
            // last word.
            while (tail && s[tail] == ' ') { tail--;}

            // Loop backwards until he hit the first space character. Each time we
            // iterate back, we add to length, indiciating a new character in the final
            // word.
            while (tail >= 0 && s[tail--] != ' ') { length++; }

            // Return result.
            return length;
        }
};

int main() {
    // Example 1, answer 5
    std::string s1 = "Hello World";
    printf("Example 1: %d\n", length_of_last_word::lengthOfLastWord(s1));

    // Example 2, answer 7
    std::string s2 = "George is the coolest";
    printf("Example 2: %d\n", length_of_last_word::lengthOfLastWord(s2));

    // Example 3, answer 3
    std::string s3 = "Goodbye    to     you   ";
    printf("Example 3: %d\n", length_of_last_word::lengthOfLastWord(s3));

    // Example 4, answer 6
    std::string s4 = "Coding";
    printf("Example 4: %d\n", length_of_last_word::lengthOfLastWord(s4));

    // Example 5, answer 1
    std::string s5 = "a                         ";
    printf("Example 5: %d\n", length_of_last_word::lengthOfLastWord(s5));

    // Example 6, answer 1
    std::string s6 = "                          a";
    printf("Example 6: %d", length_of_last_word::lengthOfLastWord(s6));
}