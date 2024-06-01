#include <string>
#include <iostream>

class score_of_a_string {
    public:
        static int scoreOfString(std::string s) {
            int score = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                score += abs(s[i] - s[i+1]);
            }

            return score;
        }
};

int main() {
    // Example 1
    std::string s1 = "hello";
    int score1 = score_of_a_string::scoreOfString(s1);

    printf("Example 1: %d", score1);

    // Example 2
    std::string s2 = "zaz";

    int score2 = score_of_a_string::scoreOfString(s2);

    printf("Example 2: %d", score2);
}