#include <vector>
#include <iostream>
#include <algorithm>

class rotate_array {
    public:
        static void rotate(std::vector<int> &nums, int k) {
            // Ensure that k is within nums.size().
            k = k % nums.size();

            // Reverse all of nums.
            std::reverse(nums.begin(), nums.end());

            // Reverse the first k elements to represent taking the last k elements of nums
            // and moving it to the end.
            std::reverse(nums.begin(), nums.begin() + k);

            // Reverse the last nums.size() - k elements to represent shifting the elements
            // forward k times.
            std::reverse(nums.begin() + k, nums.end());

        }
};

int main() {
    // Example 1
    std::vector<int> nums1 = {1,2,3,4,5,6,7};
    int k = 3;

    rotate_array::rotate(nums1, k);
    
    for (int i = 0; i < nums1.size(); i++) {
        std::cout << nums1[i] << " ";
    }
    printf("\n");

    // Example 2
    std::vector<int> nums2 = {-1, 3, 99, 52, 60, -100, 120};
    k = 2;

    rotate_array::rotate(nums2, k);

    for (int i = 0; i < nums2.size(); i++) {
        std::cout << nums2[i] << " ";
    }
}