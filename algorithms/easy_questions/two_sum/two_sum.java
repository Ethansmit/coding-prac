import java.util.HashMap;
import java.util.Map;

public class two_sum {
    public static int[] brutFroce(int[] nums, int target) {
        // length of nums
        int length = nums.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] complements(int[] nums, int target) {
        Map<Integer, Integer> numDict = new HashMap<>();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int complement = target - nums[i];
            if (numDict.containsKey(complement)) {
                return new int[]{numDict.get(complement), i};
            }
            numDict.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] test1 = {5, 6, 12, 9, 13};
        int target1 = 14;
        int[] test2 = {1, 2, 3, 4, 5};
        int target2 = 7;

        int[] result1 = complements(test1, target1);
        int[] result2 = complements(test2, target2);

        for (int value : result1) {
            System.out.print(value + " ");
        }
        System.out.println();

        for (int value : result2) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}