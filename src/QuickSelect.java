public class QuickSelect {

    public int findKthLargest(int[] nums, int k) {
        // find KthLargest is find (nums.length - k)th smallest
        return findKthSmallest(nums, nums.length - k, 0, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int partition(int[] nums, int pivot, int left, int right) {
        int pivotIndex = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(nums, left, pivotIndex - 1);
        return pivotIndex - 1;
    }

    private int findKthSmallest(int[] nums, int k, int left, int right) {
        int pivot = nums[left];
        int pivotIndex = partition(nums, pivot, left, right);
        if (pivotIndex == k) {
            return nums[pivotIndex];
        }
        else if (pivotIndex > k) {
            return findKthSmallest(nums, k, left, pivotIndex - 1);
        }
        else {
            return findKthSmallest(nums, k, pivotIndex + 1, right);
        }

    }
}
