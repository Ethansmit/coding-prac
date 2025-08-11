#include <vector>
#include <iostream>

class jump_game {
    public:
        static bool canJump(std::vector<int> &nums) {
            // Initial reach will be index 0.
            int reach = 0;

            for (int i = 0; i < nums.size(); i++) {
                // Check if we can reach the index, if not, we cannot continue
                // down array and we must return false.
                if (reach < i)
                    return false;
                
                // Update the reach at every index, checking if the current index's
                // jump reach is better than what we have. If so, then choose the current
                // otherwise keep current reach.
                reach = std::max(reach, i + nums[i]);
            }
            //
            return true;
        }
};

int main() {
    // Example 1
    std::vector<int> nums1 = {2,3,1,1,4};
    printf("Example 1: %d", jump_game::canJump(nums1));


    // Example 2
    std::vector<int> nums2 = {3,2,1,0,4};
    printf("Example 2: %d", jump_game::canJump(nums2));
}