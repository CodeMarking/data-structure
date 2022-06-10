package BinarySearch;

/**
 * @author make
 */
public class BasicBinarySearch {

    public static void main(String[] args) {
        int[] num = {1, 4, 7, 9, 10, 14, 16, 20, 56, 89};
        System.out.println(new BasicBinarySearch().getIndex(num, 5));
    }

    public int getIndex(int[] num, int target) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (num[mid] == target) {
                return mid;
            } else if (num[mid] > target) {
                start = mid;
            } else {
                end = mid;
            }

        }
        if (num[start] == target) {
            return start;
        }
        if (num[end] == target) {
            return end;
        }
        return -1;
    }

    public int search(int[] num, int target) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        int mid;
        while (start + 1 < end) {

            mid = start + (end - start) / 2;
            if (num[mid] == target) {
                return mid;
            }
            // ÉıĞò¼ä¸ôÀï¡£
            if (num[mid] > num[start]) {
                if (target <= num[mid] && num[start] <= target) {
                    end = mid;
                } else {
                    start = mid;
                }

            } else { // ½µĞò¼ä¸ô¡£
                if (target >= num[mid] && target <= num[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (num[start] == target) {
            return start;
        }
        if (num[end] == target) {
            return end;
        }
        return -1;

    }

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;

            if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else if (nums[mid] < nums[mid - 1]) {
                start = mid;
            } else {
                return mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }
}

