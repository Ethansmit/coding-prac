#include <algorithm>
#include <iostream>
#include <vector>

class HeightChecker {
    public:
        int heightChecker(std::vector<int> &heights) {
            int maxHeight = *std::max_element(heights.begin(), heights.end());
            std::vector<int> freq(maxHeight + 1, 0);

            for (int height : heights) {
                freq[height]++;
            }

            // Build expected array from frequency.
            std::vector<int> expected;
            for (int i = 1; i <= maxHeight; ++i) {
                while (freq[i]-- > 0) {
                    expected.push_back(i);
                }
            }

            int count = 0;
            // Compare expected with heights.
            for (size_t i = 0; i < heights.size(); ++i) {
                if (heights[i] != expected[i]) {
                    count++;
                }
            }

            return count;
        }
};

void runTests(const std::vector<std::vector<int>> &inputs, const std::vector<int> &expectedOutputs) {
    HeightChecker obj;

    int correct = 1;
    for (size_t i = 0; i < inputs.size(); ++i) {
        std::vector<int> temp = inputs[i];
        int result = obj.heightChecker(temp);
        if (result != expectedOutputs[i]) {
            std::cout << "Test case " << i + 1 << " failed!" << std::endl;
            std::cout << "Expected: " << expectedOutputs[i] << std::endl;
            std::cout << "Got: " << result << std::endl;
            correct = 0;
        } 
    }
    if (correct) {
        std::cout << "All test cases passed." << std::endl;
    }
}

int main() {
    std::vector<std::vector<int>> inputs = {
        {1, 1, 4, 2, 1, 3},
        {1, 2, 3, 4, 5},
        {5, 1, 2, 3, 4},
        {2, 1, 2, 1, 1, 2, 2, 1},
        {3, 3, 3, 3}
    };
    
    std::vector<int> expectedOutputs = {
        3,
        0,
        5,
        4,
        0
    };

    runTests(inputs, expectedOutputs);

    return 0;
}