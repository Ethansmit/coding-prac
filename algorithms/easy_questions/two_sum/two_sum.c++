#include <iostream>
#include <unordered_map>
#include <vector>

class Solution {
public:
    static std::vector<int> bruteForce(const std::vector<int> &nums, int target) {
        // length of nums
        int length = nums.size();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return {i, j};
                }
            }
        }
        return {};
    }

    static std::vector<int> complements(const std::vector<int> &nums, int target) {
        // map for storing values.
        std::unordered_map<int, int> numDict;
        int length = nums.size();

        // Find complements
        for (int i = 0; i < length; i++) {
            int complement = target - nums[i];
            if (numDict.find(complement) != numDict.end()) {
                return {numDict[complement], i};
            }
            numDict[nums[i]] = i;
        }

        // No Solution
        return {};
    }
};

int main() {
    std::vector<int> test1 = {5,6,12,9,13};
    int target1 = 14;
    std::vector<int> test2 = {1,2,3,4,5};
    int target2 = 7;

    std::vector<int> result1 = Solution::complements(test1, target1);
    std::vector<int> result2 = Solution::complements(test2, target2);

    for (int value : result1) {
        std::cout << value << " ";
    }
    std::cout << std::endl;

    for (int value : result2) {
        std::cout << value << " ";
    }

    return 0;
}