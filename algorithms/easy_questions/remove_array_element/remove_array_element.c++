#include <vector>
#include <iostream>

using namespace std;


class remove_array_element {
    public:
        static int removeElement(vector<int> &nums, int val) {
            if (nums.size() == 0) {
                return 0;
            }
            
            int index = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (nums[i] != val) {
                    nums[index] = nums[i];
                    index++;
                }
            }

            return index;
        }
};

int main() {
    // Example 1
    vector<int> nums1 = {5,4,3,2,5,3,5,2};
    int val1 = 5;
    
    printf("Example 1: ");
    cout << remove_array_element::removeElement(nums1, val1);

    printf("\n");
    // Example 2
    vector<int> nums2 = {3,2,2,3};
    int val2 = 3;
    
    printf("Example 2: ");
    cout << remove_array_element::removeElement(nums2, val2);
}