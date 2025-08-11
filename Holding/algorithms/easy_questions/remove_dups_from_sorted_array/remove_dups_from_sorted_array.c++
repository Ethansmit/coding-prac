#include <iostream>
#include <vector>

class remove_dups_from_sorted_array {
    public:
        static int removeDups(std::vector<int> &nums) {
            // Assume that there is atleast one unique value.
            int index = 1;

            for (int i = 1; i < nums.size(); i++) {
                // Check for uniqueness, if so set index to i. Else val is overwritten.
                if (nums[i] != nums[i - 1]) {
                    nums[index] = nums[i];
                    index++;
                }
            }
            return index;
        }
};

int main() {
    // Example 1
    std::vector<int> nums1 = {0,0,1,2,3};
    printf("Example 1: %d\n", remove_dups_from_sorted_array::removeDups(nums1));

    // Example 2
    std::vector<int> nums2 = {0,0,0,0,1,1,1,1,1,2,2,5,6,7,7};
    printf("Example 2: %d", remove_dups_from_sorted_array::removeDups(nums2));
}