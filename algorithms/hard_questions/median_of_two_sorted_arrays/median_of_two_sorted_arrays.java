package algorithms.hard_questions.median_of_two_sorted_arrays;

public class median_of_two_sorted_arrays {
    private static int p1 = 0, p2 = 0;

    // Merge sort approach.
    public static double findMedian1(int[] nums1, int[] nums2) {
        int m = nums1.length; int n = nums2.length;
        if ((m + n) % 2 == 0) {
            for (int i = 0; i < (m + n) / 2 - 1; ++i) {
                getMin(nums1, nums2);
            }
            return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
        } else {
            for (int i = 0; i < (m + n) / 2; ++i) {
                getMin(nums1, nums2);
            }
            return getMin(nums1, nums2);
        }
    }

    // Helper function to obtain the smaller value based on length of input arrays.
    private static int getMin(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length) {
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        } else if (p1 < nums1.length) {
            return nums1[p1++];
        } else if (p2 < nums2.length) {
            return nums2[p2++];
        }
        return -1;
    }
    
    public static double findMedian2(int[] nums1, int[] nums2) {
        // Swap nums arrays if nums1 is larger.
        if (nums1.length > nums2.length) {
            return findMedian2(nums2, nums1);
        }
        // Establish boundaries for partitioning index.
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            // Compute partition indexes of A and B.
            int partA = (left + right) / 2;
            int partB = (m + n + 1) / 2 - partA;

            // Obtain edge elements.
            int max_left_A = (partA == 0) ? Integer.MIN_VALUE : nums1[partA - 1];
            int min_right_A = (partA == m) ? Integer.MAX_VALUE : nums1[partA];
            int max_left_B = (partB == 0) ? Integer.MIN_VALUE : nums2[partB - 1];
            int min_right_B = (partB == n) ? Integer.MAX_VALUE : nums2[partB];

            // Compare edge elements.
            if (max_left_A <= min_right_B && max_left_B <= min_right_A) { // It true, we can return the median based on either conditions.
                if ((m + n) % 2 == 0) { // Average edge elements to obtain median.
                    return (
                        (Math.max(max_left_A, max_left_B) + Math.min(min_right_A, min_right_B)) / 2.0
                    );
                } else { // Median value is the max of the smaller half.
                    return Math.max(max_left_A, max_left_B);
                }
            } else if (max_left_A > min_right_B) { // maxLeftA is too large to be in smaller half, move to left half of search space.
                right = partA - 1;
            } else { // minRightA is too far left, move to the right side of search space.
                left = partA + 1;
            }
        }
        return 0.0;
    }
    
    
    public static void main(String[] args) {
        //Example 1
        int[] nums1 = {2,3,5,7,9};
        int[] nums2 = {2,5,5,8,10};

        System.out.println(findMedian1(nums1, nums2));
        System.out.println(findMedian2(nums1, nums2));

        //Example 2
        p1 = 0;
        p2 = 0;
        int[] nums3 = {1,2};
        int[] nums4 = {3,4};

        System.out.println(findMedian1(nums3, nums4));
        System.out.println(findMedian2(nums3, nums4));
    }
}
