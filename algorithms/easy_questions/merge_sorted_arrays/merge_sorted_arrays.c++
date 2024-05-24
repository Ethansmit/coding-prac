#include <vector>
#include <iostream>

using namespace std;

class merge_sorted_arrays {
    public:
        static void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
            int idx1 = m - 1;
            int idx2 = n - 1;
            int index = m + n - 1;

            while (idx1 != -1 && idx2 != -1) {
                if (nums1[idx1] >= nums2[idx2]) {
                    nums1[index--] = nums1[idx1--];
                } else {
                    nums1[index--] = nums2[idx2--];
                }
            }

            while (idx2 != -1) {
                nums1[index--] = nums2[idx2--];
            }

        }
};

int main() {
    // Example 1
    vector<int> nums1 = {1,2,3,0,0,0};
    int m = 3;
    vector<int> nums2 = {2,5,6};
    int n = 3;
    merge_sorted_arrays::merge(nums1, m, nums2, n);

    printf("Example 1: ");
    for (int value : nums1) {
        cout << value << " ";
    }

    printf("\n");
    // Example 2
    vector<int> nums3 = {0,0,0};
    m = 0;
    vector<int> nums4 = {1,12,13};
    n = 3;
    merge_sorted_arrays::merge(nums3, m, nums4, n);

    printf("Example 2: ");
    for (int value : nums3) {
        cout << value << " ";
    }


    return 0;
}