#include <iostream>
#include <vector>

class SubarraySumsDivisibleK {
    public:
        int subarraysDivByK(std::vector<int> &nums, int k) {
            int n = nums.size();
            std::vector<int> sums(k, 0);
            sums[0]++;

            int count = 0;
            int currentSum = 0;

            for(int i = 0; i<n; i++) {
                // Add to prefix sum and add to count.
                currentSum = (currentSum + nums[i]%k + k)%k;
                count += sums[currentSum];
                sums[currentSum]++;
            }
            return count;
        }
};

void runTests(std::vector<std::pair<std::vector<int>, int>> inputs, std::vector<int> expectedOutputs) {
    SubarraySumsDivisibleK obj = SubarraySumsDivisibleK();

    int correct = 1;
    for (size_t i = 0; i < inputs.size(); ++i) {
        int result = obj.subarraysDivByK(inputs[i].first, inputs[i].second);
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
    std::vector<std::pair<std::vector<int>, int>> inputs = {
        {{4, 5, 0, -2, -3 ,1}, 5},
        {{5}, 9},
        {{-1, 2, 9, -6, 3}, 4},
        {{7, 1, 5, 2, 8}, 6},
        {{0, 0, 0, 0}, 1},
        {{10, 20, -30, 40, 50}, 10},
        {{5, -5, 5, -5}, 5}
    };
    
    std::vector<int> expectedOutputs = {
        7,
        0,
        2,
        1,
        10,
        15,
        10,
    };

    runTests(inputs, expectedOutputs);

    return 0;
}