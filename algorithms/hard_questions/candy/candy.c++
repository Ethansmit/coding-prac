#include <vector>
#include <iostream>

class Candy {
    public:
        static int candy(std::vector<int> &ratings) {
            // Assuming atleast one child is given, we initialize return value to 1.
            int ret = 1;
            int up = 0, down = 0, peak = 0;

            // Loop through the ratings.
            for (int i = 0; i < ratings.size() - 1; ++i) {
                // Temp values for comparisons.
                int prev = ratings[i];
                int curr = ratings[i + 1];

                if (prev < curr) { // Increasing ratings, more candy needed for current child.
                    up += 1;
                    down = 0;
                    peak = up;
                    ret += 1 + up;
                } else if (prev == curr) { //rate is the same, candy count is the same.
                    up = down = peak = 0;
                    ret += 1;
                } else { // rate is decreasing, less candy is needed because child is past peak child.
                    up = 0;
                    down += 1;
                    ret += 1 + down;
                    if (peak >= down) {
                        ret -= 1;
                    }
                }
            }
            return ret;
        }
};

int main() {
    // Example 1
    std::vector<int> ratings1 = {1,0,2};
    printf("Example 1: %d\n", Candy::candy(ratings1));

    // Example 2
    std::vector<int> ratings2 = {1,2,2};
    printf("Example 2: %d\n", Candy::candy(ratings2));
}