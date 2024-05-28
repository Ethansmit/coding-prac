package algorithms.medium_questions.remove_duplicates_sorted_array_2;

class remove_dup_2 {
    public static int removeDuplicates(int[] nums) {
        // Checks if the duplicates need to be removed.
        if (nums.length <= 2) {
            return nums.length;
        }

        // Creates pointer to position of elements to remove.
        int ptr1 = 2;

        // Loop, creating second pointer, itterating through the array and removing dups.
        for (int ptr2 = 2; ptr2 <= nums.length - 1; ptr2++) {
            if (nums[ptr2] != nums[ptr1 - 2]) {
                nums[ptr1] = nums[ptr2];
                ptr1++;
            }

        }

        return ptr1;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {0,0,1,1,1,1,2,3,3};
        System.out.print("Example 1: ");
        System.out.println(removeDuplicates(nums1));

        // Example 2
        int [] nums2 = {0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1};
        System.out.print("Example 2: ");
        System.out.println(removeDuplicates(nums2));
    }
}