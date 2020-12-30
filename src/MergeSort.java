public class MergeSort {
    public int[] sort(int[] nums) {
        mergeSort(nums);
        return nums;
    }
    private void mergeSort(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input can not be null!");
        }
        if (nums.length <= 1) {
            return;
        }
        int[] helperArray = new int[nums.length];
        mergeSort(nums, helperArray, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int[] helperArray, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, helperArray, left, mid);
        mergeSort(nums, helperArray, mid + 1, right);
        merge(nums, helperArray, left, mid, right);
    }
    private void merge(int[] nums, int[] helperArray, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int resIndex = left;
        while (leftIndex <= mid && rightIndex <= right) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                helperArray[resIndex++] = nums[leftIndex++];
            }else {
                helperArray[resIndex++] = nums[rightIndex++];
            }
        }
        while(leftIndex <= mid) {
            helperArray[resIndex++] = nums[leftIndex++];
        }

        while (rightIndex <= right) {
            helperArray[resIndex++] = nums[rightIndex++];
        }

        for (int i = left; i <= right; i++) {
            nums[i] = helperArray[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1,4,6,2,1,32,4};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
