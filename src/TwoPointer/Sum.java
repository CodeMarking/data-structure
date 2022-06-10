package TwoPointer;


import java.util.Arrays;

/**
 * @author make
 */
public class Sum {


    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] result = {-1, -1};
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                result[0] = start + 1;
                result[1] = end = 1;
                break;
            }
        }
        return result;
    }

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int total = 0;
        // 遍历key的操作递减的处理。
        for (int k = nums.length - 1; k >= 2; k--) {
            int start = 0;
            int end = k - 1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[k]) {
                    total += (end - start);
                    end--;
                } else {
                    start++;
                }

            }
        }
        return total;
    }
}
