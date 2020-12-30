public class InsertionSort {
    public int[] sort(int[] nums) {
        insertionSort(nums);
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void insertionSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int globalMinIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[globalMinIndex]) {
                    globalMinIndex = j;
                }
            }
            swap(nums, i, globalMinIndex);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,4,5,-2};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
