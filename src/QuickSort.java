public class QuickSort {
    public int[] sort(int[] nums) {
        quickSort(nums);
        return nums;
    }
    private void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        // always choose the nums[left] as pivot
        int pivot = nums[left];
        int index = partition(nums, pivot, left, right);
        quickSort(nums,left, index - 1);
        quickSort(nums, index + 1, right);
    }
    private int partition(int[] nums, int pivot, int left, int right) {
        // every number on the leftside of pivotIndex (excluding pivotIndex) are less or equal than pivot
        int pivotIndex = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, pivotIndex, i);
                pivotIndex++;
            }
        }
        swap(nums, left, pivotIndex - 1);
        return pivotIndex - 1;

    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }
}
